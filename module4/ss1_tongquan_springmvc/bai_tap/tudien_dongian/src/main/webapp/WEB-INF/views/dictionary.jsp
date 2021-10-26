<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/26/2021
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<html>
<head>
    <title>Title</title>
    <style>
        input {
            margin-top: 2%;
        }

        #enter {
            width: 20%;
        }

    </style>
</head>
<body>
<h2>Simple Dictionary</h2>
<form method="post" action="/dictionary">
    <input id="enter" type="text" name="inputWord" placeholder="Enter a word that you want to translate " required><br>
    <input type="submit" value="Translate"><br>
    <h2>${result}</h2>
</form>
</body>
</html>
