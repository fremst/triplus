package com.triplus.mapper;

import com.triplus.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TriplusMapper {
    int insert(MemberDto dto);
}
