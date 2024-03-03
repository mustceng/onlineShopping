package com.mustceng.onlineshop.entity1;

import com.mustceng.onlineshop.entity1.Category;
import com.mustceng.onlineshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

	@Column(name = "title", length = 100)
	private String title;

	@Column(name = "brand", length = 100)
	private String brand;

	@Column(name = "image_url", length = 400)
	private String imageUrl;

	@Column(name = "price", precision = 18, scale = 2)
	private BigDecimal price;

	@Column(name = "net_price", precision = 18, scale = 2)
	private BigDecimal netPrice;

	@Column(name = "rating")
	private Integer rating;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

}
