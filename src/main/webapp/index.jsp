<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<body>
<h2>Hello World!</h2>

<a href="helloWorld">hello world</a>
</br>
<a href="ant/15/success">ant test</a>
</br>
<a href="test/requestParam?id=10&name=张三">RequestParam test</a>
<br>
<a href="test/requestHeader">RequestHeader test</a>
<br>
<a href="test/cookieValue">cookieValue test</a>
<br>
<a href="test/pathVariable/15">pathVariable test</a>
<br>
<a href="test/cookieValue">cookieValue test</a>
<br>
<a href="test/pathVariable/15">cookieValue test</a>
<br>
<form action="test/pojo" method="post">
    id:<input type="text" name="id">
    <br>
    name:<input type="text" name="name">
    <br>
    age:<input type="text" name="age">
    <br>
    classNo:<input type="text" name="classNo.calssCount">
    <br>
    className:<input type="text" name="classNo.calssName">
    <br>
    <input type="submit" value="submit">
</form>

</body>
</html>
