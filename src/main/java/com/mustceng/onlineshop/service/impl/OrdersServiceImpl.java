package com.mustceng.onlineshop.service.impl;

import com.mustceng.onlineshop.dto2.OrdersDTO;
import com.mustceng.onlineshop.entity2.OrderDetail;
import com.mustceng.onlineshop.entity2.Orders;
import com.mustceng.onlineshop.exception.ApiException;
import com.mustceng.onlineshop.exception.ResponseCode;
import com.mustceng.onlineshop.exception.Severity;
import com.mustceng.onlineshop.repository1.ProductRepository;
import com.mustceng.onlineshop.repository2.OrderDetailRepository;
import com.mustceng.onlineshop.repository2.OrdersRepository;
import com.mustceng.onlineshop.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public OrdersServiceImpl(OrdersRepository ordersRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.ordersRepository = ordersRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrdersDTO getOrderById(Long id) {
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Order"));
        return modelMapper.map(orders, OrdersDTO.class);
    }

    @Override
    public Page<OrdersDTO> getAllOrders(Pageable pageable) {
        Page<Orders> ordersPage = ordersRepository.findAll(pageable);
        return ordersPage.map(orders -> modelMapper.map(orders, OrdersDTO.class));
    }

    @Override
    public List<OrdersDTO> getAllList() {
        return modelMapper.map(ordersRepository.findAll(), new TypeToken<List<OrdersDTO>>(){}.getType());
    }

    @Override
    public void save(OrdersDTO ordersDTO) {
        Orders ordersSaved = modelMapper.map(ordersDTO, Orders.class);
        ordersSaved = ordersRepository.save(ordersSaved);
        Orders finalOrdersSaved = ordersSaved;
        List<OrderDetail> newOrderDetails = ordersSaved.getOrderDetails().stream()
                .map(e -> {
                    e.setOrder(finalOrdersSaved);
                    return e;
                })
                .collect(Collectors.toList());

        orderDetailRepository.saveAll(newOrderDetails);

    }
    @Override
    public void cancelOrder(Long id) {
        Orders cancelOrder = ordersRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Order"));
        cancelOrder.setCancelOrder(true);
        ordersRepository.save(cancelOrder);
    }


    @Override
    public void updateAddress(Long id,String newAddress) {
        Orders updateOrder = ordersRepository.findById(id).orElseThrow(() -> new ApiException(ResponseCode.DATA_NOT_FOUND, Severity.ERROR, "Order"));
        updateOrder.setAddress(newAddress);
        ordersRepository.save(updateOrder);
    }

    @Override
    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }

}
