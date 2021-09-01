package com.example.homekiri.survey.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "MediaPreference")
public class MediaSurvey {
    @Id
    @Column(name = "idx")
    @GeneratedValue
    private Long idx;

    private Long useridx;

    private int animation;

    private int classic;

    private int comedy;

    private int crime;

    private int fantasy;

    private int horror;

    private int jtbc;

    private int kbs;

    private int mbc;

    private int netflix;

    private int romance;

    private int sbs;

    private int scienceFiction;

    private int tvShow;

    private int tving;

    private int tvn;

    private int watcha;

    private int wave;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

}
