package com.board.bdi.dao;

import java.util.Map;

public interface UserDao {
	public Map<String,String> selectUser(Map<String,String> user);
	public Map<String,String> signupUser(Map<String,String> user);
}
