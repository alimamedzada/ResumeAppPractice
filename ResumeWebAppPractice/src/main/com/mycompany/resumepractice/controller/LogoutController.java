package com.mycompany.resumepractice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		System.out.println(session);
		System.out.println(session.getAttribute("loggedInUser"));
		if (session != null) {
			session.removeAttribute("loggedInUser");
			session.invalidate();
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);

	}
}
