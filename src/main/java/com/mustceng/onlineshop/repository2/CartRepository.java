package com.mustceng.onlineshop.repository2;

import com.mustceng.onlineshop.entity2.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAll();
}
