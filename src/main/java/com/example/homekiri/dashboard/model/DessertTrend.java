package com.example.homekiri.dashboard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DessertTrend")
public class  DessertTrend {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "dessertIdx")
    private Long dessertIdx;

    @Column(name = "dessertName")
    private String dessertName;

    @Column(name = "ranking")
    private int ranking;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public DessertTrend(Long idx, Long dessertIdx, String dessertName, int ranking, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.dessertIdx = dessertIdx;
        this.dessertName = dessertName;
        this.ranking = ranking;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
