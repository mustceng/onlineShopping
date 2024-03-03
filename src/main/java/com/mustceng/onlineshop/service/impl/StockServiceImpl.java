package com.mustceng.onlineshop.service.impl;

import com.mustceng.onlineshop.repository1.StockRepository;
import com.mustceng.onlineshop.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    public StockServiceImpl(StockRepository stockRepository, ModelMapper modelMapper) {
        this.stockRepository = stockRepository;
        this.modelMapper = modelMapper;
    }


}
