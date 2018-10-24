<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員情報：検索</title>
</head>
<body>
	<h2>社員情報検索</h2>
	<p>
		部署： <select name="department">
			<option value="">未指定</option>
			<option value="総務">総務部</option>
			<option value="営業">営業部</option>
			<option value="開発">開発部</option>
		</select>
	</p>
	<p>
		社員ＩＤ：<input type="text" placeholder="IDを入力して下さい" name="id">
	</p>
	<p>
		社員名：<input type="text" placeholder="名前を入力して下さい" name="name">
	</p>
	<br>
	<input type="button" onclick="location.href='/EmployeeManagementTool/searchResult.jsp'" value=" 検索 ">
</body>
</html>