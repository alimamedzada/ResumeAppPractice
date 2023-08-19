<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 17.08.2023
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div style="text-align: center; color: red;font-size: 25px">
    <%=request.getParameter("msg")%>
</div>
</body>
</html>
