package com.example.homekiri.recommendation.Dto.ActivityRecommendDto;

import com.example.homekiri.recommendation.model.activity.FoodActivity;
import com.example.homekiri.recommendation.model.activity.Info.FoodImage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
public class FoodRecommendDto {
    private Long idx;
    private String category;
    private String foodName;
    private String imgUrl;


    public FoodRecommendDto(FoodActivity entity, FoodImage entity2){
        this.idx = entity.getIdx();
        this.category = CountryIdxToString(entity.getCountryIdx());
        this.foodName = entity.getFoodName();
        this.imgUrl = entity2.getImgUrl();
    }


    public String CountryIdxToString(Long idx){
        if(idx == 1) return "한식";
        else if(idx == 2) return "일식";
        else if(idx == 3) return "중식";
        else  return "양식";
    }
}
