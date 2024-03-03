package com.mustceng.onlineshop.service.impl;

import com.mustceng.onlineshop.dto1.ProductDTO;
import com.mustceng.onlineshop.entity1.Category;
import com.mustceng.onlineshop.entity1.Product;
import com.mustceng.onlineshop.entity1.ProductDiscount;
import com.mustceng.onlineshop.exception.ApiException;
import com.mustceng.onlineshop.exception.ResponseCode;
import com.mustceng.onlineshop.exception.Severity;
import com.mustceng.onlineshop.repository1.CategoryRepository;
import com.mustceng.onlineshop.repository1.ProductDiscountRepository;
import com.mustceng.onlineshop.repository1.ProductRepository;
import com.mustceng.onlineshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductDiscountRepository productDiscountRepository;
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	public ProductServiceImpl(ProductRepository productRepository, ProductDiscountRepository productDiscountRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.productDiscountRepository = productDiscountRepository;
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Product"));
		return modelMapper.map(product, ProductDTO.class);
	}

	@Override
	public Page<ProductDTO> getProductByCategoryId(Long id, Pageable pageable) {
		Page<Product> productPage = productRepository.findByCategoryId(id, pageable);
		return productPage.map(product -> modelMapper.map(product, ProductDTO.class));
	}

	@Override
	public Page<ProductDTO> getAllProducts(Pageable pageable) {
		Page<Product> productPage = productRepository.findAll(pageable);
		return productPage.map(product -> modelMapper.map(product, ProductDTO.class));
	}

	@Override
	public List<ProductDTO> getAllList() {
		return modelMapper.map(productRepository.findAll(), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		Product productSaved = modelMapper.map(productDTO, Product.class);
		Category category = categoryRepository.findById(productDTO.getCategory().getId()).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Category"));
		productSaved.setCategory(category);
		return modelMapper.map(productRepository.save(productSaved), ProductDTO.class);
	}

	@Override
	public ProductDTO applyDiscount(ProductDTO productDTO) {
		ProductDiscount productDiscount = productDiscountRepository.findByProductIdAndDiscountNonExpiredIsTrue(productDTO.getId());
		Product product = productRepository.findById(productDTO.getId()).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Product"));
		if (productDiscount != null) {
			BigDecimal discountPrice = product.getPrice().multiply(productDiscount.getDiscountRatio()).divide(BigDecimal.valueOf(100), 2, RoundingMode.CEILING);
			product.setNetPrice(product.getPrice().subtract(discountPrice));
			Product productSaved = productRepository.save(product);
			return modelMapper.map(productRepository.save(productSaved), ProductDTO.class);
		} else
			throw new ApiException(ResponseCode.DATA_NOT_FOUND, "Discounted product");

	}

	@Override
	public ProductDTO update(Long id, ProductDTO productDTO) {
		Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Product"));

		updateProduct.setBrand(productDTO.getBrand());
		updateProduct.setCategory(modelMapper.map(productDTO.getCategory(), Category.class));
		updateProduct.setPrice(productDTO.getPrice());
		updateProduct.setRating(productDTO.getRating());
		updateProduct.setTitle(productDTO.getTitle());
		updateProduct.setImageUrl(productDTO.getImageUrl());

		Product productUpdated = productRepository.save(updateProduct);
		return modelMapper.map(productRepository.save(productUpdated), ProductDTO.class);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
