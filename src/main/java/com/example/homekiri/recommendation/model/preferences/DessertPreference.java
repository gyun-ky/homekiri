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
@Table(name = "DessertPreference")
public class DessertPreference {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "coffee")
    private Long coffee;

    @Column(name = "nonCoffee")
    private Long nonCoffee;

    @Column(name = "tea")
    private Long tea;

    @Column(name = "smoothie")
    private Long smoothie;

    @Column(name = "fruit")
    private Long fruit;

    @Column(name = "bakery")
    private Long bakery;

    @Column(name = "withIce")
    private Long withIce;

    @Column(name = "hot")
    private Long hot;

    @Column(name = "cold")
    private Long cold;

    @Column(name = "sweet")
    private Long sweet;

    @Column(name = "sour")
    private Long sour;

    @Column(name = "bitter")
    private Long biiter;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;


}
