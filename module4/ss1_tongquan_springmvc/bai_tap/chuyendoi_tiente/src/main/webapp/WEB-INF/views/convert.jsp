<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/26/2021
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Convert</h2>
<form method="post" action="/convert">

    <input type="text" name="usd" placeholder="Enter USD" required><br>

    <label>Convert to </label>
    <select name="vnd">
        <option value="22000" selected>VND</option>
    </select>

    <br>
    <input type="submit" value="Convert">
    <br>

    <h2>${result} VND</h2>
</form>
</body>
</body>
</html>
