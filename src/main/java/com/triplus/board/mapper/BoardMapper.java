package com.triplus.board.mapper;

import com.triplus.dto.board.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BoardMapper
{
    public ArrayList<BoardDto> select();
    public int insert(BoardDto boardDto);
    public int delete(int brdnum);
    public int update(BoardDto boardDto);
}
