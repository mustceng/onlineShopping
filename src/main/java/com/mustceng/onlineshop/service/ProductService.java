package com.mustceng.onlineshop.service;

import com.mustceng.onlineshop.dto1.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
	ProductDTO getProductById(Long id);

	Page<ProductDTO> getProductByCategoryId(Long id, Pageable pageable);

	Page<ProductDTO> getAllProducts(Pageable pageable);

	List<ProductDTO> getAllList();

	ProductDTO save(ProductDTO productDTO);

	ProductDTO applyDiscount(ProductDTO productDTO);

	ProductDTO update(Long id,ProductDTO productDTO);

	void delete(Long id);

}
