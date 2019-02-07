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
    
    <title>User_OrderList</title>
    
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

<link rel="stylesheet" type="text/css" href="/FlowerShop1.0/frontmanager/css/pagination.css" media="all">
<script type="text/javascript" src="/FlowerShop1.0/frontmanager/js/jquery.pagination.js"></script>
<script>
    
    
    function handlePaginationClick(new_page_index, pagination_container) {
    
   	 $("#Form").attr("action", "<%=path%>/OrderFrontServlet?method=orderState&orderstate=${orderstate}&currentPage=" + (new_page_index+1));
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
<!-- slide -->

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
					<!---//pop-up-box---->
				<!-- <div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<form id="Form" action="GoodsFrontServlet?method=fuzzy_find_goods" method="post">
						    <input type="hidden" class="textBox length-long" placeholder="输入订单名称..." name="search"/>
						   
						    </form>
						</div>
						<p>按enter以查询</p>
					</div>				
				</div> -->
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






<!---->
<!--//body-->
 <link rel="stylesheet" href="frontmanager/css/tasp.css" /> 
 <link href="frontmanager/css/orderconfirm.css" rel="stylesheet" />
<div id="page" >

		<div id="content" class="grid-c">

			<div id="address" class="address" style="margin-top: 20px;"
				data-spm="2">
				

				<!-- <h3 class="dib">订单信息</h3> -->
				<table cellspacing="0" cellpadding="0" class="order-table">

					<thead>
						<tr>
							<th class="s-title">宝贝名称
								<hr /></th>
							<th class="s-price">单价(元)
								<hr /></th>
							<th class="s-amount">数量
								<hr /></th>
							<th class="s-agio">优惠方式(元)
								<hr /></th>
							<th class="s-total">小计(元)
								<hr /></th>
						</tr>
					</thead>



					

				<c:forEach items="${list.dataList}" var="list" >
					<tbody>
						<tr class="first">
							<td colspan="5"></td>
						</tr>
						<tr class="shop blue-line">

							<td colspan="2" class="promo">
								<div>
							<input type="hidden" value="${list.order_id}" id="oid">
								<a>订单编号：${list.orderserial}</a>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a>订单时间：${list.ordertime}</a>
								</div>
								</td>
						</tr>
						
						
						<c:forEach items="${list.order_goodlist}" var="list1">  
						<tr class="item">			
							<td class="s-title"><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list1.g_id}" class="J_MakePoint">
								 <img src="/FlowerShop1.0/img/${list1.g_imgurl}" class="itempic">
									<span class="title J_MakePoint"
									data-point-url="http://log.mmstat.com/buy.1.5"></span>
							</a>
                             
								<div class="props">
								<a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list1.g_id}">${list1.g_name}</a>
								</div></td>
							<td class="s-price"><span class='price '> <em
									class="style-normal-small-black J_ItemPrice">${list1.g_price}</em> </span> <input
								type="hidden" name="costprice" value="630.00"
								class="J_CostPrice" /></td>
							<td class="s-amount" data-point-url=""><input type="hidden"
								class="J_Quantity" value="1"
								name="19614514619_31175333266_35612993875_quantity" />${list1. goods_num}</td>
							<td class="s-agio">
								<div class="J_Promotion promotion" data-point-url="">无优惠</div></td>
							<td class="s-total"><span class='price '> <em
									class="style-normal-bold-red J_ItemTotal ">${list1.g_price * list1. goods_num}</em> </span></td>
						</tr>


                      </c:forEach>

						<tr class="shop-total blue-line">
							<td colspan="5">合计 <span class='price g_price '> <span>&yen;</span><em
									class="style-middle-bold-red J_ShopTotal">${list.order_total_price}</em> </span> <input
								type="hidden" name="1704508670:2|creditcard" value="false" /> <input
								type="hidden" id="J_IsLadderGroup" name="isLadderGroup"
								value="false" />
								
								
								<c:if test="${list.orderstate==1}">
								<a href="${pageContext.request.contextPath }/OrderFrontServlet?method=userupdateorder&oid=${list.order_id}&orderstate=2&state=${list.orderstate}">确认支付 </a></c:if>
								<c:if test="${list.orderstate==2}">
								<a href="${pageContext.request.contextPath }/OrderFrontServlet?method=User_order_detail&oid=${list.order_id}&state=${list.orderstate}">查看物流信息</a></c:if>
								<c:if test="${list.orderstate==3}">
								<a href="${pageContext.request.contextPath }/OrderFrontServlet?method=userupdateorder&oid=${list.order_id}&orderstate=4&state=${list.orderstate}">确认收货 </a></c:if>
								<c:if test="${list.orderstate==4}">
								<a href="${pageContext.request.contextPath }/ReviewFrontServlet?method=review&oid=${list.order_id}">去评价 </a></c:if>
								<c:if test="${list.orderstate==5}">
								<a>已完成 </a></c:if>
								</td>
						</tr>
					</tbody>
					</c:forEach>

						
					<!-- end -->




					<tfoot>	
					
					</tfoot>
					
				</table>
				<div id="News-Pagination" class="pagination" style="float: right;padding-top: 10px;padding-right: 60px;"></div><!--用来展示分页列表-->
			</div>


		</div>

		
	</div>





<!---->



<!--footer-->

<!--//footer-->
  </body>
</html>
