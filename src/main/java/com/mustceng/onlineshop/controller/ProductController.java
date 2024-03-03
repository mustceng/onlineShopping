package com.mustceng.onlineshop.controller;

import com.mustceng.onlineshop.dto1.ProductDTO;
import com.mustceng.onlineshop.response.ApiResponse;
import com.mustceng.onlineshop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;


	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ApiResponse<ProductDTO> getProductById(@PathVariable("id") Long id){
		return ApiResponse.of(productService.getProductById(id));
	}

	@GetMapping("/by-category/{id}")
	public ApiResponse<Page<ProductDTO>> getProductByCategoryId(@PathVariable("id") Long id,Pageable pageable){
		return ApiResponse.of(productService.getProductByCategoryId(id,pageable));
	}

	@GetMapping("/all")
	public ApiResponse<Page<ProductDTO>> getAllPaged(Pageable pageable){
		return ApiResponse.of(productService.getAllProducts(pageable));
	}

	@PostMapping("/save")
	public ApiResponse<ProductDTO> save(@RequestBody ProductDTO productDTO){
		return ApiResponse.of(productService.save(productDTO));
	}

	@PostMapping("/apply-dicount")
	public ApiResponse<ProductDTO> applyDiscount(@RequestBody ProductDTO productDTO){
		return ApiResponse.of(productService.applyDiscount(productDTO));
	}

	@PutMapping("/{id}")
	public ApiResponse<ProductDTO>  update(@PathVariable("id") Long id,@RequestBody ProductDTO productDTO){
		return ApiResponse.of(productService.update(id,productDTO));
	}


	@DeleteMapping("/{id}")
	public ApiResponse delete(@PathVariable("id") Long id){
		productService.delete(id);
		return ApiResponse.success();
	}

}
