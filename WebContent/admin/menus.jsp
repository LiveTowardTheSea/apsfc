<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<!-- <link href="images/common.css" rel="stylesheet" type="text/css" /> -->
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">菜单信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">菜单名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">展示图片</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">原料</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">类型</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">说明</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价格</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员单价</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
							</tr>
							<c:forEach items="${menusPage.list}" var="item">
								<tr>
									<td class="line_table" align="center">
										<a href="${pageContext.request.contextPath }/MenusServlet?method=findById&id=${item.id}&currentPage=${menusPage.currentPage}">${item.name}</a>
									</td>
									<td class="line_table" align="center">
										<a href="${pageContext.request.contextPath }/${item.imgpath }">
											<img src="${pageContext.request.contextPath }/${item.imgpath }" width="30" height="30">
										</a>
									</td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.burden }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.typename }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.brief }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.price }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.sums }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.price1 }</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${item.sums1 }</span></td>
									<td class="line_table" align="center">
										<a href="${pageContext.request.contextPath }/MenusServlet?method=findById&id=${item.id}&currentPage=${menusPage.currentPage}" >修改</a>
									</td>
									<td class="line_table" align="center">
										<a href="${pageContext.request.contextPath }/MenusServlet?method=delete&id=${item.id}&currentPage=${menusPage.currentPage}" >删除</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
									<span class="left_bt2">第${menusPage.currentPage }页
										&nbsp;&nbsp;共${menusPage.totalPage}页 </span>&nbsp;&nbsp; 
									<c:choose>
										<c:when test="${menusPage.currentPage eq 1 }">
											<span style="font-size: 12px; color: grey">[首页]</span>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath }/MenusServlet?method=findByPage&currentPage=1">[首页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${menusPage.currentPage eq menusPage.totalPage }">
											<span style="font-size: 12px; color: grey">[尾页]</span>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath }/MenusServlet?method=findByPage&currentPage=${menusPage.totalPage}">[尾页]</a>
										</c:otherwise>
									</c:choose> &nbsp;&nbsp; 
									<c:choose>
										<c:when test="${menusPage.hasPrePage eq false }">
											<span style="font-size: 12px; color: grey">[上一页]</span>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath }/MenusServlet?method=findByPage&currentPage=${menusPage.currentPage-1}">[上一页]</a>
										</c:otherwise>
									</c:choose>
									 <c:choose>
										<c:when test="${menusPage.hasNextPage eq false }">
											<span style="font-size: 12px; color: grey">[下一页]</span>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath }/MenusServlet?method=findByPage&currentPage=${menusPage.currentPage+1}">[下一页]</a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
