package com.mustceng.onlineshop.repository1;

import com.mustceng.onlineshop.entity1.ProductDiscount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {

	Page<ProductDiscount> findAll(Pageable pageable);

	ProductDiscount findByProductIdAndDiscountNonExpiredIsTrue(Long id);

}
