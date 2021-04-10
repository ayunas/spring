<%--
  Created by IntelliJ IDEA.
  User: ayunas
  Date: 8/28/20
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    String username = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) username = cookie.getValue();
        }
        if (username == null) response.sendRedirect("login.html");
    }
%>
<h3> Welcome <%=username %> You have successfully logged in</h3>
<br>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
