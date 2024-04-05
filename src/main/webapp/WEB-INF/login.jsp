
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>

<form action="/jdbcex/login" method="post">
    <input type="text" name="mid" placeholder="아이디"><br>
    <input type="text" name="mpw" placeholder="비밀번호"><br>
    <input type="checkbox" name="auto">로그인 상태 유지<br>
    <button type="submit">로그인</button>
</form>
</body>
</html>
