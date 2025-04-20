package com.mse.mzad.category.internal.api;

import com.mse.mzad.category.internal.application.commands.category.CreateCategory;
import com.mse.mzad.category.internal.application.commands.category.UpdateCategory;
import com.mse.mzad.category.internal.application.commands.category.UploadImageCategory;
import com.mse.mzad.category.internal.application.queries.category.DeleteCategory;
import com.mse.mzad.category.internal.application.queries.category.ReadCategory;
import com.mse.mzad.category.internal.domain.dtos.category.CategoryResponse;
import com.mse.mzad.category.internal.domain.dtos.category.CreateCategoryRequest;
import com.mse.mzad.category.internal.domain.dtos.category.UpdateCategoryRequest;
import com.mse.mzad.category.internal.domain.models.Category;
import com.mse.mzad.shared.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CreateCategory createCategory;
    @Autowired
    private UploadImageCategory uploadImage;
    @Autowired
    private UpdateCategory updateCategory;
    @Autowired
    private DeleteCategory deleteCategory;
    @Autowired
    private ReadCategory readCategory;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String, CategoryResponse>> create(@RequestBody CreateCategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Category Created Successfully", createCategory.create(request)));
    }

    @PostMapping(value = "/upload-image/{categoryId}", consumes = "multipart/form-data")
    public ResponseEntity<BaseResponse<String, Void>> uploadImage(@RequestParam MultipartFile imageFile, @PathVariable("categoryId") long categoryId) {
        uploadImage.upload(imageFile, categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Image Uploaded Successfully", null));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<String, CategoryResponse>> update(@RequestBody UpdateCategoryRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Category Updated Successfully", updateCategory.update(request)));
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<BaseResponse<String, Void>> delete(@PathVariable("categoryId") long categoryId) {
        deleteCategory.delete(categoryId);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Category Deleted Successfully", null));
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<String, List<Category>>> all() {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "All Categories", readCategory.all()));
    }
}
