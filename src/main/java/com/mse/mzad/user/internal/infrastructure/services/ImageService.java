package com.mse.mzad.user.internal.infrastructure.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Component
public class ImageService {
    @Value("${storage.avatar.path}")
    private String storagePath;

    public String store(String imageEncoded) throws IOException {
        //do decode for imageEncoded
        String imageDataBytes = imageEncoded.replaceFirst("^data:image/[^;]*;base64,", "");
        byte[] imageFile =  Base64.getDecoder().decode(imageDataBytes);

        //create storage directory
        Path uploadPath = Paths.get(storagePath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique file name (e.g., using the current timestamp or UUID)
        String imageName = "avatar_" + UUID.randomUUID().toString() + System.currentTimeMillis() + ".jpg"; // Change the extension based on the image type

        // Create file path to store it in DB
        Path imagePath = uploadPath.resolve(imageName);

        // Write the byte array to the file
        Files.write(imagePath,imageFile);

        return imagePath.toString();
    }
}
