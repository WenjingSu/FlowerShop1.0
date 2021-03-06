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
    
    <title>用户列表</title>
    
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
   	    $("#Form").attr("action", "<%=path%>/UsersServlet?method=user_list&currentPage=" + (new_page_index+1));
   	    $("#Form").submit();
        return false;
	    }
	    $(function(){
	    $("#News-Pagination").pagination(${users.totalRecord}, {
        items_per_page:${users.pageSize}, // 每页显示多少条记录
        current_page:${users.currentPage} - 1, // 当前显示第几页数据
        num_display_entries:2, // 分页显示的条目数
        next_text:"下一页",
        prev_text:"上一页",
        num_edge_entries:2, // 连接分页主体，显示的条目数
        callback:handlePaginationClick
	    });
        });

   </script>
  
  </head>
  
  <body>
    <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>用户列表</em></span>
  </div>
  <div class="operate">
    <form id="Form" action="UsersServlet?method=user_list" method="post">
    <input type="text" class="textBox length-long" placeholder="请输入用户名" name="search"/>
    <input type="submit" value="查询" class="tdBtn" >
   </form>
  </div>
   <table class="list-style Interlaced">
   <tr>
     <th>用户编号</th>
     <th>用户名</th>
     <th>性别</th>
     <th>居住地</th>
     <th>生日</th>
     <th>电话号码</th>
     <th>个性签名</th> 
     <th>查看详情</th>
    </tr>
    
    <c:forEach items="${users.dataList}" var="u"  varStatus="id">
    <tr>
    <td class="center"><input type="checkbox"/>&nbsp;<span class="middle"><i>${id.index+1}</i></span></td>
    <td class="center">${u.u_name}</td>
    <c:if test="${u.u_sex eq 1}">
    <td class="center">男</td>
    </c:if>
    <c:if test="${u.u_sex eq 0}">
    <td class="center">女</td>
    </c:if>
    <td class="center">${u.u_residence}</td>
    <td class="center">${u.u_birthday_date}</td>
    <td class="center">${u.u_phone}</td>
    <td class="center">${u.u_info}</td>
    <td class="center">
     <a href="<%=path%>/UsersServlet?method=userfindbyuId1&u_id=${u.u_id}">查看</a>
    </td>
    
    </tr>
    
    
    
    
    </c:forEach>
    
   
   
  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	   <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="批量删除" class="btnStyle"/>
	  </div>
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
