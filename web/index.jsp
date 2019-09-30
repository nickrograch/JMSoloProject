<%--
  Created by IntelliJ IDEA.
  User: nikita.grachev
  Date: 9/26/2019
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Solo Project</title>
  </head>
  <body>
  <form action = "connectiontype" method="post">
    Choose the database connection type
    <select name = "connectionType">
      <option value="hibernate">hibernate</option>
      <option value="JDBC">JDBC</option>
    </select>
    <br/><br/>
    <input type = "submit" value="Submit" />
  </form>

  </body>
</html>
