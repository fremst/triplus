package com.triplus.payment.mapper;

import com.triplus.payment.dto.OrderDto;
import com.triplus.payment.dto.PcPayRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int insert(OrderDto orderDto);

//    OrderDto select(String tid);
//
//    int update(OrderDto orderDto);
//
//    int delete(String tid);
}