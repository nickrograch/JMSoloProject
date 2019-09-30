<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: nikita.grachev
  Date: 9/30/2019
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <form method="get">
    <table border="2">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Fathername</td>
        </tr>
        <%
            List<User> list = UserService.getInstance().getAllUsers();
            for (int i = 0; i < list.size() - 1; i++){
        %>
        <tr><td><%=list.get(i).getId() %></td></tr>
        <tr><td><%=list.get(i).getName() %></td></tr>
        <tr><td><%=list.get(i).getSurname() %></td></tr>
        <tr><td><%=list.get(i).getFatherName() %></td></tr>
        <%
            }
        %>
    </table>
    </form>
</body>
</html>
