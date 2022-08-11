package com.triplus.payment.service;

import com.triplus.payment.dto.OrderDto;
import com.triplus.payment.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public int insert(OrderDto Orderdto) {
        return orderMapper.insert(Orderdto);
    }
}