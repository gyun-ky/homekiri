package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.user.model.GetMypageRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @ResponseBody
//    @GetMapping("/{userIdx}/mypage")
//    public BaseResponse<GetMypageRes> getMypage(){
//
//        return new BaseResponse<>(BaseResponseStatus.INVALID_JWT);
//
//        try{
//            GetMypageRes result = userService.getMypage();
//            return new BaseResponse<>(result);
//        }
//        catch (BaseException e){
//            return new BaseResponse<>(e.getStatus());
//        }
//    }
}
