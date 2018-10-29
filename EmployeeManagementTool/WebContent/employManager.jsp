<%-- 社員管理のページ。直にJSPに飛ばして良いのか？ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList" %>
	<%@page import="dao.EmployeeDAO" %>
	<%@page import="beans.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報：一覧</title>
</head>
<% ArrayList<Employee>employees = new ArrayList<Employee>();
	employees = new EmployeeDAO().findAll(); %>
<body>

	<h2>社員情報一覧</h2>
	<table border="1">
		<tr>
			<th>社員ＩＤ</th>
			<th>名前</th>
			<th></th>
			<th></th>
		</tr>

		<%-- 各行を送る際区別させるためのカウンター --%>
		<% for(Employee emp : employees){ %>
		<tr>
			<td><%=emp.getEmpId() %></td>
			<td><%=emp.getEmpName() %></td>
			<td>
			<form action="/EmployeeManagementTool/employEdit.jsp">
			<input type="hidden" name="count" value="<%=Integer.toString(emp.getId()) %>">
			<input type="submit" value=" 編集 ">
			</form>
			</td>
			<td>
			<form action="/EmployeeManagementTool/employDeleteCheck.jsp">
			<input type="hidden" name="count" value="<%=Integer.toString(emp.getId()) %>">
			<input type="submit" value=" 削除 ">
			</form>
			</td>
		</tr>
		<% } %>

	</table>
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
	<form action="./SaveCsvEmployee" method="post">
			<input type="submit" value=" 保存(CSV) ">
	</form>
	<br>
	<br>
	<a href="/EmployeeManagementTool/Manager.jsp">ＴＯＰページへ戻る</a>
</body>
</html>