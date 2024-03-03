package com.mustceng.onlineshop.service;

import com.mustceng.onlineshop.dto2.OrdersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrdersService {
	OrdersDTO getOrderById(Long id);

	Page<OrdersDTO> getAllOrders(Pageable pageable);

	List<OrdersDTO> getAllList();

	void save(OrdersDTO ordersDTO);

	void cancelOrder(Long id);

	void updateAddress(Long id, String newAddress);

	void delete(Long id);
}
