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
  <script type="text/javascript">
	$(function () {
		$("#btn1").click(function(){    
   		var g_name = $("#g_name").val();
   		var gt_id = $("#gt_id").val();
		var floNum_id = $("#floNum_id").val();
		var purchasing_price = $("#purchasing_price").val();
		var original_price = $("#original_price").val();
		var goods_price = $("#goods_price").val();
		var amount = $("#amount").val();
		var g_info = $("#g_info").val();
			if (g_name!=""&&g_name!=null
			&&gt_id!=""&&gt_id!=null
			&&floNum_id!=""&&floNum_id!=null
			&&purchasing_price.indexOf(" ")==-1&&purchasing_price!=""&&purchasing_price!=null
			&&original_price.indexOf(" ")==-1&&original_price!=""&&original_price!=null
			&&goods_price.indexOf(" ")==-1&&goods_price!=""&&goods_price!=null
			&&amount.indexOf(" ")==-1&&amount!=""&&amount!=null
			&&g_info!=""&&g_info!=null) {
				$.post("GoodsServlet",{method:"upload_product",g_name:g_name,gt_id:gt_id,floNum_id:floNum_id
				,purchasing_price:purchasing_price,original_price:original_price,
				goods_price:goods_price,amount:amount,g_info:g_info},function(data){
					var num = data;
					if(num==3)
					{
					alert("商品名已存在，请修改");
					}
					if (num==1) {
					    alert("添加成功");
						window.location.href="${pageContext.request.contextPath}/GoodsServlet?method=product_list";
					} else if(num==2){
						alert("添加失败");
					};
				});
			}
			else
			{alert("请完整商品信息");}
		});

		
		
	});
</script>
  
  
  </head>  
  
  <body>
    <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>添加产品</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/GoodsServlet?method=product_list" class="pt-link-btn">产品列表</a></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/backmanger/edit_product1.jsp" class="pt-link-btn">批量添加</a></span>
  </div>
  

  <table class="list-style">
  <tr>
    <td style="text-align:right;width:15%;">产品名称：</td>
    <td><input type="text" id="g_name" class="textBox length-long" name="g_name" value=""/></td>
  </tr>
  
  <tr>
    <td style="text-align:right;">产品分类：</td>
    <td>
     <select class="textBox" id="gt_id" name="gt_id">
 		<c:forEach items="${goodstypes}" var="goodstypes">
 		
 			 <c:forEach items="${goodstypes.children}" var="goodstypes">
 		     <option value="${goodstypes.gt_id}"  name="gt_id">${goodstypes.gt_typename}</option>
 		 </c:forEach>
 		</c:forEach>
     </select>
    </td>
  </tr>
  
   <tr>
    <td style="text-align:right;">鲜花枝数：</td>
    <td>
     <select class="textBox" id="floNum_id" name="floNum_id"  >
 		<c:forEach items="${flowerNums}" var="flowerNums">
 		  <option value="${flowerNums.floNum_id}"  name="floNum_id">${flowerNums.floNum_name}</option>
 		</c:forEach>
 		
     </select>
    </td>
  </tr>
  
  <tr>
    <td style="text-align:right;">进价：</td>
    <td>
     <input type="text" id="purchasing_price" class="textBox length-short" name="purchasing_price" />
     <span>元</span>
    </td>
  </tr>
  
  <tr>
    <td style="text-align:right;">原价：</td>
    <td>
     <input type="text" id="original_price" class="textBox length-short" name="original_price"/>
     <span>元</span>
    </td>
  </tr>
  
  <tr>
    <td style="text-align:right;">市场价：</td>
    <td>
     <input type="text" id="goods_price" class="textBox length-short" name="goods_price"/>
     <span>元</span>
    </td>
  </tr>
  
  <tr>
    <td style="text-align:right;">库存：</td>
    <td>
     <input type="text" id="amount" class="textBox length-short" name="amount"/>
     <span>个</span>
    </td>
  </tr>

  <tr>
    <td style="text-align:right;">产品描述：</td>
    <td><input type="text" id="g_info" class="textBox length-long" name="g_info"/></td>
  </tr>
   
  
   
  <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" value="发布新商品" id="btn1" class="tdBtn"/></td>
  </tr>
 </table>

 </div>
  </body>
</html>
