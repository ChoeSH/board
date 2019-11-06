package com.board.bdi.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	public Map<String,String> selectUser(Map<String,String> user);
	public Map<String,String> signupUser(Map<String,String> user);
	public List<Map<String,String>> selectUserList(Map<String,String> user);
}
