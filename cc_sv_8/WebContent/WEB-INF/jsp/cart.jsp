<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%@ page import="model.ShoppingCart" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
  Map<String,ShoppingCart> cart = (HashMap<String, ShoppingCart>) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css" />
<title>第８章　サンプルアプリケーション</title>
</head>
<body>
  <h3>ショッピングカートの内容</h3>
<%
  if (cart != null ){
%>
  <table border="1">
    <tr>
      <th>商品コード</th>
      <th>商品名</th>
      <th>単価</th>
      <th>個数</th>
      <th>小計</th>
    </tr>
<%
    int sum = 0;
    for(String key : cart.keySet() ){
%>
      <tr>
        <td><%= cart.get(key).getProduct().getId() %></td>
        <td><%= cart.get(key).getProduct().getName() %></td>
        <td><%= cart.get(key).getProduct().getPrice() %></td>
        <td><%= cart.get(key).getCount() %></td>
        <td><%= cart.get(key).getProduct().getPrice() * cart.get(key).getCount() %>
      </tr>
<%
      sum = sum + cart.get(key).getProduct().getPrice() * cart.get(key).getCount();
    }
%>
    <tr>
      <td colspan="3">&nbsp;</td>
      <td>合計</td>
      <td><%= sum %></td>
    </tr>
  </table>
  <a href="./Cart?action=delete">カート内を空にする</a><br />
<%
  }else{
%>
  <p>カート内は空です。</p>
<%
  }
%>
  <a href="./Cart">ショッピングを続ける</a><br />
</body>
</html>