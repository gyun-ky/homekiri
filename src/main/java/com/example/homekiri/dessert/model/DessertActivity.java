package com.example.homekiri.dessert.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="Dessert")
@Entity
public class DessertActivity {

    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name="drinkIdx")
    private Long drinkIdx;

    @Column(name="nonDrinkIdx")
    private Long nonDrinkIdx;


    @Column(name="dessertName")
    private String dessertName;

    @Column(name="description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private DessertImage dessertImage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private Drink drink;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private NonDrink nonDrink;


    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public DessertActivity(Long idx, Long drinkIdx, Long nonDrinkIdx, String dessertName , String description,  LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.drinkIdx = drinkIdx;
        this.nonDrinkIdx = nonDrinkIdx;
        this.dessertName = dessertName;
        this.description = description;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
