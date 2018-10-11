<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第7章　リクエストスコープ</title>
</head>
<body>
<%
  //リクエストスコープからgreetingインスタンスを取得
  String greeting = (String) request.getAttribute("greeting");

  //サーブレットにて「greeting」という変数を用意しているからそれを出力しよう
  out.print(greeting);
%>
</body>
</html>