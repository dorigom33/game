package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(uiService.selectUserInfoList(null));
		}else if("view".equals(cmd) || "update".equals(cmd)) {
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");

	        // Read JSON data from the request
	        BufferedReader br = request.getReader();
	        StringBuffer sb = new StringBuffer();
	        String str;
	        while ((str = br.readLine()) != null) {
	            sb.append(str);
	        }

	        // Convert JSON data to a Map
	        Map<String, String> userInfo = gson.fromJson(sb.toString(), new TypeToken<Map<String, String>>() {}.getType());

	        // Process the userInfo data as needed
	        String cmd = CommonView.getCmd(request);
	        if ("insert".equals(cmd)) {
	            int result = uiService.insertUserInfo(userInfo);
	            request.setAttribute("msg", "유저 등록 성공");
	            request.setAttribute("url", "/user-info/login");
	            if (result != 1) {
	                request.setAttribute("msg", "유저 등록 실패");
	                request.setAttribute("url", "/user-info/insert");
	            }
	        } else if ("update".equals(cmd)) {
	            String uiNum = userInfo.get("uiNum");
	            int result = uiService.updateUserInfo(userInfo);
	            request.setAttribute("msg", "유저 수정 성공");
	            request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
	            if (result != 1) {
	                request.setAttribute("msg", "유저 수정 실패");
	                request.setAttribute("url", "/user-info/update?uiNum=" + uiNum);
	            }
	        } else if ("delete".equals(cmd)) {
	            String uiNum = userInfo.get("uiNum");
	            int result = uiService.deleteUserInfo(uiNum);
	            request.setAttribute("msg", "유저 삭제 성공");
	            request.setAttribute("url", "/user-info/list");
	            if (result != 1) {
	                request.setAttribute("msg", "유저 삭제 실패");
	                request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
	            }
		}else if("login".equals(cmd)) {
			request.setAttribute("msg", "아이디나 비밀번호를 확인하세요");
			request.setAttribute("url", "/user-info/login");
			HttpSession session = request.getSession();
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			Map<String,String> ui = uiService.login(uiId);
			if(ui!=null) {
				String dbUiPwd = ui.get("uiPwd");
				if(uiPwd.equals(dbUiPwd)) {
					request.setAttribute("msg", "로그인이 성공하였습니다.");
					request.setAttribute("url", "/");
					
					session.setAttribute("user", ui);
				}
			}
		}
		CommonView.forwardMessage(request,response);
	}
}
