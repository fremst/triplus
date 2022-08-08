package com.triplus.service;

import com.triplus.dto.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
public class MemberServiceTest {
    @Autowired MemberService service;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
   public void insert() {
        logger.info("service: "+service);
        int n = service.insert(new MemberDto("test"));
        logger.info("n: "+n);
        assertEquals(n,1);
    }
}