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
    
    <title>OrderDetail</title>
    
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
				    <li class="grid"><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=1">代付款</a>
				    </li>
				<li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=2">待发货</a></li>				
				<li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=3">待收货</a></li>
				<li><a  href="${pageContext.request.contextPath }/OrderFrontServlet?method=orderState&orderstate=4">待评价</a></li>	
			  </ul> 
			</div>
				<!-- <div class="col-md-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div> -->
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
						    <input type="text" class="textBox length-long" placeholder="输入产品名称..." name="search"/>
						   
						    </form>
						</div>
						<p>按enter以查询</p>
					</div>				
				</div> -->
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
				<form name="addrForm" id="addrForm" action="#">
					<h3>
						收货地址 <span class="manage-address"> </span>
					</h3>
					<span class="marker-tip">寄送至</span> <label for="addrId_674944241"
						class="user-address"> ${add.address} <br>(${
						add.consignee_name}收) <em>${add.consignee_tel}</em> </label> <br> <br>
					<br>
				</form>

				<h3 class="dib">订单信息</h3>
				<table cellspacing="0" cellpadding="0" class="order-table"
					id="J_OrderTable" summary="统一下单订单信息区域">

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



					<!-- begin -->
					<tbody data-spm="3" class="J_Shop" data-tbcbid="0"
						data-outorderid="47285539868" data-isb2c="false" data-postMode="2"
						data-sellerid="1704508670">
						<tr class="first">
							<td colspan="5"></td>
						</tr>
						<tr class="shop blue-line">

							<td colspan="2" class="promo">
								<div>
									<ul class="scrolling-promo-hint J_ScrollingPromoHint">
									</ul>
								</div>
							</td>
						</tr>

						<c:forEach items="${list}" var="list">
							<tr class="item"
								data-lineid="19614514619:31175333266:35612993875"
								data-pointRate="0">
								<td class="s-title"><a target="_blank"
									title=""
									class="J_MakePoint"
									data-point-url="http://log.mmstat.com/buy.1.5"> <img src="img/${list.g_imgurl}"
										class="itempic"><span class="title J_MakePoint">${list.g_name}</span> </a>

									<div class="props">
										<span> </span>
									</div>
								</td>
								<td class="s-price"><span class='price '> <em
										class="style-normal-small-black J_ItemPrice">${list.g_price}</em> </span> 
								</td>
								<td class="s-amount" data-point-url="">${list.goods_num}</td>
								<td class="s-agio">
									无优惠
								</td>
								<td class="s-total"><span class='price '> <em
										class="style-normal-bold-red J_ItemTotal ">${list.goods_num*list.g_price}</em> </span>
								</td>
							</tr>
						</c:forEach>

						<tr class="shop-total blue-line">
							<td colspan="5">合计 <span class='price g_price '> <span>&yen;</span><em
									class="style-middle-bold-red J_ShopTotal">${add.order_total_price}</em> 
									</span> <input type="hidden" name="1704508670:2|creditcard"
								value="false" /> <input type="hidden" id="J_IsLadderGroup"
								name="isLadderGroup" value="false" />
							</td>
						</tr>
					</tbody>
					<!-- end -->




					<tfoot>
						<tr>
							<td colspan="5">

								<div class="order-go" data-spm="4">
									<div class="J_AddressConfirm address-confirm">
										<div class="kd-popup pop-back" style="margin-bottom: 40px;">
											<div class="box">
												<div class="bd">
													<div class="point-in">

														<em class="t">实付款：</em> <span class='price g_price '>
															<span>&yen;</span><em class="style-large-bold-red"
															id="J_ActualFee">${add.order_total_price}</em> </span><br/>
															
													</div>
										
												</div>
											</div>
										</div>
									</div>




								</div>
							</td>
						</tr>
						
					</tfoot>
				</table>
			</div>


		</div>

		
	</div>





<!---->



<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-md-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus  dui. </li>
						<li>orci, ornareidquet</li>
						<li> ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
	</div>
</div>

<!--//footer-->
  </body>
</html>
