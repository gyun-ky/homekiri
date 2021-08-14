package com.example.homekiri.recommendation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/recommendation")
public class RecommendListController {

    @ResponseBody
    @GetMapping("/{UserIdx}")
    public long returnRecommendList(@PathVariable Long UserIdx){
        return 315;
    }
}
