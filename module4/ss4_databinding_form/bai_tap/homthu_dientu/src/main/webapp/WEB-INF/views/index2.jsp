<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/30/2021
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<table>
    <tr>
        <td>Languages:</td>
        <td>${email.languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spam Filter:</td>
        <c:if test="${email.spamsFilter == true}">
            <td>Enable spams filter</td>
        </c:if>
        <c:if test="${email.spamsFilter == false}">
            <td></td>
        </c:if>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
