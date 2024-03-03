package com.mustceng.onlineshop.repository2;

import com.mustceng.onlineshop.entity2.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAll();
}
