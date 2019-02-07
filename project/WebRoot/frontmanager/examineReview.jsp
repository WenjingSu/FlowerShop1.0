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
    
    <title>Review</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="frontmanager/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="frontmanager/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="frontmanager/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="frontmanager/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="frontmanager/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="frontmanager/js/simpleCart.min.js"> </script>
<link rel="stylesheet" href="/FlowerShop1.0/frontmanager/css/tasp.css" />
<link href="/FlowerShop1.0/frontmanager/css/orderconfirm.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css" href="/FlowerShop1.0/frontmanager/css/pagination.css" media="all">
<script type="text/javascript" src="/FlowerShop1.0/frontmanager/js/jquery.pagination.js"></script>
<script>
    
    
    function handlePaginationClick(new_page_index, pagination_container) {
    
   	 $("#Form").attr("action", "<%=path%>/ReviewFrontServlet?method=findReviewBygid&g_id=${g_id}&currentPage=" + (new_page_index+1));
   	 $("#Form").submit();
     return false;
	}
	$(function(){
		$("#News-Pagination").pagination(${list.totalRecord}, {
        items_per_page:${list.pageSize}, // 每页显示多少条记录
        current_page:${list.currentPage} - 1, // 当前显示第几页数据
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
 <!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-md-4 world">
					<ul >
					<div id="login2" class="w3l_login">
				    
					<c:if test="${!empty user}">
					<c:if test="${!empty user.u_img}">
					<a href="${pageContext.request.contextPath}/UserFrontServlet?method=userPageSkip"
					target="_parent">
					<img src="/FlowerShop1.0/userimg/${user.u_img}"
					height="50px" width="50px" /></a>
					</c:if>
					
					<c:if test="${empty user.u_img}">
					<a href="${pageContext.request.contextPath}/UserFrontServlet?method=userPageSkip"
					target="_parent">
					<img src="/FlowerShop1.0/userimg/origin.png"
					height="50px" width="50px" /></a> 
					</c:if>	
					</c:if>
					<c:if test="${empty user}">
					<img src="/FlowerShop1.0/userimg/origin.png"
					height="50px" width="50px" /> 
					</c:if>		
					 
			        </div>
					</ul>
				</div>
				
				<div class="col-sm-4 logo">
					<a href="${pageContext.request.contextPath}/FirstServlet?method=goodstypeFindAll">
							<img src="images/logo.png" alt="">
							</a>	
				</div>
		
			<div class="col-sm-4 header-left">		
					<p class="log"><a href="${pageContext.request.contextPath}/UserFrontServlet?method=userLoginSkip"  >登录</a>
						<span>or</span><a  href="${pageContext.request.contextPath}/UserFrontServlet?method=userRegisterSkip"  >注册</a></p>
					<div class="cart box_1">
					<script type="text/javascript">
					 $(function gotoCartSkip(){
					    $("#gotoCart").click(function(){
					        $.post("CartServlet",{method:"gotoCartSkip"},function(data){
					        var num = data;
					        if (num==1) {
						    window.location.href="${pageContext.request.contextPath}/CartServlet?method=gotoCart";
					        } 
					        else if(num==2){
						    alert("您尚未登录，请先登录");
					        }
				          });
					    });
					 }); 
					 </script>   
						
						<a id="gotoCart" href="javascript:void(0)">
						
						<h3> <div class="total">
							<!-- <span class="simpleCart_total"></span></div> -->
							<img src="images/cart.png" height="20px" width="20px" alt=""/>
							
						</h3>
						</a>
						<p><a class="simpleCart_empty">我的购物车</a></p> 

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>157 3510 4157</span>
				</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="${pageContext.request.contextPath}/FirstServlet?method=goodstypeFindAll">主页</a></li>
					   <!-- ======================================================================================== -->
				      <li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=0">全部订单</a>
				      </li>
<!-- ======================================================================================== -->
				    <li class="grid"><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=1">待付款</a>
				    </li>
				<li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=2">待发货</a></li>				
				<li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=3">待收货</a></li>
				<li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=4">待评价</a></li>	
			  </ul> 
			</div>
				<div class="col-md-2 search">		
			<!-- <a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a> -->
		</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
					<link href="frontmanager/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="frontmanager/js/jquery.magnific-popup.js" type="text/javascript"></script> 
					
				<form id="Form" action="" method="post">
				<!-- <input type="hidden" class="textBox length-long" placeholder="输入订单名称..." name="search"/>		    -->
				</form>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
	<!---->		
		</div>
	</div>
</div>
<!--//header-->


<!--body-->
	<div id="page">
		<div id="content" class="grid-c">
			<div id="address" class="address" style="margin-top: 20px;"
				data-spm="2">
				
				<table class="order-table">
					
					<thead>
						<tr>
						    
							<th class="s-title" >用户
								<hr />
							</th>
							<th class="s-price" colspan="1">评论类型
								<hr />
							</th>
							<th class="s-price" colspan="3">评论内容
								<hr />
							</th>
							<th class="s-price">评论时间
								<hr/>
							</th>
						</tr>
					</thead>



<!-- begin -->
					<tbody>
						<tr class="first">
							
						</tr>
						<tr class="shop blue-line">

							<td colspan="2" class="promo">
								<div>	
								</div>
							</td>
						</tr>
						
						<c:forEach items="${list.dataList}" var="list" varStatus="id">
						<tr class="item">
							<td class="s-title">
							<img src="/FlowerShop1.0/userimg/${list.u_img}"
							class="itempic"><span class="title J_MakePoint">${list.u_name}*</span>
							

								<div class="props">
									<span> </span>
								</div></td>
							<!-- <td class="s-price" > -->
							<c:if test="${list.state==1}">
							<td>好评</td>
							</c:if>
							<c:if test="${list.state==2}">
							<td>中评</td>
							</c:if>
							<c:if test="${list.state==3}">
							<td>差评</td>
							</c:if>
							<td>${list.content}</td>
							<td></td><td></td>
							<td>${list.review_time1}</td>
							

						</tr>
						
</c:forEach>

						
					</tbody>
<!--//body-->				
					
				
					
					

				</table>
<div id="News-Pagination" class="pagination" style="float: right;padding-top: 10px;padding-right: 60px;"></div><!--用来展示分页列表-->
			</div>


		</div>

		<div id="footer"></div>
	</div>

</body>
</html>
