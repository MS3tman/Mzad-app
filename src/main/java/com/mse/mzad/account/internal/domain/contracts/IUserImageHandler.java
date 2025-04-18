package com.mse.mzad.account.internal.domain.contracts;

import org.springframework.web.multipart.MultipartFile;

public interface IUserImageHandler {
    String saveImage(MultipartFile file, String storageLocation);
    void deleteImage(String imagePath);
}
