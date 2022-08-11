package com.triplus.payment.service;

import com.triplus.payment.dto.OrderDto;
import com.triplus.test.dto.TestDto;
import com.triplus.test.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
public class OrderServiceTest {
    @Autowired
    OrderService orderService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void insert() {
        logger.info("service: " + orderService);
        int n = orderService.insert(new OrderDto("1", 100, "test", 1, 1, "예약자", "010-8765-4321", "booker@triplus.com", 0, "예약"));
        logger.info("n: " + n);
        assertEquals(n, 1);
    }
}