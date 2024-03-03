package com.mustceng.onlineshop.entity1;

import com.mustceng.onlineshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
public class Stock extends BaseEntity {

	@Column(name = "amount")
	private Integer amount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

}
