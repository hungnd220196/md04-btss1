package com.ra.demo_springboot.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    String uploadToLocal(MultipartFile multipartFile);

    String uploadToFirebase(String localPath);
}
