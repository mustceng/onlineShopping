package com.mustceng.onlineshop.service.impl;

import com.mustceng.onlineshop.dto2.CartDTO;
import com.mustceng.onlineshop.dto2.ShoppingCart;
import com.mustceng.onlineshop.entity2.Cart;
import com.mustceng.onlineshop.entity1.Product;
import com.mustceng.onlineshop.exception.ApiException;
import com.mustceng.onlineshop.exception.ResponseCode;
import com.mustceng.onlineshop.exception.Severity;
import com.mustceng.onlineshop.repository2.CartRepository;
import com.mustceng.onlineshop.repository1.ProductRepository;
import com.mustceng.onlineshop.service.CartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public ShoppingCart getShoppingCart() {
        return new ShoppingCart(modelMapper.map(cartRepository.findAll(), new TypeToken<List<CartDTO>>(){}.getType()));
    }
}
