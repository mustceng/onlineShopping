package com.mustceng.onlineshop.controller;


import com.mustceng.onlineshop.dto1.ProductDTO;
import com.mustceng.onlineshop.dto2.CartDTO;
import com.mustceng.onlineshop.dto2.ShoppingCart;
import com.mustceng.onlineshop.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

	private final CartServiceImpl cartService;

	public CartController(CartServiceImpl cartService) {
		this.cartService = cartService;
	}


	@GetMapping
	public ResponseEntity<ShoppingCart> getCart(){
		return ResponseEntity.ok(cartService.getShoppingCart());
	}

}
