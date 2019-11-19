<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/qiantai/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>公告通知</title>
<style type="text/css">    
TABLE.colorTest{     
    border-top: 1px solid #909090;      
    border-left: 1px solid #909090;      
    border-right: 1px solid #909090;      
    border-bottom: 1px solid #909090;      
}     
.colorTest TD {     
    border-top: 1px solid #FFFFFF;      
    border-left: 1px solid #FFFFFF;      
    border-right: 1px solid #EBEAEE;      
    border-bottom: 1px solid #EBEAEE;     
}
</style>
<meta content="" name=keywords />
<meta content="" name=description />
</head> 
<body style='background:transparent'>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  		<jsp:include flush="fasle" page="top.jsp"/>
    </td>
  </tr>
  <tr >
  	<td height="50"></td>
  </tr>
  
  <tr>
    <td align="center" valign="top" height="400">
    <!-- 用于显示公告的表格 -->
    <table class="colorTest" border="1" cellspacing="0"  width="100%">
		<tr>
			<td colspan="3" align="center"><span style="font-size:14px">公告信息列表</span></td>
		</tr>
		<tr>
		  <td align="center" valign="top" width="25%" >
			 <span style="font-size:13px">公告标题</span>
		  </td>
		  <td align="center" valign="middle" >
             <span style="font-size:13px">公告内容</span>
		  </td>
		  <td align="center" valign="middle" width="25%" >
             <span style="font-size:13px">发布时间</span>
		  </td>
		</tr>
		<c:forEach items="${noticeList}" var="item">
		<tr>
		  <td align="center" valign="middle"  >
			 <span style="font-size:13px;">${item.name}</span>
		  </td>
		  <td align="center" valign="middle" >
            <br/><span style=" font-size: 13px;">${item.content}</span><br/>
		  </td>
		  <td align="center" valign="middle" >
             <span style=" font-size: 13px;">${item.times}</span>
		  </td>
		</tr>
		</c:forEach>
		<tr>
		  <td align="center" colspan="3" >
			 <a href="${pageContext.request.contextPath }/IndexServlet?method=allInfo" target="_self">
			 	<span style="font-family: Helvetica, sans-serif;font-size: 16px;">
			   	 	返回
			 	</span>
			 </a>
		  </td>
		</tr>
   </table>
   </td>
  </tr>
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
</table>
</body>
</html>
