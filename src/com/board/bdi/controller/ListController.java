package com.board.bdi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> hList = new ArrayList<>();
		Map<String,String> h = new HashMap<>();
		h.put("name","홍길동");
		h.put("age","33");
		hList.add(h);
		hList.add(h);
		hList.add(h);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Gson gson=new Gson();
		pw.print(gson.toJson(hList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age","33");
		Gson gson = new Gson();
		String jsonStr= gson.toJson(map);
		System.out.println(jsonStr);
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+map.get(key));
		}
	}
}
