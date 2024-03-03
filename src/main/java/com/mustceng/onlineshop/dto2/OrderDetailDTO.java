package com.mustceng.onlineshop.dto2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
	private Long id;
	private OrdersDTO order;
	private Integer amount;
	private Long productId;

}
