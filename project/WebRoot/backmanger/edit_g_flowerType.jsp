<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑商品所用花材</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="backmanger/style/adminStyle.css" type="text/css"></link></head>
  <script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript">
  $(function(){
      var floType_ids="${floType_ids}";
      
      var a=$("input[id^='flowerTypes']").val(${floType_ids});
  });
  
 
  
  </script>
  
  
  <body>
    <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>编辑商品所用花材</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/GoodsServlet?method=product_list" class="pt-link-btn">返回</a></span>
  </div>
  <form action="${pageContext.request.contextPath}/GoodsServlet?method=upload_flowerType" method="post">
  <input type="hidden" value="${g_id}" id="${g_id}" name="g_id">
  <table class="list-style">
 
  <tr>
    <td class="center">包含花材：</td>
    <td>
    <c:forEach items="${flowerTypes}" var="flowerTypes" varStatus="flowerTypesStatus">
    <input type="checkbox" id="flowerTypes" name="flowerTypes" value="${flowerTypes.floType_id}" >${flowerTypes.floType_name} <br>
    </c:forEach>
    </td>
  </tr>
  
  
  
  <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" id="btn1" value="提交"  class="tdBtn"/></td>
  </tr>
 </table>
  </form>
 
 </div>
  </body>
</html>
