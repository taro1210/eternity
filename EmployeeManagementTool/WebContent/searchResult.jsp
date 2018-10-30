<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.Employee"%>
<%@page import="dao.EmployeeDAO" %>
<%@page import="dao.DepartmentDAO" %>
<%@page import="beans.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報：検索結果</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<% String searchDptId = request.getParameter("dptId");
   String searchEmpId = request.getParameter("empId");
   String searchEmpName = request.getParameter("empName"); %>
   <%System.out.println(searchDptId); %>
   <%System.out.println(searchEmpId); %>
   <%System.out.println(searchEmpName); %>
<% ArrayList<Employee>employees = new ArrayList<Employee>();
   employees = new EmployeeDAO().search(searchDptId, searchEmpId, searchEmpName); %>
<% ArrayList<Department>Departments = new ArrayList<Department>();
	 Departments = new DepartmentDAO().findAll(); %>
<body>
<h2>検索結果を表示します</h2>
<table border="1">
		<tr>
			<th>社員ID</th>
			<th>名前</th>
			<th>年齢</th>
			<th>性別</th>
			<th>写真ID</th>
			<th>郵便番号</th>
			<th>都道府県</th>
			<th>市区町</th>
			<th>部署名</th>
			<th>入社日</th>
			<th>退社日</th>
		</tr>
<% for(Employee emp : employees){ %>
		<tr>
			<td><%= emp.getEmpId() %></td>
			<td><%= emp.getEmpName() %></td>
			<td><%= emp.getEmpAge() %></td>
			<td><%= emp.getEmpGender() %></td>
			<td><%= emp.getPhotoId() %></td>
			<td><%= emp.getZip() %></td>
			<td><%= emp.getPref() %></td>
			<td><%= emp.getCity() %></td>
			<% for(Department dpt : Departments){
				if(emp.getDptId().equals(dpt.getDptId())){%>
			<td><%= dpt.getDptName() %></td>
			<% 		break;
				}%>
			<% } %>
			<td><%= emp.getEntryDate() %></td>
			<td><%= emp.getResignDate() %></td>
		</tr>
<%} %>
</table>
<br>
	<br>
	<form action="/EmployeeManagementTool/employEdit.jsp">
			<input type="hidden" name="count" value="<%="0" %>">
			<input type="submit" value=" 新規追加 ">
	</form>
	<br>
	<form action="/EmployeeManagementTool/employSearch.jsp">
			<input type="submit" value=" 検索 ">
	</form>
	<br>
<input type="button" onclick="location.href='/EmployeeManagementTool/employManager.jsp'"value=" 一覧に戻る ">
</body>
</html>