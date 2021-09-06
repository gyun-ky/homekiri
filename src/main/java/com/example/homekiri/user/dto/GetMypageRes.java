package com.example.homekiri.user.dto;

import com.example.homekiri.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetMypageRes {
    private String nickname;
    private String profileImageUrl;


}


