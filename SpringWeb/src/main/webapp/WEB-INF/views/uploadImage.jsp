<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/spitter/uploadImage2">
    <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif"/><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>
