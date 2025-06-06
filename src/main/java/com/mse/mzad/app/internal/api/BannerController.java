package com.mse.mzad.app.internal.api;

import com.mse.mzad.app.internal.application.commands.banner.CreateBanner;
import com.mse.mzad.app.internal.application.commands.banner.DeleteBanner;
import com.mse.mzad.app.internal.application.commands.banner.UpdateBanner;
import com.mse.mzad.app.internal.application.queries.banner.ReadBanner;
import com.mse.mzad.app.internal.domain.models.Banner;
import com.mse.mzad.shared.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/banner")
public class BannerController {
    @Autowired
    private CreateBanner createBanner;
    @Autowired
    private UpdateBanner updateBanner;
    @Autowired
    private DeleteBanner deleteBanner;
    @Autowired
    private ReadBanner readBanner;

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<BaseResponse<String, Banner>> create(@RequestParam String title, @RequestParam MultipartFile imageFile) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Banner Created Successfully", createBanner.create(title, imageFile)));
    }

    @PutMapping(value = "/update", consumes = "multipart/form-data")
    public ResponseEntity<BaseResponse<String, Banner>> update(@RequestParam long id, @RequestParam String title, @RequestParam MultipartFile imageFile) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Banner Updated Successfully",updateBanner.update(id, title, imageFile)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse<String, Void>> delete(@PathVariable long id) {
        deleteBanner.delete(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Banner Deleted Successfully", null));
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<String, List<Banner>>> all() {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "All Banners", readBanner.all()));
    }
}
