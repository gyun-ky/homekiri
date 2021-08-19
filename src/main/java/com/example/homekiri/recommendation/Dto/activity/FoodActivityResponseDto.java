package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.FoodActivity;
import lombok.Getter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
public class FoodActivityResponseDto {

    private Long idx;
    private Long countryIdx;
    private String foodName;
    private String description;
    private String ingredient;
    private List<String> recipe;
    private String temperature;
    private String cookingState;

    public FoodActivityResponseDto(FoodActivity entity){
        this.idx = entity.getIdx();
        this.countryIdx = entity.getCountryIdx();
        this.foodName = entity.getFoodName();
        this.description = entity.getDescription();
        this.ingredient = entity.getIngredient();
        this.recipe = Parsing(entity.getRecipe());
        this.temperature = entity.getTemperature();
        this.cookingState = entity.getCookingState();
    }

    //recipe parsing by "delim"
    public List<String> Parsing(String r){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(r, "delim");
        while(st1.hasMoreTokens()){
            res.add(st1.nextToken());
        }
        return res;
    }
}
