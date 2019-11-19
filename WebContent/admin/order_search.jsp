<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script src="js/date.js" type="text/javascript"></script>
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		if(!verifyNotNull(document.form1.userid.value) && !verifyNotNull(document.form1.menuname.value) && !verifyNotNull(document.form1.date.value)) {
			alert("查询条件不能为空！");
			return false;
		}
	}
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>

<body>


	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">

				<div align="center" width="120" >
					<form action="${pageContext.request.contextPath}/OrdersServlet?method=search" name="form1"
						method="post" onSubmit="return verifyInfo()">
						<table id="table1" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tbody style="margin: 0; padding: 0">
								<tr>
									<td class="line_table" align="right" width="44%">
										<span class="left_bt2">按用户ID查询</span>
									</td>
									<td class="line_table" align="left" width="56%"> 
										<input type="text" name="userid" size="20" value="${ordersSearch.userid}"> 
									</td>
								</tr>
								<tr>
									<td class="line_table" align="right" width="44%">
										<span class="left_bt2">按菜品名称查询</span>
									</td>
									<td class="line_table" align="left" width="56%">
										<input type="text" name="menuname" size="20" value="${ordersSearch.menuname}"> 
									</td>
								</tr>
								<tr>
									<td class="line_table" align="right" width="44%">
										<span class="left_bt2">按销售日期查询</span>
									</td>
									<td class="line_table" align="left" width="56%">
										<input type="text" name="date" size="20" readOnly onClick="setDay(this);" value="${ordersSearch.date}">
									</td>
								</tr>
								<tr>
									<td class="line_table" align="center" colspan="2">
										<a href="${pageContext.request.contextPath}/OrdersServlet?method=search"><input type=button value="重置" style="width:50px;font-size:13px"></a>
										<input type="submit" value="查询" style="width:50px;font-size:13px">
									</td>
								</tr>
						</table>
					</form>
				</div>



				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="12"><span
									class="left_bt2">销售订单查询结果信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">用户ID</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">联系方式</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">菜品名称</span></td>
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
						<c:if test="${empty ordersPage.list}">
							<tr>
								<td class="line_table" align="center" colspan="12">
									<p class="left_bt2" style="font-size:14px">未查询到任何信息</p>
								</td>
							</tr>
						</c:if>
						<c:forEach items="${ordersPage.list}" var="item">
							<tr>
								<td class="line_table" align="center"><span
									class="left_txt">${item.userid}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.realname}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.phone}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.address}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.menuname}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.menusum}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.price}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.totalprice}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${item.times}</span></td>
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
						<c:if test="${not empty ordersPage.list}">
						<tr>
							<td class="line_table" align="center" colspan="12" height="20">
							<span class="left_bt2">第${ordersPage.currentPage}页
									&nbsp;&nbsp;共${ordersPage.totalPage}页
							</span>&nbsp;&nbsp; 
							<c:choose>
								<c:when test="${ordersPage.currentPage eq 1}">
									<span style="font-size: 12px; color: grey">[首页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/OrdersServlet?method=search&currentPage=1&userid=${ordersSearch.userid}&menuname=${ordersSearch.menuname}&date=${ordersSearch.date}">[首页]</a>
								</c:otherwise>
							</c:choose> 
							<c:choose>
								<c:when test="${ordersPage.currentPage eq ordersPage.totalPage }">
									<span style="font-size: 12px; color: grey">[尾页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/OrdersServlet?method=search&currentPage=${ordersPage.totalPage}&userid=${ordersSearch.userid}&menuname=${ordersSearch.menuname}&date=${ordersSearch.date}">[尾页]</a>
								</c:otherwise>
							</c:choose> &nbsp;&nbsp; 
							<c:choose>
								<c:when test="${ordersPage.hasPrePage eq false }">
									<span style="font-size: 12px; color: grey">[上一页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/OrdersServlet?method=search&currentPage=${ordersPage.currentPage-1}&userid=${ordersSearch.userid}&menuname=${ordersSearch.menuname}&date=${ordersSearch.date}">[上一页]</a>
								</c:otherwise>
							</c:choose>
							 <c:choose>
								<c:when test="${ordersPage.hasNextPage eq false }">
									<span style="font-size: 12px; color: grey">[下一页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/OrdersServlet?method=search&currentPage=${ordersPage.currentPage+1}&userid=${ordersSearch.userid}&menuname=${ordersSearch.menuname}&date=${ordersSearch.date}">[下一页]</a>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						</c:if>
					</table>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>
