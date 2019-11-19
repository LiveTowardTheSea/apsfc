<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script src="js/date.js" type="text/javascript"></script>
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
					<form action="../OrderServlet" name="form1"
						method="post">
						<table id="table1" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tbody style="margin: 0; padding: 0">

								<tr>
									<td class="line_table" align="right" width="40%"><span
										class="left_bt2">按用户ID查询</span></td>
									<td class="line_table" align="left" width="60%"><input
										type="text" name="userid" size="20"> <input
										type="submit" value="查询"></td>
								</tr>
								<tr>
									<td class="line_table" align="right" width="40%"><span
										class="left_bt2">按菜品名称查询</span></td>
									<td class="line_table" align="left" width="60%"><input
										type="text" name="menuname" size="20"> <input
										type="submit" value="查询"></td>
								<tr>
									<td class="line_table" align="right" width="40%"><span
										class="left_bt2">按销售日期查询</span></td>
									<td class="line_table" align="left" width="60%"><input
										type="text" name="date" size="20" readOnly
										onClick="setDay(this);"> <input type="submit"
										value="查询"></td>
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

							<tr>
								<td class="line_table" align="center"><span
									class="left_txt">4</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">糖醋排骨</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">24.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">24.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">2017-06-20 16:35:40</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">是</span></td>
							</tr>
							
							<tr>
								<td class="line_table" align="center"><span
									class="left_txt">4</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">咸肉菜饭</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">12.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">12.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">2017-06-20 16:35:40</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">是</span></td>
							</tr>

							<tr>
								<td class="line_table" align="center"><span
									class="left_txt">4</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">1</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">水煮鱼</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">3</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">32.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">96.0</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">2017-06-21 13:57:36</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">否</span></td>
							</tr>
					</table>
				</div>

			</td>

		</tr>
	</table>

</body>
</html>
