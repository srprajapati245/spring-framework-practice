<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
    <%
      String welcomeMsg[] = (String[]) request.getAttribute("welcomeMessage");
      String singleMsg = "";
      for(String msg : welcomeMsg){
          singleMsg += msg + " ";
      }
      out.println(singleMsg);
    %>
  </body>
</html>