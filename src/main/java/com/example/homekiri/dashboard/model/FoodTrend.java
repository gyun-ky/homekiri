package com.example.homekiri.dashboard.model;

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
@Entity
//@Builder
@Table(name="FoodTrend")
public class FoodTrend {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "foodIdx")
    private Long foodIdx;

    @Column(name = "foodName")
    private String foodName;

    @Column(name = "ranking")
    private int ranking;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public FoodTrend(Long idx, Long foodIdx, String foodName, int ranking, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.foodIdx = foodIdx;
        this.foodName = foodName;
        this.ranking = ranking;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
