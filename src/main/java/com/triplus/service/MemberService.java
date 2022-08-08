package com.triplus.service;

import com.triplus.dto.MemberDto;
import com.triplus.mapper.TriplusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired private TriplusMapper mapper;

    public int insert(MemberDto dto) {
        return mapper.insert(dto);
    }
}
