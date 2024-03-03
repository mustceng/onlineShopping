package com.mustceng.onlineshop.repository1;

import com.mustceng.onlineshop.entity1.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findAll();
}
