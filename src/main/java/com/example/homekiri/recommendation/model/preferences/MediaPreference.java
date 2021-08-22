package com.example.homekiri.recommendation.model.preferences;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "MediaPreference")
public class MediaPreference {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "horror")
    private Long horror;

    @Column(name = "romance")
    private Long romance;

    @Column(name = "comedy")
    private Long comedy;

    @Column(name = "crime")
    private Long crime;

    @Column(name = "fantasy")
    private Long fantasy;

    @Column(name = "drama")
    private Long drama;

    @Column(name = "action")
    private Long action;

    @Column(name = "scienceFiction")
    private Long scienceFiction;

    @Column(name = "animation")
    private Long animation;

    @Column(name = "tvShow")
    private Long tvShow;

    @Column(name = "classic")
    private Long classic;

    @Column(name = "netflix")
    private Long netflix;

    @Column(name = "wave")
    private Long wave;

    @Column(name = "watcha")
    private Long watcha;

    @Column(name = "tving")
    private Long tving;

    @Column(name = "tvn")
    private Long tvn;


    @Column(name = "jtbc")
    private Long jtbc;

    @Column(name = "mbc")
    private Long mbc;

    @Column(name = "sbs")
    private Long sbs;

    @Column(name = "kbs")
    private Long kbs;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

}
