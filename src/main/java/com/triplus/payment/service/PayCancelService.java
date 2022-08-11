package com.triplus.payment.service;

import com.triplus.payment.dto.PayCancelDto;
import com.triplus.payment.dto.PaymentDto;
import com.triplus.payment.mapper.PayCancelMapper;
import com.triplus.payment.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayCancelService {
    @Autowired
    private PayCancelMapper payCancelMapper;

    public int insert(PayCancelDto payCancelDto) {
        return payCancelMapper.insert(payCancelDto);
    }
}