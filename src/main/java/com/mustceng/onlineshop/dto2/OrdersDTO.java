package com.mustceng.onlineshop.dto2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
	private Long id;
	private Long userId;
	private String address;
	private Boolean cancelOrder;
	private List<OrderDetailDTO> orderDetails=new ArrayList<>();

}
