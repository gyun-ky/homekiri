package com.example.homekiri.user.model;

import com.example.homekiri.user.dto.PostSignInReq;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="User")
public class User {
    @Id
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

    public User(PostSignInReq postSignInReq, String password){
        this.email = postSignInReq.getEmail();
        this.password = password;
        this.nickName = postSignInReq.getNickname();
    }

}
