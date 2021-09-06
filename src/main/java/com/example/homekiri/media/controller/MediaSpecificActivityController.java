package com.example.homekiri.media.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.media.Dto.MediaActivityResponseDto;
import com.example.homekiri.media.service.MediaActivityDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/details")
public class MediaSpecificActivityController {


    private final MediaActivityDetailsService mediaActivityDetailsService;

    /*
     * 미디어 상세 설명 API
     * [GET] /web/media/{idx}
     * @param Long
     * @return BaseResponse<MediaActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/media/{idx}")
    public BaseResponse<MediaActivityResponseDto> returnMediaActivity(@PathVariable Long idx){
        try{
            MediaActivityResponseDto result = mediaActivityDetailsService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
