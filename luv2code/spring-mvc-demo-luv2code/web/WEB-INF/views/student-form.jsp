<%--
  Created by IntelliJ IDEA.
  User: ayunas
  Date: 9/14/20
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First Name : <form:input path="firstName"/>

    <br/>

    Last Name: <form:input path="lastName"/>

    <br/>

    Country:

    <form:select path="country">

        <%--            <form:option value="Brazil" label="Brazil" />--%>
        <%--            <form:option value="France" label="France" />--%>
        <%--            <form:option value="Germany" label="Germany" />--%>
        <%--            <form:option value="India" label="India" />--%>
        <%--            <form:option value="UK" label="UK" />--%>
        <%--            <form:option value="USA" label="USA" />--%>

        <form:options items="${student.countries}"/>


    </form:select>

    <input type="submit" value="Submit"/>

</form:form>

</body>
</html>
