package com.mycompany.resumepractice.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {
	UserDaoInter userDao = Context.instanceUserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Integer userId = Integer.parseInt(req.getParameter("id"));
		User u = userDao.getById(userId);

//		req.setAttribute("user", u);
		req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		System.out.println(id);
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		User u = userDao.getById(id);
		u.setPassword(newPassword);
		userDao.updateUser(u);
		resp.sendRedirect("users.jsp");
		req.getSession().setAttribute("user", u);

	}
}
