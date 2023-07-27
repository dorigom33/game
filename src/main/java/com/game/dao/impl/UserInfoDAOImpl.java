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
import com.game.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO{

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		List<Map<String, String>> userInfoList = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE 1=1";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> userInfoMap = new HashMap<>();
						userInfoMap.put("uiNum", rs.getString("UI_NUM"));
						userInfoMap.put("uiName", rs.getString("UI_NAME"));
						userInfoMap.put("uiId", rs.getString("UI_ID"));
						userInfoMap.put("uiPwd", rs.getString("UI_PWD"));
						userInfoMap.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						userInfoMap.put("uiDesc", rs.getString("UI_DESC"));
						userInfoMap.put("uiBirth", rs.getString("UI_BIRTH"));
						userInfoMap.put("credat", rs.getString("CREDAT"));
						userInfoMap.put("cretim", rs.getString("CRETIM"));
						userInfoMap.put("lmodat", rs.getString("LMODAT"));
						userInfoMap.put("lmotim", rs.getString("LMOTIM"));
						userInfoMap.put("active", rs.getString("ACTIVE"));
						userInfoList.add(userInfoMap);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> userInfoMap = new HashMap<>();
						userInfoMap.put("uiNum", rs.getString("UI_NUM"));
						userInfoMap.put("uiName", rs.getString("UI_NAME"));
						userInfoMap.put("uiId", rs.getString("UI_ID"));
						userInfoMap.put("uiPwd", rs.getString("UI_PWD"));
						userInfoMap.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						userInfoMap.put("uiDesc", rs.getString("UI_DESC"));
						userInfoMap.put("uiBirth", rs.getString("UI_BIRTH"));
						userInfoMap.put("credat", rs.getString("CREDAT"));
						userInfoMap.put("cretim", rs.getString("CRETIM"));
						userInfoMap.put("lmodat", rs.getString("LMODAT"));
						userInfoMap.put("lmotim", rs.getString("LMOTIM"));
						userInfoMap.put("active", rs.getString("ACTIVE"));
						return userInfoMap;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO user_info(\r\n" + "UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, \r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT, CRETIM," + "LMODAT, LMOTIM)" + "VALUES(\r\n" + "?,?,?,?,\r\n"
				+ "?,?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'), \r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE USER_INFO\r\n"
				+ "SET UI_NAME=?,\r\n"
				+ "UI_ID=?,\r\n"
				+ "UI_PWD=?,\r\n"
				+ "UI_IMG_PATH=?,\r\n"
				+ "UI_DESC=?,\r\n"
				+ "UI_BIRTH=?\r\n"
				+ "WHERE UI_NUM=?";
		
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				ps.setString(7, userInfo.get("uiNum"));
				return ps.executeUpdate();
			}
		}catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		Connection con = DBCon. getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uiNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE 1=1 AND UI_ID=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiId);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> userInfoMap = new HashMap<>();
						userInfoMap.put("uiNum", rs.getString("UI_NUM"));
						userInfoMap.put("uiName", rs.getString("UI_NAME"));
						userInfoMap.put("uiId", rs.getString("UI_ID"));
						userInfoMap.put("uiPwd", rs.getString("UI_PWD"));
						userInfoMap.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						userInfoMap.put("uiDesc", rs.getString("UI_DESC"));
						userInfoMap.put("uiBirth", rs.getString("UI_BIRTH"));
						userInfoMap.put("credat", rs.getString("CREDAT"));
						userInfoMap.put("cretim", rs.getString("CRETIM"));
						userInfoMap.put("lmodat", rs.getString("LMODAT"));
						userInfoMap.put("lmotim", rs.getString("LMOTIM"));
						userInfoMap.put("active", rs.getString("ACTIVE"));
						return userInfoMap;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserInfoDAO uiDao = new UserInfoDAOImpl();
		System.out.println(uiDao.selectUserInfoList(null));
		System.out.println(uiDao.selectUserInfo("1"));
		/*
		Map<String, String> map = new HashMap<>();
		map.put("uiName", "원섭");
		map.put("uiId", "sup");
		map.put("uiPwd", "sup");
		map.put("uiDesc", "원섭이");
		map.put("uiBirth", "19980613");
		int result = uiDao.insertUserInfo(map);
		System.out.println(result);
		*/
		/*
		Map<String, String> map = new HashMap<>();
		map.put("uiName", "영우");
		map.put("uiId", "yeong");
		map.put("uiPwd", "yeong");
		map.put("uiDesc", "영우");
		map.put("uiBirth", "19990233");
		map.put("uiNum", "1");
		int result = uiDao.updateUserInfo(map);
		System.out.println(result);
		*/
		/*
		String uiNum = "1";
		int result = uiDao.deleteUserInfo(uiNum);
		System.out.println(result);
		*/
		

	}

}
