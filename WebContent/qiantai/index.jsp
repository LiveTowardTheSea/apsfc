<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/qiantai/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-ZW私房菜</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/dingcanall.css" rel="stylesheet" type="text/css" />
<link href="css/newslist_time2.css" rel="stylesheet" type="text/css" />	
<link href="css/dingcanche.css" rel="stylesheet" type="text/css" />	
<link href="css/dingcanweekmenu.css" rel="stylesheet" type="text/css" />
<style>
#content { min-height: inherit; }
.demo {
	margin-left: calc(100vw - 100%);
	text-align: center; overflow: hidden;
}
</style>								
</head>
<body style='background: transparent'>
<div class="demo">
	<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle" page="top.jsp" />
			</td>
		</tr>
		<tr>
			<td height="30"></td>
		</tr>
		<tr>
			<td align="left" valign="top">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="59%" align="left" valign="top">
						<div id='pdv_3606' class='pdv_class' title='' style='width:648px; top: 0px; left: 0px; z-index: 12'>
								<div id='spdv_3606' class='pdv_content' style='overflow: visible; width: 100%;'>
									<div class="pdv_border" style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
										<div style="padding: 0px">
											<div id="dingcanall2">

												<div style="margin-top: 0px; padding: px;">

													<div id="mm_01" class="dingcanall_connow">
														<table>
															<tr>
															<c:set var="count" value="0" />
															<c:forEach items="${menusPage.list}" var="item">
																<c:if test="${count%2 == 0}">
																	<tr>
																</c:if>
																<td width="50%" style="margin-top:10px;">
																	<div>
																		<table>
																			<tr>
																				<td rowspan="5" class="bookPic">
																					<a href="${pageContext.request.contextPath}/IndexServlet?method=findMenuById&id=${item.id}" class="newslist_time2"><img src="${pageContext.request.contextPath}/${item.imgpath}" style="border:1px solid #300;" width="150px" height="140px"/></a>
																				</td>
																				<td><span>菜名:</span></td>
																				<td><a href="${pageContext.request.contextPath}/IndexServlet?method=findMenuById&id=${item.id}" class="newslist_time2"><span><strong>${item.name}</strong></span></a></td>
																			</tr>
																			<tr>
																				<td><span>市场价格:</span></td>
																				<td><span>${item.price}</span></td>
																			</tr>
																			<tr>
																				<td><span>会员价格:</span></td>
																				<td><span><strong style="color: red;">${item.price1}</strong></span></td>
																			</tr>
																			<tr>
																				<td><span>配料:</span></td>
																				<td><span>${item.burden}</span></td>
																			</tr>
																			<tr>
																				<td><span>菜品类型:</span></td>
																				<td><span>${item.typename}</span></td>
																			</tr>
																			<tr>
																				<td colspan="2" style="height: 40px;">
																					<a href="${pageContext.request.contextPath}/IndexServlet?method=addItem&id=${item.id}&currentPage=${menusPage.currentPage}">加入餐车</a></td>
																				<td></td>
																			</tr>
																		</table>
																	</div>
																</td>
																<c:if test="${count%2 != 0}">
																	</tr>
																</c:if>
																<c:set var="count" value="${count+1}" />
															</c:forEach>
															<c:if test="${not empty menusPage.list}">
															<tr>
																<td class="line_table" align="center" colspan="11" height="20" >
																	<span class="left_bt2">第${menusPage.currentPage}页
																		&nbsp;&nbsp;共${menusPage.totalPage}页 </span>&nbsp;&nbsp; 
																	<c:choose>
																		<c:when test="${menusPage.currentPage eq 1 }">
																			<span style="font-size: 12px; color: grey">[首页]</span>
																		</c:when>
																		<c:otherwise>
																			<a href="${pageContext.request.contextPath }/IndexServlet?method=allInfo&currentPage=1">[首页]</a>
																		</c:otherwise>
																	</c:choose> 
																	<c:choose>
																		<c:when test="${menusPage.currentPage eq menusPage.totalPage }">
																			<span style="font-size: 12px; color: grey">[尾页]</span>
																		</c:when>
																		<c:otherwise>
																			<a href="${pageContext.request.contextPath }/IndexServlet?method=allInfo&currentPage=${menusPage.totalPage}">[尾页]</a>
																		</c:otherwise>
																	</c:choose> &nbsp;&nbsp; 
																	<c:choose>
																		<c:when test="${menusPage.hasPrePage eq false }">
																			<span style="font-size: 12px; color: grey">[上一页]</span>
																		</c:when>
																		<c:otherwise>
																			<a href="${pageContext.request.contextPath }/IndexServlet?method=allInfo&currentPage=${menusPage.currentPage-1}">[上一页]</a>
																		</c:otherwise>
																	</c:choose>
																	 <c:choose>
																		<c:when test="${menusPage.hasNextPage eq false }">
																			<span style="font-size: 12px; color: grey">[下一页]</span>
																		</c:when>
																		<c:otherwise>
																			<a href="${pageContext.request.contextPath }/IndexServlet?method=allInfo&currentPage=${menusPage.currentPage+1}">[下一页]</a>
																		</c:otherwise>
																	</c:choose>
																</td>
															</tr>
															</c:if>
														</table>
													</div>
												</div>
											</div>
										</div>
										<div id="dingcanall_bottom_left">&nbsp;</div>
										<div id="dingcanall_bottom_right">&nbsp;</div>
										<input type="hidden" name="picw" id="picw" value="150" /> 
										<input type="hidden" name="pich" id="pich" value="140" /> 
										<input type="hidden" name="fittype" id="fittype" value="auto" />
									</div>
								</div>
							</div>
							</td>
						<td width="41%" align="right" valign="top">
						<table width="243" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td></td>
								</tr>
								<tr>
									<td valign="top"><div id='pdv_' class='pdv_class'
											title='网站公告'
											style='width: 243px; top: 0px; left: 0px; z-index: 3'>
											<div id='spdv_3603' class='pdv_content' style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border" style="border: 0px; height: 100%; padding: 0; margin: 0; background: url(base/border/640/images/left.jpg) repeat-y">
													<div style="height: 100%; background: url(images/right.jpg) right repeat-y">
														<div style="height: 43px; background: url(images/bg.jpg) 0px 0px no-repeat">
															<div style="float: left; font: bold 16px/43px 'Microsoft YaHei', 'SimSun', Arial, Sans-Serif; text-align: left; padding-left: 50px; color: #feab43;">
																餐厅公告
															</div>
															<div style="float: right; width: 60px; height: 43px; text-align: right; background: url(images/bg.jpg) -840px 0px no-repeat">
																<a href="${pageContext.request.contextPath}/IndexServlet?method=findAllNotice" style="font: 12px/43px simsun; color: #505050; margin-right: 12px; display: inline">更多&gt;&gt;</a>
															</div>
														</div>
														<div style="margin: 0px 3px; padding: 10px;" align="left">
															<ul class="newslist_time2">
																<c:forEach items="${noticeList}" var="item" begin="0" end="1">
																<li class="newslist_time2">
																	<div class="time">${fn:substring(item.times, 0, 10)}</div>
																	<a href="${pageContext.request.contextPath}/IndexServlet?method=findNoticeById&id=${item.id}" class="newslist_time2">${item.name}</a>
																</li>
																</c:forEach>
															</ul>
														</div>
													</div>
												</div>
												<div style="margin-top: -10px; height: 10px; line-height: 10px; background: url(images/bg.jpg) 0px -220px no-repeat">&nbsp;</div>
												<div style="float: right; margin-top: -10px; width: 10px; height: 10px; line-height: 10px; background: url(images/bg.jpg) -890px -220px no-repeat">&nbsp;</div>
											</div>
										</div>
										</td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
										<div id='pdv_3614' class='pdv_class' title='我的餐车' style='width: 243px; top: 0px; left: 0px; z-index: 2'>
											<div id='spdv_3614' class='pdv_content' style='overflow: visible; width: 100%;'>
												<div class="pdv_border" style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div style="height: 25px; margin: 1px; display: none; background:;">
														<div style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">
															我的餐车
														</div>
														<div style="float: right; margin-right: 10px; display: none">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<div id="dingcanche">
															<div id="dingcanche2">
																<div id="dingcanche_top">
																	<div id="dingcanche_top_left">我的餐车</div>
																	<div id="dingcanche_top_right">&nbsp;</div>
																</div>
																<div id="dcinfo" style="margin: 0px 3px 1px 3px;"></div>
																<table width="100%" border="0" cellspacing="0" style="background: #fef0d3;">
																	<tr>
																		<td align="center">菜单名称</td>
																		<td align="center">单价</td>
																		<td align="center">数量</td>
																		<td align="center"></td>
																	</tr>
																	<c:if test="${empty carList}">
																		<tr>
																			<td align="center" colspan="3" rowspan="2" height="50px" valign="middle"><span style="font-size:14px">餐车中暂无内容</span></td>
																		</tr>
																	</c:if>
																	<c:set var="pricesum" value="0" />
																	<c:set var="countsum" value="0" />
																	<c:forEach items="${carList}" var="item">
																	<tr>
																		<td align="center">${item.menuname}</td>
																		<td align="center">${item.price}</td>
																		<td align="center">${item.count}</td>
																		<td align="center">
																			<a href="${pageContext.request.contextPath}/IndexServlet?method=removeItem&id=${item.menuid}&url=index&currentPage=${menusPage.currentPage}">取消</a>
																		</td>
																	</tr>
																	<c:set var="pricesum" value="${pricesum + item.price * item.count}" />
																	<c:set var="countsum" value="${countsum + item.count}" />
																	</c:forEach>
																</table>
																<c:if test="${not empty carList}">
																<div style="height: 24px; margin: 5px 3px 1px 3px;">
																	<div style="float: left; line-height: 24px; padding-left: 25px;">小&nbsp;&nbsp;计：</div>
																	<div style="float: right; line-height: 24px; padding-right: 15px;">
																		<font id="allnums" style="color: #ff0000;">${countsum}</font>份
																	</div>
																	<div style="float: right; line-height: 24px; padding-right: 30px;">
																		<font id="cpprice" style="color: #ff0000;">${pricesum}</font>元
																	</div>
																</div>
																
																<div style="height: 30px; margin: 5px 3px 1px 3px;">
																	<table width="100%" border="0" cellspacing="0">
																		<tr>
																			<td align="center" width="40%"></td>
																			<td align="center" width="40%">
																				<a href="${pageContext.request.contextPath}/IndexServlet?method=carToOrder">
																					<img src="images/canche_submit.gif" border="0" />
																				</a>
																			</td>
																			<td align="center" width="40%">
																				<a href="${pageContext.request.contextPath}/IndexServlet?method=removeAll&url=index&currentPage=${menusPage.currentPage}">
																					<img src="images/quxiao2.gif" border="0" />
																				</a>
																			</td>
																		</tr>
																	</table>
																</div>
																</c:if>
															</div>
														</div>
													</div>
													<div id="dingcanche_bottom_left">&nbsp;</div>
													<div id="dingcanche_bottom_right">&nbsp;</div>
													<input type="hidden" name="modnums_b" id="modnums_b" value="" />
													<script>
														$("div.cpline_d:even").addClass("cpline_s");
													</script>
												</div>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
									<div id='pdv_3613' class='pdv_class' title='本周菜单' style='width: 243px; top: 0px; left: 0px; z-index: 5'>
											<div id='spdv_3613' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border" style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div style="height: 25px; margin: 1px; display: none; background:;">
														<div style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:red">
															本周菜单
														</div>
														<div style="float: right; margin-right: 10px; display: none">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<div id="dingcanweekmenu">
															<div id="dingcanweekmenu2">
																<div id="dingcanweekmenu_top">
																	<div id="dingcanweekmenu_top_left">销售排行榜</div>
																	<div id="dingcanweekmenu_top_right">&nbsp;</div>
																</div>
																<div style="padding: px;">
																	<div class="dingcanweekmenuinfo" align="left">
																	<ul>
																	<c:forEach items="${rankingList}" var="item" begin="0" end="4">
																		<li class="newslist_time2">
																			<div class="time">已销售${item.sum}次</div>
																			<a href="${pageContext.request.contextPath}/IndexServlet?method=findMenuById&id=${item.menuid}" class="newslist_time2">${item.menuname}</a>
																		</li>
																	</c:forEach>
																	</ul>
																	</div>
																</div>
															</div>
														</div>
														<div id="dingcanweekmenu_bottom_left"></div>
                    									<div id="dingcanweekmenu_bottom_right">&nbsp;</div>
													</div>
												</div>
											</div>
									</div>
									</td>
								</tr>
							</table>
							</td>
					</tr>
				</table>
				</td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>

	</table>
</div>
</body>
</html>
