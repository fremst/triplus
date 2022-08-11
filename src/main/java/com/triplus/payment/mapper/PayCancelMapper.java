package com.triplus.payment.mapper;

import com.triplus.payment.dto.PayCancelDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayCancelMapper {
    int insert(PayCancelDto payCancelDto);

//    PaymentDto select(String cTid);

//    int update(PayCancelDto paymentDto);

//    int delete(String cTid);
}