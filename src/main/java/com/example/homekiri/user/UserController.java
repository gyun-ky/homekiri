package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.library.JwtService;
import com.example.homekiri.user.dto.PostSignInReq;
import com.example.homekiri.user.dto.PostSignInRes;
import com.example.homekiri.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }



    /**
     * 회원가입 API
     * [POST] /web/users
     * @return BaseResponse<PostSignInRes>
     */
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostSignInRes> signIn(@RequestBody PostSignInReq postSignInReq){

        try{
            String encodedPassWord = userService.encodePassWord(postSignInReq.getPassword());
            User user = new User(postSignInReq, encodedPassWord);
            Long userIdx = userService.signIn(user);
            String jwt = jwtService.createJwt(userIdx);
            PostSignInRes result = new PostSignInRes(userIdx, jwt);
            return new BaseResponse<>(result);
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
