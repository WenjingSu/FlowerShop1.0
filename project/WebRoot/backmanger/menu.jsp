<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>左侧导航</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
  
  <body style="background:#313131">
<div class="menu-list">
 <%-- <a href="${pageContext.request.contextPath}/CountServlet?method=CountOrder" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">起始页</a> --%>
 <ul>
  <li class="menu-list-title">
   <span>订单管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="${pageContext.request.contextPath}/OrderBackServlet?method=pageOrderList&orderstate=0" title="订单列表" target="mainCont">订单列表</a></li>
    <li><a href="${pageContext.request.contextPath}/OrderBackServlet?method=sales" title="订单统计表" target="mainCont">订单统计表</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>商品类别管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
  
    <li><a href="${pageContext.request.contextPath}/GoodsTypeServlet?method=goodstypeFindAll" title="商品分类" target="mainCont">商品分类</a></li>
    
   </ul>
  </li>
  <li class="menu-list-title">
   <span>商品管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="${pageContext.request.contextPath}/GoodsServlet?method=product_list" title="商品列表" target="mainCont">商品列表</a></li>
  
    <li><a href="${pageContext.request.contextPath}/GoodsServlet?method=recycle_bin" title="商品回收站" target="mainCont">商品回收站</a></li>
    <li><a href="${pageContext.request.contextPath}/FlowerTypeServlet?method=flowertype_list" title="花材列表" target="mainCont">花材列表</a></li>
    <li><a href="${pageContext.request.contextPath}/FlowerNumServlet?method=flowernum_list" title="枝数列表" target="mainCont">枝数列表</a></li>
    <li><a href="${pageContext.request.contextPath}/FlowerUseServlet?method=flowerUse_list" title="用途列表" target="mainCont">用途列表</a></li>
   
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>用户管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="${pageContext.request.contextPath}/UsersServlet?method=user_list" title="用户列表" target="mainCont">用户列表</a></li>
   
    <!--  <li><a href="${pageContext.request.contextPath}/backmanger/user_rank.jsp" title="会员等级" target="mainCont">会员等级</a></li>
   <li><a href="${pageContext.request.contextPath}/backmanger/user_message.jsp" title="会员留言" target="mainCont">会员留言</a></li>
   --> </ul>
  </li>
  
  <li class="menu-list-title">
   <span>管理员管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="${pageContext.request.contextPath}/ManagerServlet?method=managerFindAll" target="mainCont" title="站点基本设置" target="mainCont">站点管理员</a></li>
   </ul>
  </li>
  
 
     
 </ul>
</div>

</body>
</html>
