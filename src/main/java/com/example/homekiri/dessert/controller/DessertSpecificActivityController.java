package com.example.homekiri.dessert.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.dessert.Dto.DessertActivityResponseDto;
import com.example.homekiri.dessert.service.DessertActivityDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/details")
public class DessertSpecificActivityController {

    private final DessertActivityDetailsService dessertActivityDetailsService;


    /*
     * 디저트 상세 설명 API
     * [GET] /web/dessert/{idx}
     * @param Long
     * @return BaseResponse<DessertActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/dessert/{idx}")
    public BaseResponse<DessertActivityResponseDto> returnDessertActivity(@PathVariable Long idx){
        try{
            System.out.println(idx);
            DessertActivityResponseDto result = dessertActivityDetailsService.findById(idx);
            System.out.println(result);
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
