package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.FoodActivity;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class FoodActivityResponseDto {

    private Long idx;
    private Long countryIdx;
    private String foodName;
    private String description;
    private String ingredient;
    private String recipe;
    private String temperature;
    private String cookingState;

    public FoodActivityResponseDto(FoodActivity entity){
        this.idx = entity.getIdx();
        this.countryIdx = entity.getCountryIdx();
        this.foodName = entity.getFoodName();
        this.description = entity.getDescription();
        this.ingredient = entity.getIngredient();
        this.recipe = entity.getRecipe();
        this.temperature = entity.getTemperature();
        this.cookingState = entity.getCookingState();
    }
}
