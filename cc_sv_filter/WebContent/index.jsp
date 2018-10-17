<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第11章　フィルタ</title>
</head>
<body>
<h2>ログイン画面</h2>
<hr>
<form action="./Login" method="post">
  <label for="userName">ユーザ名：</label>
  <input type="text" name="userName" id="userName" /><br />
  <label for="password">パスワード：</label>
  <input type="password" name="password" id="password" /><br />
  <input type="submit" value="ログイン" />
</form>
</body>
</html>