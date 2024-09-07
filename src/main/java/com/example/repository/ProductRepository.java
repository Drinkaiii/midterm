package com.example.repository;

import com.example.model.CheckoutProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository  extends CrudRepository<CheckoutProduct, Integer> {

    @Query("SELECT SUM(price) FROM CheckoutProduct")
    int getTotalPrice();

    @Query("SELECT colorName ,SUM(qty) AS total FROM CheckoutProduct GROUP BY colorName")
    List<String> getAllQuantityByColorName();

    @Query("SELECT INTERVAL(price,500,520,540,560,580,600,620,640,660,680,700,720,740,760,780,800,820,840,860,880,900,920,940,960,980,1000,1020,1040,1060,1080,1100,1120,1140,1160,1180,1200,1220,1240,1260,1280,1300,1320,1340,1360,1380,1400,1420,1440,1460,1480,1500,1520,1540,1560,1580,1600,1620,1640,1660,1680,1700,1720,1740,1760,1780,1800,1820,1840,1860,1880,1900,1920,1940,1960,1980,2000) AS price_range, COUNT(1) FROM CheckoutProduct GROUP BY price_range ORDER BY price_range")
    List<String> getAllQuantityByPriceRange();

    @Query("SELECT productId, (qty * price) AS total FROM CheckoutProduct ORDER BY productId")
    List<String> getTop5();

}
