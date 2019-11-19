<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<% 
		String currentPage = request.getParameter("currentPage"); 
		if (currentPage == null) {
			currentPage = "1";
		}
	%>
	<script>window.location.href="${pageContext.request.contextPath}/IndexServlet?method=allInfo&currentPage=<%=currentPage%>";</script>
</body>
</html>
