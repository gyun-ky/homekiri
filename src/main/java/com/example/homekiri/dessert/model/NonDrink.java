package com.example.homekiri.dessert.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="NonDrink")
@Entity
public class NonDrink {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "nonDrinkName")
    private String nonDrinkName;

    @Column(name = "temparture")
    private String temperature;

    @Column(name = "flavor")
    private String flavor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nonDrink")
    private List<DessertActivity> dessertActivityList;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;


    @Builder
    public NonDrink(Long idx, String nonDrinkName, String temperature , String flavor, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx  = idx;
        this.nonDrinkName = nonDrinkName;
        this.temperature = temperature;
        this.flavor = flavor;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}