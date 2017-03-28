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
        function editItemsAllSubmit() {
            document.itemsForm.action = "${pageContext.request.contextPath}/items/editItemsAllSubmit";
            document.itemsForm.submit();
        }
        function queryItems() {
            document.itemsForm.action = "${pageContext.request.contextPath}/items/queryItems";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
    <form name="itemsForm"  method="post">
        查询条件：
        <table width="100%" border="1">
            <tr>
                <td>商品名称：<input name="itemsCustom.name" /></td>
                <td><input type="button" value="查询" onclick="queryItems()"/>
                    <input type="button" value="批量修改提交" onclick="editItemsAllSubmit()"/></td>
            </tr>
        </table>
        商品列表：
        <table width="100%" border="1">
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${itemsList}" var="item" varStatus="status">
                <tr>
                    <td><input name="itemsList[${status.index}].name" value="${item.name}" /></td>
                    <td><input name="itemsList[${status.index}].price" value="${item.price}" /></td>
                    <td><input name="itemsList[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
                    <td><input name="itemsList[${status.index}].detail" value="${item.detail}" /></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>













