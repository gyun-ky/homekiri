package com.example.homekiri.recommendation;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.library.JwtService;
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
    private final JwtService jwtService;

    /**
     JWT 인증 메서드
     @param String JWT
     @return BOOLEAN
     */
    public boolean jwtAuth(Long userIdx) throws BaseException{
        try {
            Long jwtUserIdx = this.jwtService.getUserIdx();
            if(jwtUserIdx == userIdx){
                return true;
            }
            else{
                return false;
            }
        }catch (BaseException e){
            throw new BaseException(e.getStatus());
        }

    }

    /**
     * 사용자 추천 리스트 API
     * [GET] /web/recommendation/{userIdx}
     * @param Long userIdx, size
     * @return BaseResponse<HashMap<String, Object>>
     * if activity.size() < RECOMMEND_SIZE Throw PREFERENCE_LACK_ERROR
     */
    @ResponseBody
    @GetMapping("/{userIdx}/{size}")
    public BaseResponse<HashMap<String, Object>> returnRecommendList(@PathVariable Long userIdx, @PathVariable Long size){

        //jwt 인증
        try {
            if (!jwtAuth(userIdx)) {
                throw new BaseException(BaseResponseStatus.INVALID_USER_JWT);
            }
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

        try{
            HashMap<String, Object> result = recommendListService.recommend(userIdx, size);
            return new BaseResponse<>(result);
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
