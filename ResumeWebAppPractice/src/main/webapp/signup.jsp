<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.entity.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.dao.inter.CountryDaoInter" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11.08.2023
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
%>
<%
    CountryDaoInter countryDao = Context.instanceCountryDao();
    List<Country> country = countryDao.getAll();
%>

<div style="text-align: center;font-size: 35px;padding-top: 5px">Sign Up:</div>
<div class="container">
    <div class="row">
        <div class="col-md-4 signup_fix ">
            <form action="SignUpController" method="POST">
                <div class="form-group">
                    <input type="hidden" name="id" value="<%=user.getId()%>">
                    <label for="name">name: </label>
                    <input class="form-control" type="text" name="name" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="surname">surname:</label>
                    <input class="form-control" type="text" name="surname" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="email">email: </label>
                    <input class="form-control" type="email" name="email" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="phone">phone: </label>
                    <input class="form-control" type="tel" name="phone" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="profileDescription">Profile Description: </label>
                    <input class="form-control" type="text" name="profileDescription" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="address">Address: </label>
                    <input class="form-control" type="text" name="address" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="birthdate">Birthdate: </label>
                    <input class="form-control" type="date" name="birthdate" value=""/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="birthplace">Birthplace: </label>
                    <%for (Country c : country) {%>
                    <input type="radio" name="birthplace" value="<%=c.getId()%>"/>
                    <label for="birthplace"><%=c.getName()%>
                    </label>
                    <%}%>
                    <br><br>
                </div>
                <div class="form-group">
                    <label for="nationality">Nationality: </label>
                    <%for (Country c : country) {%>
                    <input type="radio" name="nationality" value="<%=c.getId()%>"/>
                    <label for="nationality"><%=c.getNationality()%>
                    </label>
                    <%}%>
                    <br><br>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input class="form-control" type="password" name="password" value=""
                           placeholder="Password" required/>
                    <br>
                </div>
                <div class="form-group">
                    <label for="repeatPassword">Repeat Password:</label>
                    <input class="form-control" type="password" name="repeatPassword" value=""
                           placeholder="Repeat Password" required/>
                </div>
                <div class="d-flex justify-content-around align-items-center">
                    <input class="btn btn-primary mt-3" type="submit" name="save" value="Done">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
