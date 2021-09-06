package com.example.homekiri.dessert.Dto;

import com.example.homekiri.dessert.model.DessertActivity;
import lombok.Getter;

@Getter
public class DessertActivityResponseDto {
    private Long idx;
    private Long drinkIdx;
    private Long nonDrinkIdx;
    private String dessertName;
    private String description;
    private String imgUrl;

    public DessertActivityResponseDto(DessertActivity entity1){
        this.idx = entity1.getIdx();
        this.drinkIdx = entity1.getDrinkIdx();
        this.nonDrinkIdx = entity1.getNonDrinkIdx();
        this.dessertName = entity1.getDessertName();
        this.description = entity1.getDescription();
        this.imgUrl = entity1.getDessertImage().getImgUrl();
    }

   
}
