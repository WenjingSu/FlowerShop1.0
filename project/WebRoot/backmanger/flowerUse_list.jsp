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
    
    <title>用途列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href=" backmanger/style/pagination.css">
<script type="text/javascript" src="backmanger/js/jquery.pagination.js"></script>
<link rel="stylesheet" href="backmanger/style/adminStyle.css" type="text/css"></link>
<script type="text/javascript" src="backmanger/js/public.js"></script>
	
	

  <script type="text/javascript">
        
       
        
        function handlePaginationClick(new_page_index, pagination_container) {
   	    $("#Form").attr("action", "<%=path%>/FlowerUseServlet?method=flowerUse_list&currentPage=" + (new_page_index+1));
   	    $("#Form").submit();
        return false;
	    }
	    
	    $(function(){
	    $("#News-Pagination").pagination(${flowerUses.totalRecord}, {
        items_per_page:${flowerUses.pageSize}, // 每页显示多少条记录
        current_page:${flowerUses.currentPage} - 1, // 当前显示第几页数据
        num_display_entries:2, // 分页显示的条目数
        next_text:"下一页",
        prev_text:"上一页",
        num_edge_entries:2, // 连接分页主体，显示的条目数
        callback:handlePaginationClick
	    });
        });
        
        $(function(){
        $("a[id^='floUseDel']").click(function(){
            ensure = window.confirm("您真的确定要删除吗？\n\n请确认！");
            if (ensure==true){ 
                var floUse_id = $(this).attr("name");
                $.post("FlowerUseServlet",{method:"updateFlowerUseDel",floUse_id:floUse_id},function(data){
				var num = data;
				if (num==1) {
					alert("删除成功");	
					window.location.href="${pageContext.request.contextPath}/FlowerUseServlet?method=flowerUse_list";		
				} else {
					alert("删除失败");
					window.location.href="${pageContext.request.contextPath}/FlowerUseServlet?method=flowerUse_list";
				};
				});
				};
			});	
        });	
        
        
        
        
        
   </script>
  
  </head>
  
  <body>
    <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>用途列表</em></span>
     <span class="modular fr"><a href="${pageContext.request.contextPath}/backmanger/add_flowerUse.jsp" class="pt-link-btn">+添加新用途</a></span>
  </div>
  <div class="operate">
    <form id="Form" action="FlowerUseServlet?method=flowerUse_list" method="post">
    <input type="text" class="textBox length-long" placeholder="请输入用途名" name="search"/>
    <input type="submit" value="查询" class="tdBtn" >
   </form>
  </div>
   <table class="list-style Interlaced">
   <tr>
     <th>编号</th>
     <th>用途名</th> 
     <th>删除</th>
    </tr>
    
    <c:forEach items="${flowerUses.dataList}" var="fuse"  varStatus="id">
    <tr>
    <td class="center"><input type="checkbox"/>&nbsp;<span class="middle"><i>${id.index+1}</i></span></td>
    <td class="center">${fuse.floUse_name}</td>
 
    
    <td class="center">
     <a id="floUseDel" name="${fuse.floUse_id}" class="inline-block" title="删除"><img src="images/icon_drop.gif"/></a>
     <a id="floUseRedact" href="${pageContext.request.contextPath}/FlowerUseServlet?method=redact_FlowerUse_skip&floUse_id=${fuse.floUse_id}" class="inline-block" title="编辑"><img src="images/icon_edit.gif"/></a>
    </td>
    </tr>
    
    
    
    
    </c:forEach>
    
   
   
  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	   
	  <!-- turn page -->
	  <div class="turnPage center fr">
	   <!--  <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>-->
	   <div id="News-Pagination" class="pagination" style="float: right;padding-top: 10px;" ></div><!--用来展示分页列表-->
	  </div>
	  
  </div>
 </div>
  </body>
</html>
