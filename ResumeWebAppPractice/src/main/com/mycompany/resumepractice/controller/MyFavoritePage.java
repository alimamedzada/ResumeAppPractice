//package com.mycompany.resumepractice.controller;
//
//import com.mycompany.dao.impl.SkillDaoImpl;
//import com.mycompany.main.Context;
//import com.mycompany.dao.inter.SkillDaoInter;
//import com.mycompany.dao.inter.UserDaoInter;
//import com.mycompany.entity.Skill;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
//public class MyFavoritePage extends HttpServlet {
//	private UserDaoInter userDao = Context.instanceUserDao();
//	private SkillDaoInter skillDao = new SkillDaoImpl();
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//
//		try (PrintWriter out = response.getWriter()) {
//			out.println(skillDao.getAll());
//		}
//		request.getContextPath();
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String name = String.valueOf(request.getParameter("name"));
//		Skill s = Skill.builder().name(name).build();
//		Boolean skill = skillDao.insertSkill(s);
//
//		try (PrintWriter out = response.getWriter()) {
//			out.println(s.getName());
//		}
//		request.getContextPath();
//	}
//
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//	}
//
//	protected void doDelete(HttpServletRequest req,
//	                        HttpServletResponse resp)
//			throws ServletException, IOException {
//	}
//
//}
