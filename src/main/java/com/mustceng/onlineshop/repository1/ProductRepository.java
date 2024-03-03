package com.mustceng.onlineshop.repository1;

import com.mustceng.onlineshop.entity1.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findAll(Pageable pageable);

	Page<Product> findByCategoryId(Long id,Pageable pageable);

//	@Query("SELECT SUM(p.price*p.amount) FROM Product p")
//	BigDecimal totalValueProducts();

}
