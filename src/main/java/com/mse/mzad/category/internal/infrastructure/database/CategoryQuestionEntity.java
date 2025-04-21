package com.mse.mzad.category.internal.infrastructure.database;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.QuestionType;
import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category_questions")
@Setter
@Getter
public class CategoryQuestionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    private String question;
    @Enumerated(EnumType.STRING)
    private QuestionType type;
    private String answer;

    public CategoryQuestionEntity() {
    }

    public CategoryQuestionEntity(
            CategoryEntity category,
            String question,
            QuestionType type,
            String answer
    ) {
        this.category = category;
        this.question = question;
        this.type = type;
        this.answer = answer;
    }

    public CategoryQuestionEntity(
            Long id,
            CategoryEntity category,
            String question,
            QuestionType type,
            String answer
    ) {
        this.id = id;
        this.category = category;
        this.question = question;
        this.type = type;
        this.answer = answer;
    }
}
