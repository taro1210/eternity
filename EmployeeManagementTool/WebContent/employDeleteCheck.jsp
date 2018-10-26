<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報：削除確認</title>
</head>
<style>
      p{
        color:red;
      }
</style>
<%String count =request.getParameter("count"); %>

<body>
<h2>選択した項目を削除します</h2>
<br>
<p>※操作は取り消せません。<br><span style="font-size:x-large">よろしいですか？</span></p>
<br>
<form action="employManager.jsp">
		<input type="submit" value=" キャンセル ">
</form>
<form action="/deleteEmployee" method="post">
		<input type="hidden" name="count" value="<%=Integer.parseInt(count) %>">
		<input type="submit" value=" 実行 ">
</form>
<input type="button" onclick="location.href='employManager.jsp'"value=" キャンセル ">
<input type="button" onclick="location.href='employDelete.jsp'"value=" 実行 ">
</body>
</html>