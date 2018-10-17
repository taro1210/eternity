<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="message" scope="request" class="java.lang.String"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第12章　標準アクションタグ</title>
</head>
<body>
<h2>転送先ページ</h2>
<p><%= message %></p>
</body>
</html>