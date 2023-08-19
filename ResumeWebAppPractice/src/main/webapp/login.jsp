<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.08.2023
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="css/login.css"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
<%User user = new User();%>
<div style="text-align: center;font-size: 35px;padding-top: 5px">Login:</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 login_fix">
            <form action="LoginController" method="POST">
                <div class="form-group">
                    <label for="email">name: </label>
                    <input class="form-control" type="email" name="email" value="" placeholder="Email"/>
                    <br>
                    <label for="password">password:</label>
                    <input class="form-control" type="password" name="password" value="" placeholder="Password"/>
                    <div class="d-flex justify-content-around align-items-center">
                        <input class="btn btn-primary mt-3" type="submit" name="save" value="Log in">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
