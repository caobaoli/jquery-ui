package com.lxp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxp.service.UserService;
import com.lxp.service.impl.UserServiceImpl;
import com.lxp.vo.User;

import net.sf.json.JSONObject;

public class TestServlet extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		String param = request.getParameter("param");
		System.out.println(param);
		if("reg".equals(param)) {
			String account = request.getParameter("user");
			String pass = request.getParameter("pass");
			String email = request.getParameter("email");
			String sex = request.getParameter("sex");
			String date = request.getParameter("date");
			String id = UUID.randomUUID().toString();
			
			System.out.println(account+">"+pass+">"+email+">"+sex+">"+date);
			
			User currUser = new User(id, account, pass, email, sex, date);
			try {
				userService.save(currUser);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			response.setContentType("text/html; charset=UTF-8");
			//给前台页面响应
			response.getWriter().print("true");
			response.getWriter().close();
		} else if("regValidate".equals(param)) {
			String account = request.getParameter("user");
			try {
				if(userService.findByAccount(account) != null) {
					response.setContentType("text/html; charset=UTF-8");
					//给前台页面响应
					response.getWriter().print("false");
					response.getWriter().close();
				} else {
					response.setContentType("text/html; charset=UTF-8");
					//给前台页面响应
					response.getWriter().print("true");
					response.getWriter().close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if("loginValidate".equals(param)) {
			String account = request.getParameter("login_user");
			String pass = request.getParameter("login_pass");
			try {
				User user = userService.findByAccount(account);
				if(pass.equals(user.getPass())) {
					response.setContentType("text/html; charset=UTF-8");
					//给前台页面响应
					response.getWriter().print("true");
					response.getWriter().close();
				} else {
					response.setContentType("text/html; charset=UTF-8");
					//给前台页面响应
					response.getWriter().print("false");
					response.getWriter().close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else if("login".equals(param)) {
			response.setContentType("text/html; charset=UTF-8");
			//给前台页面响应
			response.getWriter().print("true");
			response.getWriter().close();
		} else if("loginValidate2".equals(param)) {
			String account = request.getParameter("login_user");
			System.out.println(account);
			try {
				if(userService.findByAccount(account) == null) {
					response.setContentType("text/html; charset=UTF-8");
					//给前台页面响应
					response.getWriter().print("false");
					response.getWriter().close();
				} else {
					response.setContentType("text/html; charset=UTF-8");
					//给前台页面响应
					response.getWriter().print("true");
					response.getWriter().close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
