package com.mse.mzad.app.internal.api.controllers;

import com.mse.mzad.app.internal.application.commands.banner.CreateBanner;
import com.mse.mzad.app.internal.domain.dtos.banner.CreateRequest;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/banner")
public class BannerController {
    @Autowired
    private CreateBanner createBanner;

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<BaseResponse<String, Banner>> create(@RequestParam("title") String title,
                                                               @RequestParam("image") MultipartFile image) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Banner Created Successfully", createBanner.create(title, image)));
    }

}
