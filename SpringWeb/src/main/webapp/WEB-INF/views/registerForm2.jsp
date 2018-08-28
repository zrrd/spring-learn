<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        span.error {
            color: red;
        }
        div.error{
            background-color: #ffcccc;
            border: 2px solid red;
        }
    </style>
</head>
<body>
<sf:form method="post" commandName="spitterDto" >
    <%--展示所有属性的错误信息--%>
    <sf:errors path="*" element="div" cssClass="error"/>

    First Name :<sf:input path="firstName"/>
    <sf:errors path="firstName" cssClass="error"/><br/>
    Last Name :<sf:input path="lastName"/>
    <sf:errors path="lastName" cssClass="error"/><br/>
    Username:<sf:input path="username"/>
    <sf:errors path="username" cssClass="error"/><br/>
    Password:<sf:input path="password"/>
    <sf:errors path="password" cssClass="error"/><br/>
    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>
