package com.example.homekiri.food.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="FoodImage")
@Entity
public class FoodImage {
    @Id
    @Column(name = "idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodIdx")
    private FoodActivity food;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;

//    @OneToOne(mappedBy = "foodImage")
//    private FoodActivity foodActivity;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;


}
