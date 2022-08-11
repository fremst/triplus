package com.triplus.payment.service;

import com.triplus.payment.dto.OrderDto;
import com.triplus.payment.dto.PaymentDto;
import com.triplus.payment.mapper.OrderMapper;
import com.triplus.payment.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    public int insert(PaymentDto paymentDto) {
        return paymentMapper.insert(paymentDto);
    }
}