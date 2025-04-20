package com.mse.mzad.category.internal.domain.contracts;

import org.springframework.web.multipart.MultipartFile;

public interface ICategoryImageHandler {
    String saveImage(MultipartFile file, String storageLocation);
    void deleteImage(String imagePath);
}
