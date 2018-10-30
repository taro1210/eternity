<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList" %>
<%@page import="dao.DepartmentDAO" %>
<%@page import="beans.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部署情報：編集・追加</title>
</head>
<%String count =request.getParameter("count"); %>
<%	//追加条件を格納するフィールドを生成(初期値はは半透明表示 or 未選択)
	String sendDptId  = "0";
	String dptNamemsg = "placeholder=\"部署名\"";
	%>
<% if(!(count.equals("0"))){
	DepartmentDAO dao = new DepartmentDAO();
	Department dpt = dao.findById(Integer.parseInt(count));
	sendDptId  = dpt.getDptId();
	dptNamemsg = "value="+dpt.getDptName();
}%>
<body>
	<h2>部署情報追加・編集</h2>

	<form action="./CommitDepartment" method="post">
		<input type="hidden" name="id" value="<%=count %>">
		<input type="hidden" name="dptId" value="<%=sendDptId %>">
		<p>
		部署名：<input type="text" name="dptName" size="15" <%=dptNamemsg %>>
		</p>
		<br>
		<input type="submit" value=" 登録 " />
	</form>
	<br>
	<form action="/EmployeeManagementTool/departManager.jsp">
	<input type="submit" value=" キャンセル " />
	</form>
</body>
</html>