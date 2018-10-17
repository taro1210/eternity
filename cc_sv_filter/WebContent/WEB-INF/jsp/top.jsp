<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
  Map<String,String> user = (HashMap<String,String>) session.getAttribute("user");
  String userName = user.get("userName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第11章　フィルタ</title>
</head>
<body>
<h2>ログイン成功画面</h2>
<hr>
  <p><%= userName %>さん　ようこそ</p>
</body>
</html>