package com.mse.mzad.category.internal.infrastructure.database;

import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Setter
@Getter
public class CategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryEntity parent;
//    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
//    private List<CategoryEntity> children = new ArrayList<>();
    private String image;

    public CategoryEntity() {
    }

    public CategoryEntity(
            String title,
            CategoryEntity parent,
            String image
    ) {
        this.title = title;
        this.parent = parent;
        this.image = image;
    }

    public CategoryEntity(
            Long id,
            String title,
            CategoryEntity parent,
            String image
    ) {
        this.id = id;
        this.title = title;
        this.parent = parent;
        this.image = image;
    }
}
