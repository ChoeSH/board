package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.board.bdi.dao.UserDao;

public class UserDaoImpl implements UserDao{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private final static String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String ID="bdi";
	private final static String PWD="12345678";
	
	public Map<String,String> selectUser(Map<String,String> user){
		try {
			con=DriverManager.getConnection(URL,ID,PWD);
			String sql= "select * from user_info where ui_id=? and ui_pwd=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs=ps.executeQuery();
			if(rs.next()) {
				user.put("uiName",rs.getString("ui_name"));
				user.put("ui_num",rs.getString("ui_num"));
				user.put("credat",rs.getString("credat"));
				return user;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	return null;
}

public static void main(String[] args) {
	UserDao udao = new UserDaoImpl();
	Map<String,String> user=new HashMap<>();
	user.put("uiId", "kim1");
	user.put("uiPwd","12345a");
	user = udao.selectUser(user);
	System.out.println(user);
	}

	
	public Map<String,String> signupUser(Map<String,String> user){
			try {
				con=DriverManager.getConnection(URL,ID,PWD);
				String sql= "INSERT INTO USER_INFO(UI_NUM, UI_ID,UI_PWD,UI_NAME,credat,cretim,moddat,modtim) ";
				sql+="VALUES(SEQ_UI_NUM.NEXTVAL,?,?,?,to_char(sysdate,'YYYYMMDD'),to_char(SYSDATE,'HH24MISS'),to_char(sysdate,'YYYYMMDD'),to_char(SYSDATE,'HH24MISS'))"; 
				
				ps=con.prepareStatement(sql);
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiPwd"));
				ps.setString(3, user.get("uiName"));
				int result=ps.executeUpdate();
				if(result==1) {
					user.put("uiId",rs.getString("ui_id"));
					user.put("uiPwd",rs.getString("ui_pwd"));
					user.put("uiName",rs.getString("ui_name"));
					user.put("uiNum",rs.getString("ui_num"));
					user.put("credat",rs.getString("credat"));
					user.put("cretim",rs.getString("cretim"));
					return user;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(ps!=null) {
						ps.close();
					}
					if(con!=null) {
						con.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		return user;
}
}

