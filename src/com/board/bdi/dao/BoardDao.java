package com.board.bdi.dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	public List<Map<String,String>> selectBoard(Map<String,String> board);
	public int insertBoard(Map<String,String> board);

}
