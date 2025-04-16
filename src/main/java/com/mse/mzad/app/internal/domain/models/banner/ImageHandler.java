package com.mse.mzad.app.internal.domain.models.banner;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;
import java.nio.file.StandardCopyOption;

public class ImageHandler {

    public static String saveImage(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get("storage/banners");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileName = LocalDateTime.now() +"_"+UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }

    public static  void deleteImage(String imagePath) {
        File file = new File(imagePath);
        file.delete();
    }
}
