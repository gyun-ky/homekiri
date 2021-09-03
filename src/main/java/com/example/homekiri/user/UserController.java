package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.library.JwtService;
import com.example.homekiri.user.dto.PostLogInReq;
import com.example.homekiri.user.dto.PostLogInRes;
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
     * 회원가입 API
     * [POST] /web/users
     * @return BaseResponse<PostSignInRes>
     */
    @ResponseBody
    @PostMapping("/sign-in")
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

    /**
     * 로그인 API
     * [POST] /web/users/log-in
     * @return BaseResponse<PostLogInRes>
     */
    @ResponseBody
    @PostMapping("/log-in")
    public BaseResponse<PostLogInRes> logIn(@RequestBody PostLogInReq postLogInReq){
        try{
            PostLogInRes result = userService.logIn(postLogInReq.getEmail(), postLogInReq.getPassword());
            return new BaseResponse<>(result);
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 마이페이지 API
     * [GET] /web/users/mypage/{userIdx}
     * @return BaseResponse<GetMypageRes>
     */
//    public BaseResponse<GetMypageRes> mypage(@PathVariable Long userIdx){
//
//    }



}
