<%--
  Created by IntelliJ IDEA.
  User: wcshi
  Date: 2017/3/26
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查询商品列表</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <script type="text/javascript">
        function deleteItems() {
            document.itemsForm.action = "${pageContext.request.contextPath}/items/deleteItems";
            document.itemsForm.submit();
        }
        function queryItems() {
            document.itemsForm.action = "${pageContext.request.contextPath}/items/queryItems";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
    当前用户：${username}
    <c:if test="${username != null}">
        <a href="${pageContext.request.contextPath}/logout">退出</a>
    </c:if>
    商品名称：
    <select>
        <c:forEach items="${itemTypes}" var="itemType">
            <option value="${itemType.key}">${itemType.value}</option>
        </c:forEach>
    </select>
    <form name="itemsForm"  method="post">
        查询条件：
        <table width="100%" border="1">
            <tr>
                <td>商品名称：<input name="itemsCustom.name" /></td>
                <td><input type="button" value="查询" onclick="queryItems()"/>
                    <input type="button" value="批量删除" onclick="deleteItems()"/></td>
            </tr>
        </table>
        商品列表：
        <table width="100%" border="1">
            <tr>
                <td>选择</td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${itemsList}" var="item">
                <tr>
                    <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${item.detail}</td>
                    <td><a href="${pageContext.request.contextPath}/items/editItems?id=${item.id}">修改</a> </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>













