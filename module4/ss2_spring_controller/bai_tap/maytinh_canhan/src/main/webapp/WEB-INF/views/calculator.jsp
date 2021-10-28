<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/28/2021
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/calculator">

    <input type="text" name="firstN">

    <input type="text" name="secondN">

    <div>
        <button type="submit" name="calculate" value="+">Addition(+)</button>
        <button type="submit" name="calculate" value="-">Subtraction(-)</button>
        <button type="submit" name="calculate" value="*">Multiplication(X)</button>
        <button type="submit" name="calculate" value="/">Division(/)</button>
    </div>
    <c:if test="${requestScope['result'] != null}">
        <p>Result Division: <c:out value="${requestScope['result']}"/></p>
    </c:if>
</form>
</body>
</html>
