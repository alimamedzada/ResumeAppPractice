<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 18.08.2023
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="css/login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();
    User user = userDao.getById(Integer.valueOf(request.getParameter("id")));
%>
<div class="container">
    <div style="text-align: center;font-size: 35px;padding-top: 5px">Change Password:</div>
    <div class="row">
        <div class="col-md-4 signup_fix">
            <form action="ChangePasswordController" method="POST">
                <%--                <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>--%>
                <%--                <input type="hidden" name="id" value="<%=u.getId()%>"/>--%>
                <div class="form-group">
                    <input type="hidden" name="id" value="<%=user.getId()%>"/>
                    <label for="">New Password</label>
                    <input class="form-control" type="password" name="newPassword" value=""
                           placeholder="New Password" required>
                </div>
                <div class="form-group">
                    <label for="">Confirm Password</label>
                    <input class="form-control" type="password" name="confirmPassword" value=""
                           placeholder="Confirm Password" required>
                </div>
                <div class=" d-flex justify-content-around align-items-center pt-3">
                    <input type="submit" class="btn btn-success" value="Done" name="changePass">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
