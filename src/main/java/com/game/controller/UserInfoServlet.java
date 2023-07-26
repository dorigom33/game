package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;


@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			List<Map<String,String>> userInfoList = uiService.selectUserInfoList(null);
			request.setAttribute("userInfoList", userInfoList);
		}else if("view".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiService.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		if("insert".equals(cmd)) {
			String uiId = request.getParameter("uiId");
			String uiName = request.getParameter("uiName");
			String uiPwd = request.getParameter("uiPwd");
			String uiDesc = request.getParameter("uiDesc");
			String uiBirth = request.getParameter("uiBirth");
			Map<String, String> userInfo = new HashMap<>();
			userInfo.put("uiId", uiId);
			userInfo.put("uiName", uiName);
			userInfo.put("uiPwd", uiPwd);
			userInfo.put("uiDesc", uiDesc);
			userInfo.put("uiBirth", uiBirth.replace("-", ""));
			int result = uiService.insertUserInfo(userInfo);
			request.setAttribute("msg", "유저등록성공");
			request.setAttribute("url", "/user-info/login");
			if(result!=1) {
				request.setAttribute("msg", "유저등록실패");
				request.setAttribute("url", "/user-info/insert");
			}
		}else if ("update".equals(cmd)) {
	        String uiId = request.getParameter("uiId");
	        String uiName = request.getParameter("uiName");
	        String uiPwd = request.getParameter("uiPwd");
	        String uiDesc = request.getParameter("uiDesc");
	        String uiBirth = request.getParameter("uiBirth");
	        Map<String, String> userInfo = new HashMap<>();
	        userInfo.put("uiId", uiId);
	        userInfo.put("uiName", uiName);
	        userInfo.put("uiPwd", uiPwd);
	        userInfo.put("uiDesc", uiDesc);
	        userInfo.put("uiBirth", uiBirth.replace("-", ""));
	        int result = uiService.updateUserInfo(userInfo);
	        request.setAttribute("msg", "유저수정성공"); 
	        request.setAttribute("url", "/user-info/view?uiNum=" + uiId); 
	        if (result != 1) {
	            request.setAttribute("msg", "유저수정실패");
	            request.setAttribute("url", "/user-info/update" + uiId); 
	        }
		}else if ("delete".equals(cmd)) {
			
		}
		CommonView.forwardMessage(request, response);
	}
}
