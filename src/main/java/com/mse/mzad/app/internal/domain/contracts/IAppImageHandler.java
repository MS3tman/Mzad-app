package com.mse.mzad.app.internal.domain.contracts;

import org.springframework.web.multipart.MultipartFile;

public interface IAppImageHandler {
    String saveImage(MultipartFile file, String storageLocation);
    void deleteImage(String imagePath);
}
