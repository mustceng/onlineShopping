package com.mustceng.onlineshop.service.impl;

import com.mustceng.onlineshop.entity1.Category;
import com.mustceng.onlineshop.dto1.CategoryDTO;
import com.mustceng.onlineshop.repository1.CategoryRepository;
import com.mustceng.onlineshop.exception.ApiException;
import com.mustceng.onlineshop.exception.ResponseCode;
import com.mustceng.onlineshop.exception.Severity;
import com.mustceng.onlineshop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Category"));
		return modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public Page<CategoryDTO> getAllCategories(Pageable pageable) {
		Page<Category> categoryPage = categoryRepository.findAll(pageable);
		return categoryPage.map(category -> modelMapper.map(category, CategoryDTO.class));
	}

	@Override
	public List<CategoryDTO> getAllList() {
		return modelMapper.map(categoryRepository.findAll(), new TypeToken<List<CategoryDTO>>(){}.getType());
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		Category categorySaved = modelMapper.map(categoryDTO, Category.class);
		return modelMapper.map(categoryRepository.save(categorySaved), CategoryDTO.class);
	}

	@Override
	public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
		Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Category"));

		updateCategory.setName(categoryDTO.getName());
		updateCategory.setCategoryCode(categoryDTO.getCategoryCode());

		Category categoryUpdated = categoryRepository.save(updateCategory);
		return modelMapper.map(categoryRepository.save(categoryUpdated), CategoryDTO.class);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

}
