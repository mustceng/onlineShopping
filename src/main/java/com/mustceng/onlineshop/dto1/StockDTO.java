package com.mustceng.onlineshop.dto1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
	private Long id;
	private Integer amount;
	private ProductDTO product;


}
