<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 29/01/2018
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>@RequestMapping and @RequestParam Test Results 2</title>
</head>
<body>
<div align="center">
    <h1>${testserial}: @RequestMapping and @RequestParam Test Results 2</h1>
    <c:forEach var="parameter" items="${param}">
        <h3 style="color:#DF0101"><c:out value="${parameter.key}"/> = <c:out value="${parameter.value}"/></h3>
    </c:forEach>

</div>

</body>
