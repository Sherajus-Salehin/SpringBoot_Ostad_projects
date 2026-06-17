package com.salehin.fileSharing.service;

import com.salehin.fileSharing.entity.FileMetadata;
import com.salehin.fileSharing.repository.FileMetadataRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
public class FileService {

    private final FileMetadataRepository fileMetadataRepository;
    private final Path fileStorageLocation;
    private final SecureRandom secureRandom = new SecureRandom();

    public FileService(@Value("${file.upload-dir:uploads}") String uploadDir,
                       FileMetadataRepository fileMetadataRepository) {
        this.fileMetadataRepository = fileMetadataRepository;
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Transactional
    public String storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Failed to store empty file.");
        }

        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null) {
            throw new IllegalArgumentException("Original file name cannot be null.");
        }
    String cleanedOriginalFileName = Paths.get(originalFileName).getFileName().toString();
        String fileExtension = "";
        int lastDotIndex = cleanedOriginalFileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            fileExtension = cleanedOriginalFileName.substring(lastDotIndex);
        }
        String storedFileName = UUID.randomUUID().toString() + fileExtension;
        Path targetLocation = this.fileStorageLocation.resolve(storedFileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        String otp = generateUniqueOtp();

        FileMetadata metadata = new FileMetadata();
        metadata.setOriginalFileName(cleanedOriginalFileName);
        metadata.setStoredFileName(storedFileName);
        metadata.setOtp(otp);
        metadata.setUploadTime(LocalDateTime.now());
        metadata.setUsed(false);
        fileMetadataRepository.save(metadata);
        return otp;
    }
    @Transactional
    public String validateOtp(String otp) {
        FileMetadata metadata = fileMetadataRepository.findByOtp(otp)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OTP."));

        if (metadata.isUsed()) {
            throw new IllegalStateException("This OTP has already been used.");
        }
        if (metadata.getUploadTime().isBefore(LocalDateTime.now().minusMinutes(10))) {
            throw new IllegalStateException("This OTP has expired (exceeded 10-minute validity window).");
        }
 metadata.setUsed(true);
        fileMetadataRepository.save(metadata);
        return "http://localhost:8080/api/files/download/" + metadata.getStoredFileName();
    }

    @Scheduled(cron = "0 */1 * * * *") // Runs every minute
    @Transactional
    public void cleanupFiles() {
        LocalDateTime threshold = LocalDateTime.now().minusMinutes(10);
        List<FileMetadata> expiredFiles = fileMetadataRepository.findByUploadTimeBefore(threshold);
        if (expiredFiles.isEmpty()) {
            return;
        }
        for (FileMetadata metadata : expiredFiles) {
            try {
                Path filePath = this.fileStorageLocation.resolve(metadata.getStoredFileName()).normalize();
                Files.deleteIfExists(filePath);
            } catch (IOException ex) {
                System.err.println("Could not delete physical file: " + metadata.getStoredFileName() + " - " + ex.getMessage());
            }
        }
        fileMetadataRepository.deleteAllInBatch(expiredFiles);
        //System.out.println("Cleaned up " + expiredFiles.size() + " expired file records and physical files.");
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Resource> downloadFile(String storedFileName) {
        FileMetadata metadata = fileMetadataRepository.findByStoredFileName(storedFileName)
                .orElseThrow(() -> new IllegalArgumentException("File metadata not found."));

        File file = this.fileStorageLocation.resolve(metadata.getStoredFileName()).toFile();
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + metadata.getOriginalFileName() + "\"")
                .body(resource);
    }


    private String generateUniqueOtp() {
        String otp;
        boolean exists = true;
        
        do {
            int numericValue = secureRandom.nextInt(1000000); // 0 to 999999
            otp = String.format("%06d", numericValue);
            exists = fileMetadataRepository.findByOtp(otp).isPresent();
        } while (exists);

        return otp;
    }
}
