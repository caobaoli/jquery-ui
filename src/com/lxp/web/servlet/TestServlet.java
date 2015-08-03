package com.lxp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class TestServlet extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		user = request.getParameter("login_user");
		pass = request.getParameter("login_pass");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String date = request.getParameter("date");
		System.out.println(user+">"+pass+">"+email+">"+sex+">"+date);
		
		response.setContentType("text/html; charset=UTF-8");
		//给前台页面响应
		response.getWriter().print("false");
		response.getWriter().close();
		
	}

}
