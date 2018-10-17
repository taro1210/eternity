<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板</title>
</head>
<body>
<h1>メッセージ一覧</h1>
<c:if test="${not empty messages }">
  <ol>
  <c:forEach var="message" items="${messages}">
  <li>
  <c:out value="${message}" />
  </li>
  </c:forEach>
  </ol>
</c:if>
<hr>
<h1>メッセージをどうぞ</h1>
<form action="BBSMain" method="post">
  <label>Name: <input type="text" name="name"></label>
  <label>Message: <input type="text" name="message"></label>
  <input type="submit" value="Send">
</form>
</body>
</html>