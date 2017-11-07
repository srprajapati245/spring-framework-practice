<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
    <c:forEach var="messageItem" items="${welcomeMessage}">
      <c:out value="${messageItem}"></c:out>
    </c:forEach>
  </body>
</html>