<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'main.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
  
  <script type="text/javascript" src="js/public.js"></script>
  <script type="text/javascript" src="js/Particleground.js"></script>
  <script type="text/javascript" src="js/public.js"></script>
  
  <link rel="stylesheet" href="backmanger/style/adminStyle.css" type="text/css"></link>
  </head>
  
  <body>
    <div class="wrap start-page">
<!--  <h1><i class="home-icon"></i>FlowerPlus后台管理中心</h1> -->
 <dl>
  <dt>订单统计信息</dt>
  <dd>
   <ul>
    <li>
     <span>订单总量：</span>
     <span>30</span>
    </li>
    <li>
     <span>未付款订单量：</span>
     <span>2</span>
    </li>
    <li>
     <span>待发货：</span>
     <span>10</span>
    </li>
    <li>
     <span>待收货：</span>
     <span>1</span>
    </li>
    <li>
     <span>订单完成：</span>
     <span>17</span>
    </li>
   </ul>
  </dd>
 </dl>
 
 
 <dl>
  <dt>会员统计信息</dt>
  <dd>
   <ul>
    <li>
     <span>会员数量：</span>
     <span>10</span>
    </li>
  <!--   <li>
     <span>白金会员：</span>
     <span>432</span>
    </li>
 -->    <!-- <li>
     <span>商户会员：</span>
     <span>128</span>
    </li> -->
   </ul>
  </dd>
 </dl>
 
 <!-- <dl>
  <dt>访问统计</dt>
  <dd>
   <ul>
    <li>
     <span>今日访问：</span>
     <span>1356</span>
    </li>
    <li>
     <span>当前在线人数：</span>
     <span>98</span>
    </li>
    <li>
     <span>最新留言：</span>
     <span>1</span>
    </li>
   </ul>
  </dd>
 </dl> -->
 
 <dl>
  <dt>系统信息</dt>
  <dd>
   <ul>
    <li>
     <span>服务器操作系统：</span>
     <span>JDK1.6</span>
    </li>
    <li>
     <span>服务器：</span>
     <span>Tomcat7.0</span>
    </li>
    <li>
     <span>MySQL 版本：</span>
     <span>5.5.20</span>
    </li>
    <li>
     <span>安全模式：</span>
     <span>是</span>
    </li>
   
    <li>
     <span>时区设置：</span>
     <span>China/Beijing</span>
    </li>
    <li>
     <span>编码：</span>
     <span>UTF-8</span>
    </li>
   </ul>
  </dd>
 </dl>
</div>
  </body>
</html>
