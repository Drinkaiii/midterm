package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "checkout_order")
@Data
@NoArgsConstructor
public class CheckOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint unsigned", nullable = false)
    private Long id;

    @Column(name = "total", nullable = false)
    private int total;

}
