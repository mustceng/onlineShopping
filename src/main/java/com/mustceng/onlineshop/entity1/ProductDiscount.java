package com.mustceng.onlineshop.entity1;

import com.mustceng.onlineshop.entity1.Product;
import com.mustceng.onlineshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "product_discount")
@NoArgsConstructor
@AllArgsConstructor
public class ProductDiscount extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "discount_ratio")
	private BigDecimal discountRatio;

	@Column(name = "discount_non_expired")
	private boolean discountNonExpired = true;

	@Column(name = "start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@Column(name = "end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;


}
