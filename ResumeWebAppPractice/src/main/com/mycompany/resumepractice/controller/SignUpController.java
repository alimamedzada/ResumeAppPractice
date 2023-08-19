package com.mycompany.resumepractice.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})

public class SignUpController extends HttpServlet {
	private static BCrypt.Hasher crypt = BCrypt.withDefaults();

	UserDaoInter userDao = Context.instanceUserDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("users.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

//		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String profileDescription = req.getParameter("profileDescription");
		String address = req.getParameter("address");
		Date birthdate = Date.valueOf(req.getParameter("birthdate"));
		int birthplaceId = Integer.valueOf(req.getParameter("birthplace"));
		int nationalityId = Integer.valueOf(req.getParameter("nationality"));
		String password = req.getParameter("password");
		String repeatPassword = req.getParameter("repeatPassword");
//		if (password != repeatPassword || name == null
//				|| email == null || password == null || repeatPassword == null) {
//			resp.sendRedirect("error?msg=" + (new Exception().getMessage()));
//		}
		if (!password.equals( repeatPassword)) {
			resp.sendRedirect("error?msg=" + "Zehmet olmasa, shifreleri duzgun yazin...");
		}else {
		User user = new User();

		user.setName(name);
		user.setSurname(surname);
		user.setPhone(phone);
		user.setEmail(email);
		user.setProfileDescription(profileDescription);
		user.setAddress(address);
		user.setBirthDate((java.util.Date) birthdate);
		user.setNationality(new Country(nationalityId));
		user.setBirthPlace(new Country(birthplaceId));
		user.setPassword(password);
//			User user = User.builder().name(name).surname(surname).phone(phone)
//					.email(email).profileDescription(profileDescription).address(address).birthDate(birthdate)
//					.nationality(Country.builder().id(nationalityId).build()).birthPlace(Country.builder()
//							.id(birthplaceId).build()).password(password).build();
		userDao.addUser(user);
		resp.sendRedirect("login.jsp");
	}
	}
}
