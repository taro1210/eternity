<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.UserBean" %>
<%@ page import="model.Gender" %>
<%
  //リクエストスコープに保持されているUserBeanインスタンスを取得（キャスト必要）
  UserBean bean = (UserBean) request.getAttribute("user");
  //リクエストスコープに保持されている挨拶コメント用のインスタンスを取得
  String message = (String) request.getAttribute("greeting");
%>
<!DOCTYPE html>
<html>
<head>
<title>第７章　リクエストスコープ（確認画面）</title>
</head>
<body>
<h2>確認画面</h2>
<h3><%= message %></h3>
<p>
氏名：<%= bean.getFullName() %>　様<br />
年齢：<%= bean.getAge() %>　歳<br />
性別：<%= bean.isMale() ? Gender.Male : Gender.Female %>
</p>
</body>
</html>