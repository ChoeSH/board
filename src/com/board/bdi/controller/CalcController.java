package com.board.bdi.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("json");
		Gson g= new Gson();
		Map<String,String> param = g.fromJson(json, Map.class);
		System.out.println(param);

		int num1 = Integer.parseInt(param.get("num1"));
		int num2 = Integer.parseInt(param.get("num2"));
		String op = param.get("op");
		int result = 0;
		if("+".equals(op)) {
			result = num1 + num2;
		} else if("-".equals(op)) {
			result = num1 - num2;
		} else if("/".equals(op)) {
			result = num1 / num2;
		} else if("*".equals(op)) {
			result = num1 * num2;
		}
		response.getWriter().print(result);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
