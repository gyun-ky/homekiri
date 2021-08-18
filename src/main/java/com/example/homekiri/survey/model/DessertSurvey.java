package com.example.homekiri.survey.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "DessertPreference")
public class DessertSurvey {
    @Id
    @Column(name = "idx")
    private Long idx;

    private Long userIdx;

    private int coffee;

    private int nonCoffee;

    private int tea;

    private int smoothie;

    private int fruit;

    private int bakery;

    private int withice;

    private int hot;

    private int cold;

    private int sweet;

    private int sour;

    private int bitter;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

}
