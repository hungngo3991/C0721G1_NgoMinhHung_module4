<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/28/2021
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich" method="post">
    <c:if test="${requestScope['spice'] != null}">
        <ul>
            <c:forEach items="${requestScope['spice']}" var="spice">
                <li><c:out value="${spice}"/></li>
            </c:forEach>
        </ul>
    </c:if>
    <div>
        <input type="checkbox" name="spice" value="Lettuce"> <label>Lettuce</label>
        <input type="checkbox" name="spice" value="Tomato"> <label>Tomato</label>
        <input type="checkbox" name="spice" value="Mustard"> <label>Mustard</label>
        <input type="checkbox" name="spice" value="Sprouts"> <label>Sprouts</label>
    </div>
    <div>
        <button type="submit">Save</button>
    </div>
</form>
</body>
</html>