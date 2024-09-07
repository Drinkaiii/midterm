package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "checkout_product")
@Data
@NoArgsConstructor
public class CheckoutProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint unsigned", nullable = false)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

//    @Column(name = "color_id", nullable = false)
//    private Long colorId;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "size", length = 10, nullable = false)
    private String size;

    @Column(name = "qty", nullable = false)
    private int qty;

    @Column(name = "color_code", length = 10, nullable = false)
    private String colorCode = "";

    @Column(name = "color_name", length = 10, nullable = false)
    private String colorName = "";

}
