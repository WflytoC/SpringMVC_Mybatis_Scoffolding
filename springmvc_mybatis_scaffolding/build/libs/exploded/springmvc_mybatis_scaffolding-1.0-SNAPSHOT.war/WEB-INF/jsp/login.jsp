<%--
  Created by IntelliJ IDEA.
  User: wcshi
  Date: 2017/3/28
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/login">
        用户名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password"/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
