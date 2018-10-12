<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI入力</title>
</head>
<body>
<h2>◆◇◆◇ ＢＭＩ判定 ◇◆◇◆</h2>
<form action="/sukkiri01/HealthCheck" method="post">
名前 : <input type="text" name="name"><br>
<br>
身長 : <input type="text" name="height"> (cm)<br>
<br>
体重 : <input type="text" name="weight"> (kg)<br>
<br>
<input type="submit" value=" 診断！ ">
</form>
</body>
</html>