package com.example.homekiri.recommendation.model.activity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name="Food")
@Entity
public class DessertActivity {

    @Id
    @Column(name="")
}
