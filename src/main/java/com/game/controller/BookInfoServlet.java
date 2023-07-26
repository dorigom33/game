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

import com.game.common.CommonView;
import com.game.service.BookInfoService;
import com.game.service.impl.BookInfoServiceImpl;


@WebServlet("/book-info/*")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookInfoService biService = new BookInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			List<Map<String, String>> bookInfoList = biService.selectBookInfoList(null);
			request.setAttribute("bookInfoList", bookInfoList);
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			Map<String, String> bookInfo = biService.selectBookInfo(biNum);
			request.setAttribute("bookInfo", bookInfo);
		}
		CommonView.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		if("insert".equals(cmd)) {
			Map<String, String> bookInfo = new HashMap<>();
			bookInfo.put("biTitle", request.getParameter("biTitle"));
			bookInfo.put("biAuth", request.getParameter("biAuth"));
			int result = biService.insertBookInfo(bookInfo);
			request.setAttribute("msg", "책 등록 성공!");
			request.setAttribute("url", "/book-info/list");
			if(result != 1) {
				request.setAttribute("msg", "책 등록 실패.....");
				request.setAttribute("url", "/book-info/insert");
			}
		}else if("update".equals(cmd)) {
			Map<String, String> bookInfo = new HashMap<>();
			bookInfo.put("biTitle", request.getParameter("biTitle"));
			bookInfo.put("biAuth", request.getParameter("biAuth"));
			String biNum = request.getParameter("biNum");
			bookInfo.put("biNum", biNum);
			int result = biService.updateBookInfo(bookInfo);
			request.setAttribute("msg", "책 수정 성공!");
			request.setAttribute("url", "/book-info/view?biNum=" + biNum);
			if(result != 1) {
				request.setAttribute("msg", "책 수정 실패...");
				request.setAttribute("url", "/book-info/update?biNum=" + biNum);
			}
		}else if("delete".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			int result = biService.deleteBookInfo(biNum);
			request.setAttribute("msg", "책 삭제 성공!");
			request.setAttribute("url", "/book-info/list");
			if (result!=1) {
				request.setAttribute("msg", "책 삭제 실패...");
				request.setAttribute("url", "/book-info/view?biNum=" + biNum);
			}
		}
		CommonView.forwardMessage(request, response);
	}

}
