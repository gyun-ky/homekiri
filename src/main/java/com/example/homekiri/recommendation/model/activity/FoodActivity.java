package com.example.homekiri.recommendation.model.activity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    //자료형 확인: List형태
    @Column(name="recipe")
    private String recipe;

    //자료형 확인: String or Int
    @Column(name="temparture")
    private String temperature;

    @Column(name="cookingState")
    private String cookingState;


    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

}

