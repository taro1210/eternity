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
		<% int count = 0; %>
		<% for(Employee emp : employees){ %>
		<% count++; %>
		<tr>
			<td><%=emp.getEmpId() %></td>
			<td><%=emp.getEmpName() %></td>
			<td><input type="button"
				onclick="location.href='/EmployeeManagementTool/employEdit.jsp?count=<%=count %>'"
				value=" 編集 "></td>
			<td><input type="button"
				onclick="location.href='/EmployeeManagementTool/employDeleteCheck.jsp?count=<%=count %>'"
				value=" 削除 "></td>
		</tr>
		<% } %>

	</table>
	<br>
	<input type="button"
		onclick="location.href='/EmployeeManagementTool/employEdit.jsp?count=<%="0" %>'"
		value=" 新規追加 ">
	<br>
	<input type="button"
		onclick="location.href='/EmployeeManagementTool/employSearch.jsp'"
		value=" 検索 ">
	<br>
	<input type="button"
		onclick="location.href='/EmployeeManagementTool/editCsv.jsp'"
		value=" 保存(CSV) ">
	<br>
	<br>
	<a href="/EmployeeManagementTool/Manager.jsp">ＴＯＰページへ戻る</a>
</body>
</html>