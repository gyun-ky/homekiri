package com.example.homekiri.user.model;

import com.example.homekiri.user.dto.PostSignInReq;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
//외래키 preference랑 설정
@Entity
@Table(name="User")
@Setter
@Getter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private String email;

    private String password;

    private String profileImg = null;

    private String nickName;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    public User(){}
    public User(PostSignInReq postSignInReq, String password){
        this.email = postSignInReq.getEmail();
        this.password = password;
        this.nickName = postSignInReq.getNickname();
    }

}
