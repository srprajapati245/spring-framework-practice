<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 28/01/2018
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Organization home page</title>
</head>
<body>
    <h1>Organization home page</h1>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <ul>
        <li><a href="${contextPath}/jstlsql">List of organization using JSTL sql tag</a><br/></li>
        <li><a href="${contextPath}/service">List of organization using Service</a><br/></li>
    </ul>

</body>
</html>
