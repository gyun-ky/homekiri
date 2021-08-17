package com.example.homekiri.recommendation.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.recommendation.service.RecommendListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/recommendation")
public class RecommendListController {
    private final RecommendListService recommendListService;

    @ResponseBody
    @GetMapping("/{UserIdx}")
    public BaseResponse<HashMap<String, Object>> returnRecommendList(@PathVariable Long UserIdx){
        try{
            HashMap<String, Object> result = recommendListService.recommend(UserIdx);
            return new BaseResponse<>(result);
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
