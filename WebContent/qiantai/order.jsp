<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/qiantai/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>我的订单</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/skin.css" rel="stylesheet" type="text/css" /> 
<script src="js/date.js" type="text/javascript"></script>
</head>

<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50px"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="left" valign="top">

							<div align="center" width="120">
								<form action="${pageContext.request.contextPath}/IndexServlet?method=findOrders" name="form1" method="post">
									<table id="table1" class="line_table" style="width: 500px; margin: 0; padding: 0" cellSpacing="0" cellPadding="0">
										<tbody style="margin: 0; padding: 0">
											<tr>
												<td class="line_table" align="right" width="40%">
													<span class="left_bt2">按菜品名称查询</span>
												</td>
												<td class="line_table" align="left" width="60%">
													<input type="text" name="menuname" size="20" value="${search.menuname}">
													<input type="submit" value="查询">
												</td>
											<tr>
												<td class="line_table" align="right" width="40%">
													<span class="left_bt2">按销售日期查询</span>
												</td>
												<td class="line_table" align="left" width="60%">
													<input type="text" name="date" size="20" readOnly onClick="setDay(this);" value="${search.date}"> 
													<input type="submit" value="查询">
												</td>
											</tr>
											<tr>
												<td class="line_table" align="center" colspan="3">
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders">我的所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp; 
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders&delivery=0">未已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders&delivery=1">已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
											</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" valign="top" height="20px"></td>
					</tr>
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="9">
												<span class="left_bt2">订单查询结果信息列表</span>
											</td>
										</tr>
										<tr>
											<td class="line_table" align="center"><span
												class="left_bt2">菜品名称</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">真实姓名</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购电话</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">派送地址</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购数量</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">单价(元)</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">合计(元)</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购时间</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">是否派送</span></td>
										</tr>
								<c:choose>
									<c:when test="${not empty ordersPage.list}">
										<c:forEach items="${ordersPage.list}" var="item">
										<tr>
											<td class="line_table" align="center">
												<span class="left_txt">${item.menuname}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.realname}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.phone}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.address}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.menusum}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.price}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.totalprice}</span>
											</td>
											<td class="line_table" align="center">
												<span class="left_txt">${item.times}</span>
											</td>
											<td class="line_table" align="center">
											<c:choose>
												<c:when test="${item.delivery eq 1}">
													<span class="left_txt">是</span>
												</c:when>
												<c:otherwise>
													<span class="left_txt">否</span>
												</c:otherwise>
											</c:choose>
											</td>
										</tr>
										</c:forEach>
										<tr>
											<td class="line_table" align="center" colspan="10" height="20">
											<span class="left_bt2">第${ordersPage.currentPage}页
													&nbsp;&nbsp;共${ordersPage.totalPage}页
											</span>&nbsp;&nbsp; 
											<c:choose>
												<c:when test="${ordersPage.currentPage eq 1}">
													<span style="font-size: 12px; color: grey">[首页]</span>
												</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders&currentPage=1&menuname=${search.menuname}&date=${search.date}&delivery=${search.delivery}">[首页]</a>
												</c:otherwise>
											</c:choose> 
											<c:choose>
												<c:when test="${ordersPage.currentPage eq ordersPage.totalPage}">
													<span style="font-size: 12px; color: grey">[尾页]</span>
												</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders&currentPage=${ordersPage.totalPage}&menuname=${search.menuname}&date=${search.date}&delivery=${search.delivery}">[尾页]</a>
												</c:otherwise>
											</c:choose> &nbsp;&nbsp; 
											<c:choose>
												<c:when test="${ordersPage.hasPrePage eq false }">
													<span style="font-size: 12px; color: grey">[上一页]</span>
												</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders&currentPage=${ordersPage.currentPage-1}&menuname=${search.menuname}&date=${search.date}&delivery=${search.delivery}">[上一页]</a>
												</c:otherwise>
											</c:choose>
											 <c:choose>
												<c:when test="${ordersPage.hasNextPage eq false }">
													<span style="font-size: 12px; color: grey">[下一页]</span>
												</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath}/IndexServlet?method=findOrders&currentPage=${ordersPage.currentPage+1}&menuname=${search.menuname}&date=${search.date}&delivery=${search.delivery}">[下一页]</a>
												</c:otherwise>
											</c:choose>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<td class="line_table" align="center" colspan="9">
											<p class="left_bt2" style="font-size:14px">暂无订单</p>
										</td>
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
			<td height="50px" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
</body>
</html>
