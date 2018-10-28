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
		社員ＩＤ：<input type="text" placeholder="IDを入力して下さい" name="empId">
	</p>
	<p>
		社員名：<input type="text" placeholder="名前を入力して下さい" name="empName">
	</p>
	<br>
	<input type="submit" value=" 検索 ">
</form>
</body>
</html>