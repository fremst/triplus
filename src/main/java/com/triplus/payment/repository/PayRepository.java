package com.triplus.payment.repository;

import com.triplus.payment.dto.OrderData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PayRepository {

    public Map<String, OrderData> map = new HashMap<>();

    public void saveOrder(String orderNumber, long timestamp, String signature, int price) {
        this.map.put(orderNumber, new OrderData(timestamp, signature, price));
    }

    public OrderData getOrder(String orderNumber) {
        return this.map.get(orderNumber);
    }
}
