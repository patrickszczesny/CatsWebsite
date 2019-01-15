<%--
  Created by IntelliJ IDEA.
  User: goobar
  Date: 07.10.18
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOG IN</title>
</head>
<body>
<form action="/signIn" method="POST" target="_blank">
  LOGIN  <input type="text" name="login"/>
</br>
 PASSWORD
    <input type="password" name="password"/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
