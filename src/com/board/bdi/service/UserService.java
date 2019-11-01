package com.board.bdi.service;

import java.util.Map;

public interface UserService {
	public Map<String,String> doLogin(String uiId, String uiPwd);
	public Map<String,String> doSignup(String uiId, String uiPwd,String uiName);
	
}
