<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%@ page import="model.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
  List<Product> lists = (ArrayList<Product>) session.getAttribute("lists");
  Map<String,ShoppingCart> cart = (HashMap) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第８章　サンプルアプリケーション</title>
</head>
<body>
  <h3>商品一覧画面</h3>
    <p>商品件数：<%= lists != null ? lists.size() : "0" %>件</p>
    <p>購入商品件数：<%= cart != null ? cart.size() : "0" %>件</p>
  <table border="1">
    <tr>
      <th>商品コード</th>
      <th>商品名</th>
      <th>単価</th>
      <th>商品購入</th>
    </tr>
<%
  for(Product item : lists){
%>
    <tr>
      <td><%= item.getId() %></td>
      <td><%= item.getName() %></td>
      <td><%= item.getPrice() %></td>
      <td>
        <form action="./Cart" method="post">
          <input type="hidden" name="product_id" value="<%= item.getId() %>" />
          <input type="hidden" name="action" value="add" />
          <input type="submit" name="submit" value="カートへ">
        </form>
      </td>
    </tr>
<%
  }
%>
  </table>
  <a href="./Cart?action=logout">ログアウト</a>
</body>
</html>