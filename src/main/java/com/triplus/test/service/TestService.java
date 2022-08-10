package com.triplus.test.service;

import com.triplus.test.dto.TestDto;
import com.triplus.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired private TestMapper mapper;

    public int insert(TestDto dto) {
        return mapper.insert(dto);
    }
}
