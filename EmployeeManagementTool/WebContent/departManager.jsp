<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList" %>
	<%@page import="dao.DepartmentDAO" %>
	<%@page import="beans.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部署情報：一覧</title>
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
		<% int count = 0; %>
		<% for(Department dpt : Departments){ %>
		<% count++; %>
		<tr>
			<td><%=dpt.getDptId() %></td>
			<td><%=dpt.getDptName() %></td>
			<td>
			<form action="/EmployeeManagementTool/departEdit.jsp">
			<input type="hidden" name="count" value="<%=Integer.toString(dpt.getId()) %>">
			<input type="submit" value=" 編集 ">
			</form>
			</td>
			<td>
			<form action="/EmployeeManagementTool/departDeleteCheck.jsp">
			<input type="hidden" name="count" value="<%=Integer.toString(dpt.getId()) %>">
			<input type="submit" value=" 削除 ">
			</form>
			</td>
		</tr>
		<% } %>

	</table>
	<br>
	<form action="/EmployeeManagementTool/departEdit.jsp">
			<input type="hidden" name="count" value="<%="0" %>">
			<input type="submit" value=" 新規追加 ">
	</form>
	<br>
	<br>
	<a href="/EmployeeManagementTool/Manager.jsp">ＴＯＰページへ戻る</a>
</body>
</html>