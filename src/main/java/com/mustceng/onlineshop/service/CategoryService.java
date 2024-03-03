package com.mustceng.onlineshop.service;

import com.mustceng.onlineshop.dto1.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

	CategoryDTO getCategoryById(Long id);

	Page<CategoryDTO> getAllCategories(Pageable pageable);

	List<CategoryDTO> getAllList();

	CategoryDTO save(CategoryDTO categoryDTO);

	CategoryDTO update(Long id,CategoryDTO categoryDTO);

	void delete(Long id);


}
