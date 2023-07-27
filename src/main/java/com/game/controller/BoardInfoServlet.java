package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;


@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardInfoService boardInfoService = new BoardInfoServiceImpl();
	
    private boolean isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			request.setAttribute("msg",	"로그인이 필요한 화면입니다.");
			request.setAttribute("url", "/user-info/login");
			CommonView.forwardMessage(request, response);
			return false;
		}
    	return true;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!isLogin(request, response)) {
			return;
		}
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			List<Map<String,String>> boardInfoList = boardInfoService.selectBoardInfoList(null);
			request.setAttribute("boardInfoList", boardInfoList);
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			Map<String, String> boardInfo = boardInfoService.selectBoardInfo(biNum);
			request.setAttribute("boardInfo", boardInfo);
			return;
		}
		CommonView.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		Map<String, String> boardInfo = new HashMap<>();
		
		if(!isLogin(request, response)) {
			return;
		}
	}

}
