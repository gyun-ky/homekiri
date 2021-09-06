package com.example.homekiri.like.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LikeFoodDto {

    private Long foodIdx;

    private String foodName;

    private String category;

    private String foodImageUrl;

}
