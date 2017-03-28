<%--
  Created by IntelliJ IDEA.
  User: wcshi
  Date: 2017/3/27
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json 测试</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/requestJson',
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                data: JSON.stringify({"name": "手机","price": 99.9}),
                success: function (data) {
                    alert(data);
                    console.log(data);
                }
            });
        }
        function responseJson() {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/responseJson',
                data: 'name=手机&price=99.9',
                success: function (data) {
                    alert(data);
                    console.log(data);
                }
            });
        }
    </script>
</head>
<body>
    <input type="button" onclick="requestJson()" value="请求JSon，输出是JSon"/>
    <input type="button" onclick="responseJson()" value="请求key/value，输出是JSon"/>
</body>
</html>
