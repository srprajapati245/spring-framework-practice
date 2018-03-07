<%--
  Created by IntelliJ IDEA.
  User: Rudra Automation
  Date: 28/01/2018
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Location details</title>
    <style>
        input[type=text] {
            padding: 10px;
            margin: 10px;
            font-size: 20px;
        }
        input[type=submit] {
            border: none;
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            margin: 16px;
            cursor: pointer;
            font-size: 20px;
        }
        h2 {
            color: #08298A;
            text-align: center;
        }
    </style>
</head>
<body>
    <h2 style="color: #DF0101">
        <c:out value="${greeting}"></c:out>
    </h2>
    <hr/>
    <h2>Submit your location for a list of Organizations</h2>

    <div style="text-align: center">
        <form action="listOrgs">
            <input type="text" name="locationName"><br/>
            <input type="submit" value="Get Organizations"><br/>
        </form>
    </div>

</body>
</html>
