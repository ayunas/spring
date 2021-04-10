<%--
  Created by IntelliJ IDEA.
  User: ayunas
  Date: 9/10/20
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Name Page</title>
</head>
<body>
<p>Student name : ${param.studentName}  </p>
<p>The message : ${message} </p>
<a href="form">Return to Form</a>
<a href="silly/form">Go to the Silly Page</a>
<a href="${pageContext.request.contextPath}/">Go Home</a>
</body>
</html>
