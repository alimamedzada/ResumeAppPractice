<%-- 
    Document   : header
    Created on : Aug 17, 2023, 10:35:47 PM
    Author     : Asus
--%>

<%@page import="com.mycompany.entity.User"%>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("loggedInUser");
%>
<%=user.getName()%>