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
    
    <title>商品图片</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="backmanger/style/adminStyle.css" type="text/css"></link></head>
  
  <body>
    <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>编辑商品图片</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/GoodsServlet?method=product_list" class="pt-link-btn">产品列表</a></span>
  </div>
  <form action="${pageContext.request.contextPath}/GoodsServlet?method=edit_images&id=${good.g_id}" method="post" enctype="multipart/form-data">
  <input type="hidden" name="g_id" value="${good.g_id}">
  <table class="list-style">
   <tr>
    <td style="text-align:right;width:15%;">产品名称：</td>
    <td>${good.g_name}</td>
   </tr>
   
   <tr>
    <td style="text-align:right;">产品缩图片：</td>
    
    <td>
   		<label for="image" class="labelBtn2">产品主图(最多选择1张)</label><br/>
   		<input type="file"  name="good_imgurl"/>
    </td>
   </tr>
   
  <tr>
    <td style="text-align:right;">产品主图：</td>
    <td>
    <label for="images" class="labelBtn2">产品分图(最多选择5张)</label><br/>
     <input type="file"  name="imageurl"/>
     <input type="file"  name="imageurl"/>
     <input type="file"  name="imageurl"/>
     <input type="file"  name="imageurl"/>
     <input type="file"  name="imageurl"/>
    </td>
  </tr>
   
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" value="提交商品" class="tdBtn"/></td>
   </tr>
  </table>
  </form>
 </div>
  </body>
</html>
