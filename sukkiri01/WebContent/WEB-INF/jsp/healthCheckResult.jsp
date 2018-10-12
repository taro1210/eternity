<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Health" %>
    <% Health health = (Health)request.getAttribute("health"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あなたのBMIは??</title>
</head>
<body>
<h2><%=health.getName() %>さんの結果</h2>
<p>
身  長 : <%=health.getHeight() %>cm<br>
<br>
体  重 : <%=health.getWeight() %>kg<br>
<br>
ＢＭＩ : <%=health.getBmi() %><br>
<br>
判定 … <%=health.getBodyType() %><br>
「<%=health.getMessege() %>」
<br>
</p>
<br>
<a href="/sukkiri/HealthCheck">もう一度</a>
</body>
</html>