package com.example.homekiri.recommendation.Dto.preference;

import com.example.homekiri.model.preferences.FoodPreference;
import lombok.Getter;

@Getter
public class FoodPreferenceDto {
    private Long idx;
    private Long userIdx;
    private Long china;
    private Long japan;
    private Long western;
    private Long korea;
    private Long noodle;
    private Long pork;
    private Long beef;
    private Long chicken;
    private Long rice;
    private Long seaFood;
    private Long soup;
    private Long temperature;
    private Long raw;
    private Long roasted;

    public FoodPreferenceDto(FoodPreference entity){
        this.idx = entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.china = entity.getChina();
        this.japan = entity.getJapan();
        this.western = entity.getWestern();
        this.korea = entity.getKorea();
        this.noodle = entity.getNoodle();
        this.pork = entity.getPork();
        this.beef = entity.getBeef();
        this.chicken = entity.getChicken();
        this.rice  = entity.getRice();
        this.seaFood = entity.getSeaFood();
        this.soup = entity.getSoup();
        this.temperature = entity.getTemperature();
        this.raw = entity.getRaw();
        this.roasted = entity.getRoasted();
    }
}
