<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 12/01/2022
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/edit">

    <input name="id" value="${nhanvien.id}">
    <br>
    <input name="name" value="${nhanvien.name}">
    <br>
    <input name="age" value="${nhanvien.age}">
    <br>
    <input name="address" value="${nhanvien.address}">
    <br>
    <input name="phone" value="${nhanvien.phone}">
    <br>

    <button type="submit">Submit</button>
</form>
</body>
</html>