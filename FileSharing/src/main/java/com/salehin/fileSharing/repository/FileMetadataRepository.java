package com.salehin.fileSharing.repository;

import com.salehin.fileSharing.entity.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FileMetadataRepository extends JpaRepository<FileMetadata, UUID> {



    Optional<FileMetadata> findByOtp(String otp);
    Optional<FileMetadata> findByStoredFileName(String storedFileName);
    List<FileMetadata> findByUploadTimeBefore(LocalDateTime threshold);
}
