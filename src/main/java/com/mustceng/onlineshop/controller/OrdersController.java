package com.mustceng.onlineshop.controller;


import com.mustceng.onlineshop.dto2.OrdersDTO;
import com.mustceng.onlineshop.response.ApiResponse;
import com.mustceng.onlineshop.service.OrdersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	private final OrdersService ordersService;


	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@GetMapping("/{id}")
	public ApiResponse<OrdersDTO> getOrdersById(@PathVariable("id") Long id){
		return ApiResponse.of(ordersService.getOrderById(id));
	}

	@GetMapping("/all")
	public ApiResponse<Page<OrdersDTO>> getAllPaged(Pageable pageable){
		return ApiResponse.of(ordersService.getAllOrders(pageable));
	}

	@PostMapping("/save")
	public ApiResponse save(@RequestBody OrdersDTO ordersDTO){
		ordersService.save(ordersDTO);
		return ApiResponse.success();
	}

	@PutMapping("/cancel/{id}")
	public ApiResponse cancelOrder(@PathVariable("id") Long id){
		ordersService.cancelOrder(id);
		return ApiResponse.success();
	}


	@PutMapping("/update-address/{id}")
	public ApiResponse<OrdersDTO> updateAddress(@PathVariable("id") Long id,
												@RequestParam(value = "newAddress", required = false) String newAddress){
		ordersService.updateAddress(id,newAddress);
		return ApiResponse.success();
	}


	@DeleteMapping("/{id}")
	public ApiResponse delete(@PathVariable("id") Long id){
		ordersService.delete(id);
		return ApiResponse.success();
	}

}
