package com.example.homekiri.recommendation.Dto.ActivityRecommendDto;

import com.example.homekiri.model.Food.FoodActivity;
import com.example.homekiri.model.Food.FoodImage;
import lombok.Getter;

@Getter
public class FoodRecommendDto {
    private Long idx;
    private String category;
    private String foodName;
    private String imgUrl;


    public FoodRecommendDto(FoodActivity entity){
        this.idx = entity.getIdx();
        this.category = CountryIdxToString(entity.getCountryIdx());
        this.foodName = entity.getFoodName();
        this.imgUrl = entity.getFoodImage().getImgUrl();
    }


    public String CountryIdxToString(Long idx){
        if(idx == 1) return "한식";
        else if(idx == 2) return "일식";
        else if(idx == 3) return "중식";
        else  return "양식";
    }
}
