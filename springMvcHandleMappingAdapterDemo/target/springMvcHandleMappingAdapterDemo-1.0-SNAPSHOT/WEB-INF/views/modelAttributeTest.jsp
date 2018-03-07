<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 30/01/2018
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>@ModelAttribute Test</title>
    <style>
        h1, h2 {
            color: #08298A;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>@ModelAttribute Test Results</h1>
    <hr/>
    <div align="center">
        <c:if test="${testdata5A != null && testdata5B != null}">
            <h3 style="color: #DF0101">City: ${testdata5A}</h3>
            <h3 style="color: #DF0101">Zip Code: ${testdata5B}</h3>
        </c:if>
        <c:if test="${testdata6 != null}">
            Address relocated to: <h3 style="color: #DF0101">${testdata6.city}, ${testdata6.zipCode}</h3>
        </c:if>
    </div>
</body>
</html>
