package com.mustceng.onlineshop.dto1;

import com.mustceng.onlineshop.entity1.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Long id;
	private String title;
	private String brand;
	private String imageUrl;
	private BigDecimal price;
	private BigDecimal netPrice;
	private Integer rating;
	private CategoryDTO category;

}
