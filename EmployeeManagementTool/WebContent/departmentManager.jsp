<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList" %>
	<%@page import="dao.DepartmentDAO" %>
	<%@page import="beans.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報：一覧</title>
</head>
<% ArrayList<Department>Departments = new ArrayList<Department>();
Departments = new DepartmentDAO().findAll(); %>
<body>
	<h2>部署情報一覧</h2>
	<table border="1">
		<tr>
			<th>部署ID</th>
			<th>部署名</th>
			<th></th>
			<th></th>
		</tr>
		<% for(Department dpt : Departments){ %>
		<tr>
			<td><%=dpt.getDptId() %></td>
			<td><%=dpt.getDptName() %></td>
			<td><input type="button"
				onclick="location.href='/EmployeeManagementTool/employEdit.jsp'"
				value=" 編集 "></td>
			<td><input type="button"
				onclick="location.href='/EmployeeManagementTool/employDeleteCheck.jsp'"
				value=" 削除 "></td>
		</tr>
		<% } %>

	</table>
	<br>
	<input type="button"
		onclick="location.href='/EmployeeManagementTool/departEdit.jsp'"
		value=" 新規追加 ">
	<br>
	<br>
	<a href="/EmployeeManagementTool/Manager.jsp">ＴＯＰページへ戻る</a>
</body>
</html>