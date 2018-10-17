<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アプリケーションスコープ</title>
</head>
<body>
<%
        Integer count = (Integer) application.getAttribute("count");
%>
<h1>アプリケーションコープのテスト</h1>
<% if (count != null) { %>
現在のカウントは<%= count %>です。
<% } else { %>
まだ、カウントアップされていません。
<% } %>
<form action="ApplicationScope" method="post">
        <input type="submit" name="button" value="カウンタクリア">
        <input type="submit" name="button" value="カウントアップ">
</form>
</body>
</html>