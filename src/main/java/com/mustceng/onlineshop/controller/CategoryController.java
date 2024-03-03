package com.mustceng.onlineshop.controller;


import com.mustceng.onlineshop.dto1.CategoryDTO;
import com.mustceng.onlineshop.response.ApiResponse;
import com.mustceng.onlineshop.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;


	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/{id}")
	public ApiResponse<CategoryDTO> getCategoryById(@PathVariable("id") Long id){
		return ApiResponse.of(categoryService.getCategoryById(id));
	}

	@GetMapping("/all")
	public ApiResponse<Page<CategoryDTO>> getAllPaged(Pageable pageable){
		return ApiResponse.of(categoryService.getAllCategories(pageable));
	}

	@PostMapping("/save")
	public ApiResponse<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO){
		return ApiResponse.of(categoryService.save(categoryDTO));
	}

	@PutMapping("/{id}")
	public ApiResponse<CategoryDTO> update(@PathVariable("id") Long id,@RequestBody CategoryDTO categoryDTO){
		return ApiResponse.of(categoryService.update(id,categoryDTO));
	}

	@DeleteMapping("/{id}")
	public ApiResponse delete(@PathVariable("id") Long id){
		categoryService.delete(id);
		return ApiResponse.success();
	}

}
