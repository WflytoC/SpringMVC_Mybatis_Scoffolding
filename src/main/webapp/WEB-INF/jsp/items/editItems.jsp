<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wcshi
  Date: 2017/3/27
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editItems</title>
</head>
<body>
    <c:if test="${allErrors!=null}">
        <c:forEach items="${allErrors}" var="error">
            ${error.defaultMessage}
        </c:forEach>
    </c:if>

    <form id="itemForm" method="post" action="${pageContext.request.contextPath}/items/editItemsSubmit" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${itemsCustom.id}" />
        修改商品信息：
        <table width="100%" border="1">
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="name" value="${itemsCustom.name}"/></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="price" value="${itemsCustom.price}"/></td>
            </tr>
            <tr>
                <td>商品生产日期</td>
                <td><input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyy-MM-dd HH:mm:ss" />" /></td>
            </tr>
            <tr>
                <td>商品简介</td>
                <td>
                    <textarea rows="3" cols="30" name="detail" >${itemsCustom.detail}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
