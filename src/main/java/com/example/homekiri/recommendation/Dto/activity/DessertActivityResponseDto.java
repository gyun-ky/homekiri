package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.DessertActivity;
import lombok.Getter;

@Getter
public class DessertActivityResponseDto {
    private Long idx;
    private Long drinkIdx;
    private Long nonDrinkIdx;
    private String dessertName;
    private String description;

    public DessertActivityResponseDto(DessertActivity entity){
        this.idx = entity.getIdx();
        this.drinkIdx = entity.getDrinkIdx();
        this.nonDrinkIdx = entity.getNonDrinkIdx();
        this.dessertName = entity.getDessertName();
        this.description = entity.getDescription();;
    }

}
