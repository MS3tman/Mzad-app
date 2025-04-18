package com.mse.mzad.account.internal.api.controllers;

import com.mse.mzad.account.internal.application.command.user.UploadImage;
import com.mse.mzad.shared.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UploadImage uploadImage;

    @PostMapping(value = "/image/upload", consumes = "multipart/form-data")
    public ResponseEntity<BaseResponse<String, String>> uploadImage(@RequestParam MultipartFile imageFile) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Image Uploaded Successfully", uploadImage.save(imageFile)));
    }
}
