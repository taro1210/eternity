<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String result = request.getParameter("result");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員情報：<%=result %>失敗</title>
</head>
<style>
      h2{
        color:red;
      }
    </style>
<body>
<h2><%=result %>に失敗しました</h2>
<br>
<input type="button" onclick="location.href='/EmployeeManagementTool/departManager.jsp'"value=" 一覧に戻る ">
</body>
</html>