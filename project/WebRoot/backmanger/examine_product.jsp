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
    
    <title>产品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="backmanger/style/adminStyle.css" type="text/css"></link>
  <script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
  
  
  
  </head>  
  
  <body>
    <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>查看商品详情</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/GoodsServlet?method=product_list" class="pt-link-btn">产品列表</a></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/backmanger/edit_product2.jsp" class="pt-link-btn">批量添加</a></span>
  </div>
  

  <table class="list-style">
  <tr>
    <td style="text-align:right;width:15%;">产品名称：</td>
    <td>${good.g_name}</td>
  </tr>
  
  <tr>
    <td style="text-align:right;">产品分类：</td>
    <td>
    ${goodstype.gt_typename}
    </td>
  </tr>
  
   <tr>
    <td style="text-align:right;">鲜花枝数：</td>
    <td>
    ${flowernum.floNum_name}
    </td>
  </tr>
  
  <tr>
    <td style="text-align:right;">进价：</td>
    <td>${good.purchasing_price}<span>元</span></td>
  </tr>
  
  <tr>
    <td style="text-align:right;">原价：</td>
    
    <td>${good.original_price}<span>元</span></td>
 
  </tr>
  
  <tr>
    <td style="text-align:right;">市场价：</td>
    <td>${good.goods_price}<span>元</span></td>
  </tr>
  
  <tr>
    <td style="text-align:right;">产品主图：</td>
    <td><img alt="" src="img/${good.g_imgurl}"></td>
  </tr>
  
   <tr>
    <td style="text-align:right;">产品分图：</td>
   </tr> 
     <tr><td></td><td><img alt="" src="img/${images[1]}"></td></tr>
     <tr><td></td><td><img alt="" src="img/${images[2]}"></td></tr>
     <tr><td></td><td><img alt="" src="img/${images[3]}"></td></tr>
     <tr><td></td><td><img alt="" src="img/${images[4]}"></td></tr>
     <tr><td></td><td><img alt="" src="img/${images[5]}"></td></tr>
    
    <tr>
    <td style="text-align:right;">商品用途：</td>
    </tr>
    
    <c:forEach items="${uses}" var="uses">
    <tr>
    <td></td>
    <td>${uses.floUse_name}</td>
    </tr>
    </c:forEach>
  
  <tr>
    <td style="text-align:right;">所用花材：</td>
    </tr>
    
    <c:forEach items="${types}" var="types">
    <tr>
    <td></td>
    <td>${types.floType_name}</td>
    </tr>
    </c:forEach>
  
  <tr>
    <td style="text-align:right;">库存：</td>
    <td>${good.amount}<span>个</span></td>
  </tr>

  <tr>
    <td style="text-align:right;">产品描述：</td>
    <td>${good.g_info}</td>
  </tr>
   
 </table>

 </div>
  </body>
</html>
