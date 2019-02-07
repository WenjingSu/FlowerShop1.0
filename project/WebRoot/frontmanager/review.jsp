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
					
				<!-- <form id="Form" action="" method="post">
				<input type="hidden" class="textBox length-long" placeholder="输入订单名称..." name="search"/>		   
				</form> -->
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

<!-- <script type="text/javascript">							
		$(function(){
		//验证
		alert("haha");
		var g_id=$("input[id^='g_id']").val();
		for(i=0;i<2;i++)
		{
		alert(g_id[i]);
		}
		
		
		var u_id=$("#u_id").val();
		var o_id=$("input[id^='o_id']").val();
		//alert(u_id);
		//alert(o_id);
		
		var state = $("input[name='state']:checked").val();
		var content=$("textarea[id^='content']").val();
		alert(state);
		alert(content);
        if(state!=""&&state!=null&&content!=""&&content!=null)
        {
        alert(content);
        alert("选中的radio的值是：" + state);
       
		$("input[id^='btn1']").click(function(){
		  $.post("ReviewFrontServlet",{method:"reviewAdd",g_id:g_id,u_id:u_id,content:content,state:state,o_id:o_id},function(data){
				var num = data;
				if (num==1) {
					alert("评论成功");
					  window.location.href="${pageContext.request.contextPath}/OrderFrontServlet?method=orderState&orderstate=4";
					
				} else{
					alert("评论失败,请重试");
					
				}
			});
		
		});
		}
		else
		{
		
		}
			
});						
</script> -->






<!--body-->
	<div id="page">
		<div id="content" class="grid-c">
			<div id="address" class="address" style="margin-top: 20px;"
				data-spm="2">
				<!-- <h3 class="dib">订单评论</h3> -->
				<table class="order-table">
					
					<thead>
						<tr>
							<th class="s-title" >宝贝名称
								<hr />
							</th>
							<th class="s-price" colspan="3">评论
								<hr />
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
						
						<c:forEach items="${list}" var="list">
						<tr class="item">
							<td class="s-title"><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list.g_id}"> <img
									src="/FlowerShop1.0/img/${list.g_imgurl}"
									class="itempic"><span class="title J_MakePoint">${list.g_name}</span>
							</a>

								<div class="props">
									<span> </span>
								</div></td>
							<form action="${pageContext.request.contextPath}/ReviewFrontServlet?method=reviewAdd" method="post">
							<input type ="hidden" name="g_id" value="${list.g_id}">
							<input type ="hidden" name="u_id" value="${user.u_id}">
							<input type= "hidden" name="o_id" value="${list.order_id}">
							<td class="s-price" >
							<input name="state${list.g_id}" type="radio" value="1"/>好评<br/>
							<input name="state${list.g_id}" type="radio" value="2"/>中评<br/>
							<input name="state${list.g_id}" type="radio" value="3"/>差评
							</td>
							<td class="s-amount" data-point-url="">
							<textarea id="content" name="content${list.g_id}" style="width: 300px;height:80px;color:#0F0F0F;"></textarea></td>
							<td class="s-total"><span class='price '> 
							<em class="style-normal-bold-red J_ItemTotal ">			
							</td>
							

						</tr>
						
</c:forEach>

						
					</tbody>
<!--//body-->				
					
				
					
					

				</table>
			</div>

<input type="submit" class="btn1" style="outline:none;border:none;background:rgb(82,208,196);padding:8px 0;color:#fff;width:10%;font-size:1em;text-transform:uppercase;margin-left:850px" value="发表评论" /></em> </span>
		</div>
</form>
		<div id="footer"></div>
	</div>

</body>
</html>
