package com.mse.mzad.category.internal.application.commands.category;

import com.mse.mzad.category.internal.domain.contracts.ICategoryImageHandler;
import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadImageCategory {
    private final ICategoryRepo categoryRepo;
    private final ICategoryImageHandler categoryImageHandler;

    public UploadImageCategory(ICategoryRepo categoryRepo, ICategoryImageHandler categoryImageHandler) {
        this.categoryRepo = categoryRepo;
        this.categoryImageHandler = categoryImageHandler;
    }

    public void upload(MultipartFile imageFile, long categoryId) {
        Category existCategory = categoryRepo.findById(categoryId);
        if(existCategory == null) {
            throw new RuntimeException("Category not found");
        }
        if (existCategory.getImage() == null) {
            String imagePath = categoryImageHandler.saveImage(imageFile, "categories");
            existCategory.setImage(imagePath);
            categoryRepo.update(existCategory);
        } else {
            categoryImageHandler.deleteImage(existCategory.getImage());
            String imagePath = categoryImageHandler.saveImage(imageFile, "categories");
            existCategory.setImage(imagePath);
            categoryRepo.update(existCategory);
        }

    }
}
