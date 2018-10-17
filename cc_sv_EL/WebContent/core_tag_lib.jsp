<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   List<String> lists = new ArrayList<String>();
   lists.add("〜10歳");
   lists.add("11歳〜20歳");
   lists.add("21歳〜30歳");
   lists.add("31歳〜40歳");
   lists.add("41歳〜");
   session.setAttribute("lists", lists);

   Map<String,Integer> map = new HashMap<String,Integer>();
   map.put("あなご", 120);
   map.put("いくら",120);
   map.put("うに",150);
   map.put("えんがわ",150);
   map.put("大トロ",200);
   session.setAttribute("map",map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第12章　Coreタグライブラリ サンプル</title>
</head>
<body>
  <h3>○&lt;c:set&gt;タグ・&lt;c:out&gt;タグ</h3>
  <c:set var="data" value="20" />
  <c:out value="${data}" />
  <hr />
  <h3>○&lt;c:forEach&gt;タグ・&lt;c:out&gt;タグ</h3>
  <p>通常のfor文</p>
  <c:forEach var="count"  begin="0" end="${lists.size()-1}" step="1">
    <p><c:out value="${count}" /> : <c:out value="${lists[count]}"/></p>
  </c:forEach>
  <hr />
  <h3>○&lt;c:remove&gt;タグ・&lt;c:if&gt;タグ</h3>
  <c:remove var="lists" scope="session"/>
  <c:if test="${empty sessionScope.lists}">
    <p>リクエストスコープのインスタンスは削除されました</p>
  </c:if>
  <hr />
  <h3>○&lt;c:forEach&gt;タグ・&lt;c:choose&gt;タグ・&lt;c:when&gt;タグ</h3>
  <p>拡張for文</p>
  <table border="1">
     <tr>
      <th>メニュー</th>
      <th>価格</th>
      <th>皿の色</th>
     </tr>
  <c:forEach var="menu" items="${map}">
    <tr>
      <td><c:out value="${menu.key}" /></td>
      <td><c:out value="${menu.value}" /></td>
      <td>
        <c:choose>
          <c:when test="${menu.value <= 120}">なし</c:when>
          <c:when test="${menu.value <= 150}">赤</c:when>
          <c:when test="${menu.value <= 200}">金</c:when>
        </c:choose>
      </td>
     </tr>
  </c:forEach>
  </table>
</body>
</html>