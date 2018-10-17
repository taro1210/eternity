<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  int count = (Integer) application.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第11章　リスナー</title>
</head>
<body>
<h2>アクセス回数を表示</h2>
<p>アクセス数：<%= count %>回</p>
<a href="./AccessCounter">更新</a>
<a href="./AccessCounter?action=logout">ログアウト</a>
</body>
</html>