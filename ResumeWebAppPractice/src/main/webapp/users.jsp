<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.mycompany.entity.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.dao.inter.CountryDaoInter" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.08.2023
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <title>Users</title>
</head>
<body>
<%--<jsp:include page="header.jsp">--%>
<%
    User user = (User) session.getAttribute("loggedInUser");
%>
<%
    UserDaoInter userDao = Context.instanceUserDao();

    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String nationalityIdStr = request.getParameter("nid");
    Integer nationalityId = null;

    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }

    List<User> list = userDao.getAll(name, surname, nationalityId);
%>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <form action="users" method="GET">
                id= <%=user.getId()%>
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <div class="form-group">
                    <label for="name">name: </label>
                    <input class="form-control" type="text" name="name" value="<%=user.getName()%>"/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="surname">surname:</label>
                    <input class="form-control" type="text" name="surname" value="<%=user.getSurname()%>"/>
                    <br>
                </div>
                <input class="btn btn-primary" type="submit" name="search" value="Search" id="btnsearch"/>
            </form>
            <div style="display: inline-block;padding-top: 5px">
                <form action="LogoutController" method="POST">
                    <input class="btn btn-primary" type="submit" name="logout" value="Logout"/>
                </form>
            </div>
            <div style="display: inline-block;padding-top: 5px">
                <form action="signup.jsp" method="GET">
                    <input class="btn btn-primary" type="submit" name="addUser" value="Add user"/>
                </form>
            </div>
            <div style="display: inline-block;padding-top: 5px">
                <form action="ChangePasswordController" method="GET">
                    <input type="hidden" name="id" value="<%=user.getId()%>">
                    <button class="btn btn-primary" type="submit">
                        Change Password
                    </button>
                </form>
            </div>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th> Surname</th>
            <th> Nationality</th>
        </tr>
        </thead>
        <tbody>
        <%for (User u : list) {%>
        <tr>
            <td>
                <%=u.getName()%>
            </td>
            <td>
                <%=u.getSurname()%>
            </td>
            <td>
                Salam
                <%--                <%=u.getNationality().getNationality() == null ? "N/A" : u.getNationality().getNationality()%>--%>
            </td>
            <td style="width: 5px">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button class="btn btn-danger" type="submit" value="delete" data-toggle="modal"
                            onclick="idForDelete(<%=u.getId()%>)"
                            data-target="#exampleModal">
                        <i class="fa-solid fa-trash"></i>
                    </button>
                </form>
            </td>
            <td style="width: 5px">
                <form action="userdetail" method="GET">
                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                    <input type="hidden" value="update" name="action"/>
                    <button class="btn btn-secondary" type="submit" value="update">
                        <i class="fa-solid fa-pen"></i>
                    </button>
                </form>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
