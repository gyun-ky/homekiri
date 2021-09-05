package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.model.Food.FoodActivity;
import com.example.homekiri.model.Food.FoodImage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
public class FoodActivityResponseDto {

    private Long idx;
    private String country;
    private String foodName;
    private String description;
    private String ingredient;
    private List<String> recipe;
    private String temperature;
    private String cookingState;
    private String imgUrl;

    public FoodActivityResponseDto(FoodActivity entity){
        this.idx = entity.getIdx();
        this.country = CountryIdxToString(entity.getCountryIdx());
        this.foodName = entity.getFoodName();
        this.description = entity.getDescription();
        this.ingredient = entity.getIngredient();
        this.recipe = Parsing(entity.getRecipe());
        this.temperature = entity.getTemperature();
        this.cookingState = entity.getCookingState();
        this.imgUrl = entity.getFoodImage().getImgUrl();
    }

    //recipe parsing by "delim"
    public List<String> Parsing(String Input){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(Input, "delim");
        while(st1.hasMoreTokens()){
            res.add(st1.nextToken());
        }
        return res;
    }

    public String CountryIdxToString(Long idx){
        if(idx == 1) return "한식";
        else if(idx == 2) return "일식";
        else if(idx == 3) return "중식";
        else  return "양식";
    }
}
