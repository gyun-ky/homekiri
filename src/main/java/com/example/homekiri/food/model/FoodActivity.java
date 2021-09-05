package com.example.homekiri.food.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="Food")
@Entity
public class FoodActivity {
    @Id
    @Column(name="idx")
    private Long idx;

    @Column(name="countryIdx")
    private Long countryIdx;

    @Column(name="foodName")
    private String foodName;

    @Column(name="description")
    private String description;

    @Column(name="ingredient")
    private String ingredient;

    @Column(name="recipe")
    private String recipe;

    @Column(name="temparture")
    private String temperature;

    @Column(name="cookingState")
    private String cookingState;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx", updatable = false, insertable = false)
    private FoodImage foodImage;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public FoodActivity(Long idx, Long countryIdx, String foodName, String description , String ingredient, String recipe, String temperature, String cookingState, LocalDateTime updatedAt,LocalDateTime createdAt ){
        this.idx = idx;
        this.countryIdx = countryIdx;
        this.foodName = foodName;
        this.description = description;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.temperature = temperature;
        this.cookingState = cookingState;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}

