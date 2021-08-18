package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.user.dto.PostSignInReq;
import com.example.homekiri.user.dto.PostSignInRes;
import com.example.homekiri.user.model.User;
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

    /**
     * 회원가입 API
     * [POST] /web/users
     * @return BaseResponse<PostSignInRes>
     */
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostSignInRes> signIn(@RequestBody PostSignInReq postSignInReq){
        int userIdx;

        try{
            String encodedPassWord = userService.encodePassWord(postSignInReq.getPassword());
            User user = new User(postSignInReq, encodedPassWord);
            userIdx = UserService.signIn(user)
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
