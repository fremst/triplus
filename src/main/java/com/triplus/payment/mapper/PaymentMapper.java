package com.triplus.payment.mapper;

import com.triplus.payment.dto.OrderDto;
import com.triplus.payment.dto.PaymentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int insert(PaymentDto paymentDto);

//    PaymentDto select(String tid);
//
//    int update(PaymentDto paymentDto);
//
//    int delete(String tid);
}