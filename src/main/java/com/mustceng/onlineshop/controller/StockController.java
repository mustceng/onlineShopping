package com.mustceng.onlineshop.controller;


import com.mustceng.onlineshop.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

	private final StockService stockService;


	public StockController(StockService stockService) {
		this.stockService = stockService;
	}


}
