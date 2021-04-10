<%--
  Created by IntelliJ IDEA.
  User: ayunas
  Date: 9/10/20
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello SpringMVC Form</title>
</head>
<body>
<form action="processForm-3" method="get">
    <%--        the action= is the urlPattern over at the controller the name of the input is the param.studentName that goes to controller and gets sent out of the controller method--%>
    <input type="text" name="studentName" placeholder="What is your name?"/>
    <input type="submit"/>
</form>
</body>
</html>
