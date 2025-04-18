package com.mse.mzad.shared.services;

import com.mse.mzad.account.internal.domain.contracts.IUserImageHandler;
import com.mse.mzad.app.internal.domain.contracts.IAppImageHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;
import java.nio.file.StandardCopyOption;

@Component
public class ImageHandler implements IUserImageHandler,  IAppImageHandler {

    public String saveImage(MultipartFile file, String storageLocation) {
        Path uploadPath = Paths.get("storage/" + storageLocation);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = LocalDateTime.now() + "_" + UUID.randomUUID() + "_" + getFileExtension(file.getOriginalFilename());
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException ex) {
            throw new RuntimeException("Failed to save image: " + ex.getMessage(), ex);
        }
    }

    private String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return ""; // or throw an exception if extension is mandatory
        }
        return filename.substring(filename.lastIndexOf(".")).toLowerCase();
    }

    public void deleteImage(String imagePath) {
        File file = new File(imagePath);
        file.delete();
    }
}
