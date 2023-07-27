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
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		List<Map<String, String>> boardInfoList = new ArrayList<>();
		String sql = "SELECT BI_NUM, BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM BOARD_INFO WHERE UI_NUM=3";
		try (Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> boardInfoMap = new HashMap<>();
						boardInfoMap.put("biNum", rs.getString("BI_NUM"));
						boardInfoMap.put("biTitle", rs.getString("BI_TITLE"));
						boardInfoMap.put("biContent", rs.getString("BI_CONTENT"));
						boardInfoMap.put("uiNum", rs.getString("UI_NUM"));
						boardInfoMap.put("credat", rs.getString("CREDAT"));
						boardInfoMap.put("cretim", rs.getString("CRETIM"));
						boardInfoMap.put("lmodat", rs.getString("LMODAT"));
						boardInfoMap.put("lmotim", rs.getString("LMOTIM"));
						boardInfoMap.put("active", rs.getString("ACTIVE"));
						boardInfoList.add(boardInfoMap);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardInfoList;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql = "SELECT BI_NUM, BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM BOARD_INFO WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> boardInfoMap = new HashMap<>();
						boardInfoMap.put("biNum", rs.getString("BI_NUM"));
						boardInfoMap.put("biTitle", rs.getString("BI_TITLE"));
						boardInfoMap.put("biContent", rs.getString("BI_CONTENT"));
						boardInfoMap.put("uiNum", rs.getString("UI_NUM"));
						boardInfoMap.put("credat", rs.getString("CREDAT"));
						boardInfoMap.put("cretim", rs.getString("CRETIM"));
						boardInfoMap.put("lmodat", rs.getString("LMODAT"));
						boardInfoMap.put("lmotim", rs.getString("LMOTIM"));
						boardInfoMap.put("active", rs.getString("ACTIVE"));
						return boardInfoMap;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql ="INSERT INTO board_info(BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?, DATE_FORMAT(NOW(), '%y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'),DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				return ps.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql = "UPDATE board_info SET BI_TITLE=?, BI_CONTENT=?,LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'),LMOTIM= DATE_FORMAT(NOW(),'%H%i%s') WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("biNum"));
				return ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM=?";
		Connection con = DBCon.getCon();
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, biNum);
			return ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		BoardInfoDAO biDao = new BoardInfoDAOImpl();
		System.out.println(biDao.selectBoardInfoList(null));
		System.out.println(biDao.selectBoardInfo("3"));
		
		/*
		BoardInfoDAO biDAO = new BoardInfoDAOImpl();
		Map<String, String> biMock = new HashMap<>();
		biMock.put("biTitle", "test3");
		biMock.put("biContent", "test3");
		biMock.put("uiNum","3");
		int result = biDAO.insertBoardInfo(biMock);
		System.out.println("결과 : " + result);
		*/
		/*
		BoardInfoDAO biDAO = new BoardInfoDAOImpl();
		Map<String, String> biMock = new HashMap<>();
		biMock.put("biTitle", "testmod3");
		biMock.put("biContent", "testmod3");
		biMock.put("biNum","3");
		int result = biDAO.updateBoardInfo(biMock);
		System.out.println("결과 : " + result);
		*/
		/*
		String biNum= "5";
		int result = biDao.deleteBoardInfo(biNum);
		System.out.println(result);
		*/
		
	}

}
