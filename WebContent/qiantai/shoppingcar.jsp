<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/qiantai/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-我的订餐车</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
</head>
<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top">
				<jsp:include flush="fasle" page="top.jsp" />
			</td>
		</tr>
		<tr>
			<td height="50px"></td>
		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left" valign="top">
							<div align="center">
								<table id="table2" class="line_table"
									style="width: 700px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="4">
												<span class="left_bt2">我的订餐信息列表</span>
											</td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_bt2">菜品名称</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">单价</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">数量</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">&nbsp;&nbsp;</span></td>
										</tr>
										<c:choose>
										<c:when test="${empty carList}">
											<tr>
												<td class="line_table" align="center" colspan="4">
													<p class="left_bt2" style="font-size:13px">餐车中暂无内容</p>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
										<c:set var="pricesum" value="0" />
										<c:set var="countsum" value="0" />
										<c:forEach items="${carList}" var="item">
											<tr>
												<td class="line_table" align="center" width="40%">
													<span class="left_txt">${item.menuname}</span>
												</td>
												<td class="line_table" align="center" width="20%">
													<span class="left_txt">${item.price}</span>
												</td>
												<td class="line_table" align="center" width="20%">
													<span class="left_txt">${item.count}</span>
												</td>
												<td class="line_table" align="center" width="20%">
													<a href="${pageContext.request.contextPath}/IndexServlet?method=removeItem&id=${item.menuid}">取消</a>
												</td>
											</tr>
											<c:set var="pricesum" value="${pricesum + item.price * item.count}" />
											<c:set var="countsum" value="${countsum + item.count}" />
										</c:forEach>
										<tr>
											<td class="line_table" align="center" colspan="4">
												<span class="left_bt2">小&nbsp;&nbsp;计：</span>&nbsp; 
												<span style="color: #ff0000;">${pricesum}</span>&nbsp;&nbsp; 
												<span class="left_bt2">元</span>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span class="left_bt2">共：</span>&nbsp; 
												<span style="color: #ff0000;">${countsum}</span>&nbsp; 
												<span class="left_bt2">份</span>
											</td>
										</tr>

										<tr>
											<td class="line_table" align="center" colspan="4" align="center">
												<a href="${pageContext.request.contextPath}/IndexServlet?method=carToOrder"><img src="images/canche_submit.gif" border="0" /></a>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="${pageContext.request.contextPath}/IndexServlet?method=removeAll"><img src="images/quxiao2.gif" border="0" /></a>
											</td>
										</tr>
										</c:otherwise>
										</c:choose>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="10px">&nbsp;</td>
		</tr>
		<tr>
			<td height="50px" align="center" valign="middle">
			 <jsp:include flush="fasle" page="copyright.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>
