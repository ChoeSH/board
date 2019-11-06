package com.board.bdi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDao;
import com.board.bdi.dao.impl.UserDaoImpl;
import com.board.bdi.service.UserService;

public class UserServiceImpl implements UserService {	//implement: 도구
	private UserDao udao = new UserDaoImpl();
	
	@Override
	public Map<String,String> doLogin(String uiId, String uiPwd) {
		Map<String,String> user = new HashMap<>();
		user.put("uiId",uiId);
		user.put("uiPwd",uiPwd);
		return udao.selectUser(user);
		//return user!=null;	user값이 null 이 아니라면 true를 리턴한다. doLogin메소드의 리턴타입이 boolean일때
	}

	@Override
	public Map<String, String> doSignup(String uiId, String uiPwd,String uiName) {
		Map<String,String> user = new HashMap<>();
		user.put("uiId",uiId);
		user.put("uiPwd",uiPwd);
		user.put("uiName",uiName);
		return udao.signupUser(user);
	}
	
	@Override
	public List<Map<String,String>> doList(Map<String,String> user){
		return udao.selectUserList(user);
	}
}
