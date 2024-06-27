package com.example.shopping.service;

import com.example.shopping.dto.OrderDTO;
import com.example.shopping.entity.OrderEntity;
import com.example.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public void save(OrderDTO orderDTO) {
        OrderEntity orderEntity = OrderEntity.toSaveEntity(orderDTO);
        orderRepository.save(orderEntity);
    }

}
