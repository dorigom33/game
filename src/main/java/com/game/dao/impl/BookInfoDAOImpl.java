package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BookInfoDAO;

public class BookInfoDAOImpl implements com.game.dao.BookInfoDAO {

	@Override
	public List<Map<String, String>> selectBookInfoList(Map<String, String> bookInfo) {
		List<Map<String, String>> bookInfoList = new ArrayList<>();
		String sql = "SELECT BI_NUM, BI_TITLE, BI_AUTH, CREDAT FROM BOOK_INFO WHERE 1=1";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> bm = new HashMap<>();
						bm.put("biNum", rs.getString("BI_NUM"));
						bm.put("biTitle", rs.getString("BI_TITLE"));
						bm.put("biAuth", rs.getString("BI_AUTH"));
						bm.put("credat", rs.getString("CREDAT"));
						bookInfoList.add(bm);
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}

	@Override
	public Map<String, String> selectBookInfo(String biNum) {
		String sql = "SELECT BI_NUM, BI_TITLE, BI_AUTH, CREDAT FROM BOOK_INFO WHERE 1=1 AND BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> bm = new HashMap<>();
						bm.put("biNum", rs.getString("BI_NUM"));
						bm.put("biTitle", rs.getString("BI_TITLE"));
						bm.put("biAuth", rs.getString("BI_AUTH"));
						bm.put("credat", rs.getString("CREDAT"));
						return bm;
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public int insertBookInfo(Map<String, String> bookInfo) {
		String sql = "INSERT INTO BOOK_INFO(BI_TITLE, BI_AUTH, CREDAT) VALUES(?,?,DATE_FORMAT(NOW(), '%Y%m%d'))";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, bookInfo.get("biTitle"));
				ps.setString(2, bookInfo.get("biAuth"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int updateBookInfo(Map<String, String> bookInfo) {
		String sql = "UPDATE BOOK_INFO SET BI_TITLE=?, BI_AUTH=? WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, bookInfo.get("biTitle"));
				ps.setString(2, bookInfo.get("biAuth"));
				ps.setString(3, bookInfo.get("biNum"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int deleteBookInfo(String biNum) {
		String sql = "DELETE FROM BOOK_INFO WHERE BI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, biNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		BookInfoDAO biDao = new BookInfoDAOImpl();
		System.out.println(biDao.selectBookInfoList(null));
		System.out.println(biDao.selectBookInfo("1"));
		/*
		Map<String, String> map = new HashMap<>();
		map.put("biTitle", "리어왕");
		map.put("biAuth", "윌리엄 셰익스피어");
		int result = biDao.insertBookInfo(map);
		System.out.println(result);
		*/
		/*
		Map<String,String> map = new HashMap<>();
		map.put("biTitle", "로미오와 줄리엣");
		map.put("biAuth", "윌리엄 셰익스피어");
		map.put("biNum", "2");
		int result = biDao.updateBookInfo(map);
		System.out.println(result);
		*/
		/*
		String biNum = "2";
		int result = biDao.deleteBookInfo(biNum);
		System.out.println(result);
		*/
	}

}
