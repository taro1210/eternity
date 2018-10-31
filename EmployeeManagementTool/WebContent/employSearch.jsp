<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList" %>
<%@page import="dao.EmployeeDAO" %>
<%@page import="beans.Employee" %>
<%@page import="dao.DepartmentDAO" %>
<%@page import="beans.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員情報：検索</title>
</head>
	<% ArrayList<Department>Departments = new ArrayList<Department>();
	 Departments = new DepartmentDAO().findAll(); %>
<body>
<form action="/EmployeeManagementTool/searchResult.jsp" method="post">
	<h2>社員情報検索</h2>
	<p>
		部署：<select name="dptId">
			<option value="">未指定</option>
		<% for(Department department: Departments){ %>

			<option value="<%= department.getDptId() %>"><%=department.getDptName() %></option>
		<%} %>
		</select>
	</p>
	<p>
		社員ＩＤ：<input pattern=".{0,20}" title="20文字以内で入力してください" placeholder="IDを入力して下さい" name="empId">
	</p>
	<p>
		社員名：<input pattern=".{0,30}" title="30文字以内で入力してください" placeholder="名前を入力して下さい" name="empName">
	</p>
	<br>
	<input type="submit" value=" 検索 ">
</form>
<br>
<input type="button" onclick="location.href='/EmployeeManagementTool/employManager.jsp'"value=" 一覧に戻る ">
</body>
</html>