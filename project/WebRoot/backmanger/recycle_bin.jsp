<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>商品回收站</title>
    
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
		function selectAll() {
		$("input[name='all']").each(function() {
			if ($(this).prop("checked") == true) {
				$("input[name='one']").prop('checked', true);
				return;
			} else {
				$("input[name='one']").prop('checked', false);
				return;
			}
		});
	}
	</script>
	<script type="text/javascript">
	   function f(){
	   var addid="";
       $(".arr td").each(function(){
       var check=$(this).find("#one");
       if (check.is(":checked")) {
		   addid += "," +check.val(); 
	   }
       });
       window.location.href = "<%=path%>/GoodsServlet?method=Batchadd&addid=" + addid;
 	 }
	 
	 </script>
  
  </head>
  
  <body>
  <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>商品回收站</em></span>
  </div>
  <table class="list-style">
   <tr>
       <th>ID编号</th>
       <th>产品</th>
       <th>名称</th>
       <th>市场价</th>
       <th>原价</th>
       <th>进价</th>
       <th>库存</th>
       <th>操作</th>
   </tr>
   <c:forEach items="${recycled_goods}" var="list" varStatus="id">
   <tr class="arr">
    <td class="center">
     
     <input type="checkbox"  name="one" id="one" value="${list.g_id}"/>
     <i>${id.index+1}</i>
     
    </td>
    <td class="center pic-area"><img src="img/${list.g_imgurl}" class="thumbnail"/></td>
    <td class="center">
       ${list.g_name}
    </td>
    
    <td class="center">
       <span>
       <i>￥</i>
       <em>${list.goods_price}</em>
       </span>
       </td>
       
       <td class="center">
       <span>
       <i>￥</i>
       <em>${list.original_price}</em>
       </span>
       </td>
       
       <td class="center">
       <span>
       <i>￥</i>
       <em>${list.purchasing_price}</em>
       </span>
       </td>
       
       <td class="center">
       <span>
       <em>${list.amount}</em>
       <i>件</i>
       </span>
       </td>
       
      
       
    <td class="center">
     <a href="${pageContext.request.contextPath}/GoodsServlet?method=examine_product&g_id=${list.g_id}" title="查看详细信息" ><img src="images/icon_view.gif"/></a>
     <a href="${pageContext.request.contextPath}/GoodsServlet?method=del_and_recycle&id=${list.g_id}&id1=1" title="恢复" ><img src="images/icon_edit.gif"/></a>
    </td>
   </tr>
   </c:forEach>
  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del" name="all" onclick="selectAll()"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="批量恢复" class="btnStyle" id="btnadd" onclick="f()" />
	  </div>
	  <!-- turn page -->
	 <!--  <div class="turnPage center fr">
	   <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>
	  </div> -->
  </div>
 </div>
  </body>
</html>
