package com.salehin.fileSharing.controller;

import com.salehin.fileSharing.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.storeFile(file));
    }
    @GetMapping("/verify/{otp}")
    public ResponseEntity<?> verifyOtp(@PathVariable String otp) {
        return ResponseEntity.ok(fileService.validateOtp(otp));
    }

    @GetMapping("/download/{storedFileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String storedFileName) {
        return fileService.downloadFile(storedFileName);
    }
}
