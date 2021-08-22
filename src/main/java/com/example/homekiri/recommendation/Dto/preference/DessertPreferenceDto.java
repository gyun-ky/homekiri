package com.example.homekiri.recommendation.Dto.preference;

import com.example.homekiri.recommendation.model.preferences.DessertPreference;
import lombok.Getter;

@Getter
public class DessertPreferenceDto {
    private Long idx;
    private Long userIdx;
    private Long coffee;
    private Long nonCoffee;
    private Long tea;
    private Long smoothie;
    private Long fruit;
    private Long bakery;
    private Long withIce;
    private Long hot;
    private Long cold;
    private Long sweet;
    private Long sour;
    private Long bitter;

    public DessertPreferenceDto(DessertPreference entity){
        this.idx = entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.coffee = entity.getCoffee();
        this.nonCoffee = entity.getNonCoffee();
        this.tea = entity.getTea();
        this.smoothie = entity.getSmoothie();
        this.fruit = entity.getFruit();
        this.bakery = entity.getBakery();
        this.withIce = entity.getWithIce();
        this.hot = entity.getHot();
        this.cold = entity.getCold();
        this.sweet  =entity.getSweet();
        this.sour = entity.getSour();
        this.bitter = entity.getBitter();
    }
}
