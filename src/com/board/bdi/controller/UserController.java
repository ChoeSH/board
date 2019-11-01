package com.board.bdi.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.bdi.service.UserService;
import com.board.bdi.service.impl.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uiId=request.getParameter("uiId");
		String uiPwd=request.getParameter("uiPwd");
		String uiName=request.getParameter("uiName");
		
		String uri=request.getRequestURI();
		String cmd=uri.substring(6);
		String path="/views/msg";
		
		if("login".equals(cmd)) {
			Map<String,String> user = us.doLogin(uiId, uiPwd);
		if(user!=null) {
			HttpSession hs = request.getSession();
			hs.setAttribute("user", user);
			request.setAttribute("msg", "로그인 성공");
			request.setAttribute("url", "/views/index");
		}else {
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("url", "/views/user/login");
		}
		}else if("signup".equals(cmd)) {
			Map<String,String> user = us.doSignup(uiId, uiPwd, uiName);
			if(user!=null) {
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user);
				request.setAttribute("msg", "회원가입 성공");
				request.setAttribute("url", "/views/index");
			}else {
				request.setAttribute("msg", "회원가입 실패");
				request.setAttribute("url", "/views/user/signup");
			}
		}else if("logout".equals(cmd)) {
			
		}else if("update".equals(cmd)) {
			
		}else if("delete".equals(cmd)) {
			
		}
		RequestDispatcher rd= request.getRequestDispatcher(path);
		rd.forward(request, response);
		}
}
