<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
  List<String> messages = (ArrayList<String>) session.getAttribute("messages");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第８章　セッションIDとクッキー</title>
</head>
<body>
<%
  if( messages != null ){
    for( String message : messages) {
%>
  <p><%= message %></p>
<%
    }
  }
%>
<a href="./SessionID">リロード</a>
</body>
</html>