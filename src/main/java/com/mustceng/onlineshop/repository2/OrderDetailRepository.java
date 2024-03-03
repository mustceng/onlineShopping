package com.mustceng.onlineshop.repository2;

import com.mustceng.onlineshop.entity2.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAll();
}
