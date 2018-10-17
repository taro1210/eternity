<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板</title>
</head>
<body>
<h1>メッセージ一覧</h1>
<%
if (application.getAttribute("messages") != null) {
  List<String> messages = (List<String>) application.getAttribute("messages");
  out.println("<ol>");
  for (String message: messages) {
    out.println("<li>" + message + "</li>");
  }
  out.println("</ol>");
}
%>
<hr>
<h1>メッセージをどうぞ</h1>
<form action="BBSMain" method="post">
  <label>Name: <input type="text" name="name"></label>
  <label>Message: <input type="text" name="message"></label>
  <input type="submit" value="Send">
</form>
</body>
</html>