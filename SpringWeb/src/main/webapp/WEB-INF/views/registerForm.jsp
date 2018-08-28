<%--
  Created by IntelliJ IDEA.
  User: jiudao
  Date: 2017/12/25
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Register</h1>
    <form action="${pageContext.request.contextPath}/spitter/register3" method="post">
    First Name:<input type="text" name="firstName" /><br/>
    Last Name:<input type="text" name="lastName" /><br/>
    User Name:<input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Register" />
    </form>
</body>
</html>
