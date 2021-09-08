package com.example.homekiri.recommendation.Dto;

import com.example.homekiri.dessert.model.DessertActivity;
import com.example.homekiri.dessert.model.DessertImage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DessertRecommendDto {
    private Long idx;
    private String dessertName;
    private String Category;
    private List<String> imgUrl;

    public DessertRecommendDto(DessertActivity entity1){
        this.idx = entity1.getIdx();
        this.dessertName = entity1.getDessertName();

        if(entity1.getDrink().getIdx() != -1)
            this.Category = "음료";
        else
            this.Category = "디저트";
        this.imgUrl = new ArrayList<>();
        for(DessertImage url: entity1.getDessertImageList())
            imgUrl.add(url.getImgUrl());
    }
}
