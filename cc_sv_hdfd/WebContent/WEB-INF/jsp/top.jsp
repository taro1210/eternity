<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第12章　動的インクルード</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p>上部にヘッダーをインクルード</p>
<h2>インクルード元ページ</h2>
<p>下部にフッターをインクルード</p>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>