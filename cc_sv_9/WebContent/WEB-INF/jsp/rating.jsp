<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Rate" %>
<%
  Rate rate = (Rate) application.getAttribute("rate");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第9章　アプリケーションスコープ</title>
</head>
<body>
<p>これまでの評価平均: <%= rate.getRating() %> 点</p>
<p>評価件数: <%= rate.getNumber() %> 件</p>
<hr>
<h3>あなたの評価は？</h3>
<form action="./ApplicationScope" method="post">
  <input type="hidden" name="action" value="add" />
  <label for="score">評価点：</label>
  <input type="text" name="score" id="score" value="" /><br />
  <input type="submit" value="送信" />
</form>
</body>
</html>