package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.BoardDao;

public class BoardDaoImpl implements BoardDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String ID = "bdi";
	private final static String PWD = "12345678";

	public List<Map<String, String>> selectBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from board_info";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			List<Map<String, String>> list = new ArrayList<>();

			while (rs.next()) {
				board = new HashMap<>();
				board.put("bi_num", rs.getString("bi_num"));
				board.put("bi_title", rs.getString("bi_title"));
				board.put("ui_num", rs.getString("ui_num"));
				board.put("bi_content", rs.getString("bi_content"));
				board.put("credat", rs.getString("credat"));
				board.put("cretim", rs.getString("cretim"));
				list.add(board);
				System.out.println(list);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int insertBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "INSERT INTO BOARD_INFO(BI_NUM, BI_TITLE,UI_NUM,BI_CONTENT,credat,cretim,moddat,modtim) ";
			sql += " VALUES(SEQ_UI_NUM.NEXTVAL,?,?,?,to_char(sysdate,'YYYYMMDD'),to_char(SYSDATE,'HH24MISS'),to_char(sysdate,'YYYYMMDD'),to_char(SYSDATE,'HH24MISS'))";

			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("bi_title"));
			ps.setString(2, board.get("ui_num"));
			ps.setString(3, board.get("bi_content"));

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Map<String, String> viewBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from board_info bi, user_info ui";
			sql += " where bi.ui_num=ui.ui_num";
			sql += " and bi_num=?";
			sql += " order by bi_num desc";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("bi_num"));
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, String> b = new HashMap<>();
				b.put("bi_num", rs.getString("bi_num"));
				b.put("bi_title", rs.getString("bi_title"));
				b.put("ui_num", rs.getString("ui_num"));
				b.put("ui_id", rs.getString("ui_id"));
				b.put("bi_content", rs.getString("bi_content"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int dropBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "delete from board_info where bi_num=?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, board.get("bi_num"));

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int updateBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "update board_info"
					+ " set bi_title=?"
					+ ", bi_content=?"
					+ " where bi_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("bi_title"));
			ps.setString(2, board.get("bi_content"));
			ps.setString(3, board.get("bi_num"));
			return ps.executeUpdate();
		}catch(SQLException e) {
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
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return 0;
	}
}