package com.example.homekiri.food.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="FoodImage")
@Entity
public class FoodImage {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "foodIdx")
    private Long foodIdx;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "foodImage")
    private FoodActivity foodActivity;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public FoodImage(Long idx, Long foodIdx, String imgUrl, String description, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.foodIdx = foodIdx;
        this.imgUrl = imgUrl;
        this.description = description;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

}
