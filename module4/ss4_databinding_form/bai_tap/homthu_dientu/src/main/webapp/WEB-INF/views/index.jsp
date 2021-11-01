<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/30/2021
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .submit{
            position: relative;
            left: 100px;
        }
    </style>
</head>
<body>
<h1>Settings</h1>


<form:form method="post" action="/index/update" modelAttribute="email">
    <table>
        <tr>
            <td style="font-weight: bolder"><form:label path="languages">Languages: </form:label></td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td style="font-weight: bolder"><form:label path="pageSize">Page Size: </form:label></td>
            <td>Show <form:select path="pageSize" items="${pageSize}"/> emails per page</td>
        </tr>
        <tr>
            <td style="font-weight: bolder"><form:label path="spamsFilter">Spam Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td style="font-weight: bolder"><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr class="submit">
            <td><input type="submit" value="Update"/></td>
            <td><input type="submit" value="Cancel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
