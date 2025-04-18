package com.mse.mzad.account.internal.application.command.user;

import com.mse.mzad.account.internal.domain.contracts.IUserImageHandler;
import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.models.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadImage {
    private final IUserRepo userRepo;
    private final IUserImageHandler userImageHandler;

    public UploadImage(IUserRepo userRepo, IUserImageHandler userImageHandler) {
        this.userRepo = userRepo;
        this.userImageHandler = userImageHandler;
    }

    public String save(MultipartFile imageFile) {
        if(imageFile.isEmpty()) {
            throw new RuntimeException("Missing Image");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User existUser = userRepo.findByEmail(email);
        if(existUser == null) {
            throw new RuntimeException("User not Found");
        }
        String existImagePath = existUser.getUserImage().getImagePath(); // for delete it
        existUser.getUserImage().setImagePath(userImageHandler.saveImage(imageFile, "avatar"));
        User user = userRepo.update(existUser);
        userImageHandler.deleteImage(existImagePath);
        return user.getUserImage().getImagePath();
    }
}
