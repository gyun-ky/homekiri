package com.example.homekiri.dashboard.Dto;

import com.example.homekiri.dashboard.model.FoodTrend;
import lombok.Getter;

@Getter
public class FoodTrendListResponseDto {

    private Long idx;
    private Long foodIdx;
    private String foodName;

    public FoodTrendListResponseDto(FoodTrend entity){
        this.idx = entity.getId();
        this.foodIdx = entity.getFoodIdx();
        this.foodName = entity.getFoodName();
    }
}
