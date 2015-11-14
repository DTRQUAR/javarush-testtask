<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User was edited</title>
</head>
<body>
<center>
<p>You have edited a user with id ${id} at <%= new java.util.Date() %></p>
<c:url var="mainUrl" value="/jvtestbd/main/users" />
<p>Return to <a href="${mainUrl}">list of users</a></p>

    <br>
    </br>
    <img src="${pageContext.request.contextPath}/jrtest.png"/>
</center>
</body>
</html>