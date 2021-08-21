package com.example.homekiri.recommendation.model.activity.Info;

import lombok.Builder;
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
@Table(name="Drink")
@Entity
public class Drink {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "temparture")
    private String temperature;

    @Column(name = "caffeine")
    private String caffeine;

    @Column(name = "flavor")
    private String flavor;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Drink(Long idx, String drinkName, String temperature, String caffeine, String flavor,  LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.drinkName = drinkName;
        this.temperature = temperature;
        this.caffeine = caffeine;
        this.flavor = flavor;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
