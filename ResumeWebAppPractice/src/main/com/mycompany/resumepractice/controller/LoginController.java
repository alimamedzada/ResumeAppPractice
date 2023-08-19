package com.mycompany.resumepractice.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})

public class LoginController extends HttpServlet {
	UserDaoInter userDao = Context.instanceUserDao();
	BCrypt.Verifyer verifyer = BCrypt.verifyer();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			User user = userDao.findByEmail(email);

			BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());

			if (!rs.verified) {
				throw new IllegalArgumentException("password is incorrect.");
			}

			if (user == null) {
				throw new IllegalArgumentException("user doesn't exist");
			}
			resp.sendRedirect("users.jsp");
			req.getSession().setAttribute("loggedInUser", user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
