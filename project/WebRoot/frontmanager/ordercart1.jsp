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
    
    <title>Order</title>
    
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
<link rel="stylesheet" type="text/css" href="/FlowerShop1.0/frontmanager/css/base.css" />
<link rel="stylesheet" type="text/css" href="/FlowerShop1.0/frontmanager/css/checkOut.css" />
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
					<ul>
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
				      <li><a>鲜花种类</a>
				      	<div class="mepanel">
						<div class="row">
						<c:forEach items="${goodsTypes01}" var="goodsTypes">
							<div class="col1">
							
								<div class="h_nav">
								
									<h4>${goodsTypes.gt_typename}</h4>
									
									<ul>
									<c:if test="${!empty goodsTypes.children}">
                                    <c:forEach items="${goodsTypes.children}" var="children">
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=find_second_type&g_id=${children.gt_id}">${children.gt_typename}</a></li>
									</c:forEach>
									</c:if>
									</ul>	
								</div>	
													
							</div>
							</c:forEach>	
						  </div>
						  
						</div>
					</li>
<!-- ======================================================================================== -->
				    <li class="grid"><a>商品导购</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>鲜花用途</h4>
									<ul>
									<c:forEach items="${flowerUses}" var="flowerUses"> 
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByUse&floUse_id=${flowerUses.floUse_id}">${flowerUses.floUse_name}</a></li>
									</c:forEach>	
										
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>热门花材</h4>
									<ul>
										<c:forEach items="${flowerTypes}" var="flowerTypes"> 
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByType&floType_id=${flowerTypes.floType_id}">${flowerTypes.floType_name}</a></li>
									    </c:forEach>
										
									
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>价格范围</h4>
									<ul>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=100&floPriceMax=200">100-200</a></li>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=200&floPriceMax=300">200-300</a></li>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=300&floPriceMax=600">300-600</a></li>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=600&floPriceMax=20000">600+</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<c:if test="${!empty user}">
					<li><a  href="${pageContext.request.contextPath}/UserFrontServlet?method=userorderlist">我的花礼</a></li>	
				</c:if>	
				<c:if test="${empty user}">
					<li><a>我的花礼</a></li>	
				</c:if>				
				<li><a class="color6" href="contact.html">联系我们</a></li>
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
				
				<!-- <div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<form id="Form" action="GoodsFrontServlet?method=fuzzy_find_goods" method="post">
						    <input type="text" class="textBox length-long" placeholder="输入产品名称..." name="search"/>
						   
						    </form>
						</div>
						<p>按enter以查询</p>
					</div>				
				</div>  -->
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

<!--body  -->


	<!--收货地址body部分开始-->
	<div class="border_top_cart">
		<script type="text/javascript">
			var checkoutConfig = {
				addressMatch : 'common',
				addressMatchVarName : 'data',
				hasPresales : false,
				hasBigTv : false,
				hasAir : false,
				hasScales : false,
				hasGiftcard : false,
				totalPrice : 244.00,
				postage : 10,//运费
				postFree : true,//活动是否免邮了
				bcPrice : 150,//计算界值
				activityDiscountMoney : 0.00,//活动优惠
				showCouponBox : 0,
				invoice : {
					NA : "0",
					personal : "1",
					company : "2",
					electronic : "4"
				}
			};
			var miniCartDisable = true;
		</script>
		<div class="container">
			<div class="checkout-box">

				<div class="checkout-box-bd">
					<!-- 地址状态 0：默认选择；1：新增地址；2：修改地址 -->
					<input type="hidden" name="Checkout[addressState]" id="addrState"
						value="0">
					<!-- 收货地址 -->
					<div class="xm-box">
						<div class="box-hd ">
							<h2 class="title">收货地址</h2>
							<!---->
						</div>
						<div class="box-bd">
							<div class="clearfix xm-address-list" id="checkoutAddrList">
								<c:forEach items="${list}" var="list">

									<dl class="item">
										<dt>
											<strong class="itemConsignee">${list.consignee_name}</strong> 
											<span class="itemTag tag">${list.add_memo}</span>
										</dt>
										<dd>
											<p class="tel itemTel">联系电话：${list.consignee_tel}</p>
											<p class="itemRegion">收货地址：${list.address}</p>
											<p class="itemRegion">邮政编码：${list.postcode}</p>
											<input type="hidden" id="add_id" name="add_id" value="${list.add_id}"> 

											<span class="edit-btn" id="deladdress">删除</span>
										 
											
										</dd>
										
										<dd style="display:none" class="check">
											<input type="radio" name="Checkout[address]" id="lllwww"
												class="addressId" value="${list.add_id}">

										</dd>
									</dl>
								</c:forEach>
								<div class="item use-new-addr" id="J_useNewAddr"
									data-state="off">
									<span class="iconfont icon-add"><img
										src="images/menu_plus.gif" style="width:15px;height:15px"/> </span> 使用新地址
								</div>
							</div>


							<input type="hidden" name="newAddress[type]" id="newType"
								value="common"> <input type="hidden"
								name="newAddress[consignee]" id="newConsignee"> <input
								type="hidden" name="newAddress[province]" id="newProvince">
							<input type="hidden" name="newAddress[city]" id="newCity">
							<input type="hidden" name="newAddress[district]" id="newCounty">
							<input type="hidden" name="newAddress[address]" id="newStreet">
							<input type="hidden" name="newAddress[zipcode]" id="newZipcode">
							<input type="hidden" name="newAddress[tel]" id="newTel">
							<input type="hidden" name="newAddress[tag_name]" id="newTag">
							<!--点击弹出新增/收货地址界面start-->
							
							<div class="xm-edit-addr-box" id="J_editAddrBox" >
								<div class="bd" >

									<div class="item">
										<label>收货人姓名<span>*</span> </label> <input type="text"
											name="userAddress[consignee]" id="Consignee" class="input"
											placeholder="收货人姓名" maxlength="15" autocomplete='off'>
										<p class="tip-msg tipMsg"></p>
									</div>
									<div class="item">
										<label>联系电话<span>*</span> </label> <input type="text"
											name="userAddress[tel]" class="input" id="Telephone"
											placeholder="11位手机号" autocomplete='off'>
										<p class="tel-modify-tip" id="telModifyTip"></p>
										<p class="tip-msg tipMsg"></p>
									</div>
									<div class="item">
										<div>
											<select id="s_province" name="userAddress[province]"
												class="select-1">

											</select> <select id="s_city" name="userAddress[city]"
												class="select-2"></select> <select id="s_county"
												name="userAddress[county]" class="select-3"></select>
											<script class="resources library"
												src="/FlowerShop1.0/frontmanager/js/area.js" type="text/javascript"></script>
											<script type="text/javascript">
												_init_area();
											</script>
										</div>
										<div id="show"></div>
										<script type="text/javascript">
											var Gid = document.getElementById;
											var showArea = function() {
												Gid('show').innerHTML = "<h3>省"
														+ Gid('s_province').value
														+ " - 市"
														+ Gid('s_city').value
														+ " - 县/区"
														+ Gid('s_county').value
														+ "</h3>"
												Gid('s_county').setAttribute(
														'onchange',
														'showArea()');
										</script>
										<textarea name="userAddress[street]" class="input-area"
											id="Street" placeholder="路名或街道地址，门牌号"></textarea>
										<p class="tip-msg tipMsg"></p>
									</div>
									
									<div class="item">
										<label>邮政编码<span>*</span> </label> <input type="text"
											name="userAddress[zipcode]" id="Zipcode" class="input"
											placeholder="邮政编码" autocomplete='off'>
										<p class="zipcode-tip" id="zipcodeTip"></p>
										<p class="tip-msg tipMsg"></p>
									</div>
									<div class="item">
										<label>地址标签<span>*</span> </label> <input type="text"
											name="userAddress[tag]" id="Tag" class="input"
											placeholder='地址标签：如"家"、"公司"。限5个字内'>
										<p class="tip-msg tipMsg"></p>
									</div>
								</div>
								<div class="ft clearfix">
									<button type="button" class="btn btn-lineDake btn-small "
										id="J_editAddrCancel">取消</button>
									<input type="submit" class="btn btn-primary  btn-small "
										id="addaddress" value="保存">
									</button>
									<script type="text/javascript">
										$(function() {
											$(".check").each(
												function() {
												  var c = $(this).find("#lllwww");
												  $("#checkoutToPay").click(
													function() {
														if (c.prop("checked") == true) {
															var s = c.val();
															$("#add_id_order").val(s);
														}
													});
												});
	
											$("#addaddress").click(
												function() {
												var province = $("#s_province").val();
												var city = $("#s_city").val();
												var county = $("#s_county").val();
												var tag = $("#Tag").val();
												var Zipcode = $("#Zipcode").val();
												var Consignee = $("#Consignee").val();
												var tel = $("#Telephone").val();
												var Street = $("#Street").val();
												var address = province+ city+ county+ Street;
                                                $.post("${pageContext.request.contextPath}/AddressServlet?method=addaddress",
													{
													  Consignee : Consignee,
													  tel : tel,
													  address : address,
													  Zipcode : Zipcode,
													  tag : tag
													},
													 function(data) {
													  if (data == 1) {
													  location.reload();
												      }}
												  );
											});
											
											
											$("span[id^='deladdress']").click(
												function() {
												var re=confirm("是否删除");
												if(re==true){
												var add_id = $("#add_id").val();
                                                $.post("${pageContext.request.contextPath}/AddressServlet?method=deladdress",
													{  
													 add_id: add_id
													},
													 function(data) {
													  if (data == 1) {
													  alert("删除成功");
													  location.reload();
												     }}
												  );
												  }
											});

									});
									
									</script>
								</div>

							</div>
							<!--点击弹出新增/收货地址界面end-->
							<div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
						</div>
					</div>
					<!-- 收货地址 END-->
					<div id="checkoutPayment">
						<!-- 支付方式 -->
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">支付方式</h2>
							</div>
							<div class="box-bd">
								<ul id="checkoutPaymentList"
									class="checkout-option-list clearfix J_optionList">
									<li class="item selected"><input type="radio"
										name="Checkout[pay_id]" checked="checked" value="1">
										<p>
											在线支付 <span></span>
										</p></li>
								</ul>
							</div>
						</div>
						<!-- 支付方式 END-->
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">配送方式</h2>
							</div>
							<div class="box-bd">
								<ul id="checkoutShipmentList"
									class="checkout-option-list clearfix J_optionList">
									<li class="item selected"><input type="radio"
										data-price="0" name="Checkout[shipment_id]" checked="checked"
										value="1">
										<p>
											快递配送（免运费） <span></span>
										</p></li>
								</ul>
							</div>
						</div>
						<!-- 配送方式 END-->
						<!-- 配送方式 END-->
					</div>
					<!-- 送货时间 -->
					<div class="xm-box">
						<div class="box-hd">
							<h2 class="title">送货时间</h2>
						</div>
						<div class="box-bd">
							<ul class="checkout-option-list clearfix J_optionList">
								<li class="item selected"><input type="radio"
									checked="checked" name="Checkout[best_time]" value="1">
									<p>
										不限送货时间<span>周一至周日</span>
									</p>
								</li>
								<li class="item "><input type="radio"
									name="Checkout[best_time]" value="2">
									<p>
										工作日送货<span>周一至周五</span>
									</p>
								</li>
								<li class="item "><input type="radio"
									name="Checkout[best_time]" value="3">
									<p>
										双休日、假日送货<span>周六至周日</span>
									</p>
								</li>
							</ul>
						</div>
					</div>
					<!-- 送货时间 END-->
					<!-- 发票信息 -->
					<div id="checkoutInvoice">
						<div class="xm-box">
							<div class="box-hd">
								<h2 class="title">发票信息</h2>
							</div>
							<div class="box-bd">
								<ul
									class="checkout-option-list checkout-option-invoice clearfix J_optionList J_optionInvoice">
									<li class="hide">电子个人发票4</li>
									<li class="item selected">
										<!--<label><input type="radio"  class="needInvoice" value="0" name="Checkout[invoice]">不开发票</label>-->
										<input type="radio" checked="checked" value="4"
										name="Checkout[invoice]">
										<p>电子发票（非纸质）</p></li>
									<li class="item "><input type="radio" value="1"
										name="Checkout[invoice]">
										<p>普通发票（纸质）</p></li>
								</ul>
								<p id="eInvoiceTip" class="e-invoice-tip ">
									电子发票是税务局认可的有效凭证，可作为售后维权凭据，不随商品寄送。开票后不可更换纸质发票，如需报销请选择普通发票。<a
										href="http://bbs.xiaomi.cn/thread-9285999-1-1.html"
										target="_blank">什么是电子发票？</a>
								</p>
								<div class="invoice-info nvoice-info-1"
									id="checkoutInvoiceElectronic" style="display:none;">

									<p class="tip">电子发票目前仅对个人用户开具，不可用于单位报销 ，不随商品寄送</p>
									<p>发票内容：购买商品明细</p>
									<p>发票抬头：个人</p>
									<p>
										<span class="hide"><input type="radio" value="4"
											name="Checkout[invoice_type]" checked="checked"
											id="electronicPersonal" class="invoiceType"> </span>
									<dl>
										<dt>什么是电子发票?</dt>
										<dd>&#903;
											电子发票是纸质发票的映像，是税务局认可的有效凭证，与传统纸质发票具有同等法律效力，可作为售后维权凭据。</dd>
										<dd>&#903; 开具电子服务于个人，开票后不可更换纸质发票，不可用于单位报销。</dd>
										<dd>
											&#903; 您在订单详情的"发票信息"栏可查看、下载您的电子发票。<a
												href="http://bbs.xiaomi.cn/thread-9285999-1-1.html"
												target="_blank">什么是电子发票？</a>
										</dd>
									</dl>
									</p>
								</div>
								<div class="invoice-info invoice-info-2"
									id="checkoutInvoiceDetail" style="display:none;">
									<p>发票内容：购买商品明细</p>
									<p>发票抬头：请确认单位名称正确,以免因名称错误耽搁您的报销。注：合约机话费仅能开个人发票</p>
									<ul class="type clearfix J_invoiceType">
										<li class="hide"><input type="radio" value="0"
											name="Checkout[invoice_type]" id="noNeedInvoice"></li>
										<li class=""><input class="invoiceType" type="radio"
											id="commonPersonal" name="Checkout[invoice_type]" value="1">
											个人</li>
										<li class=""><input class="invoiceType" type="radio"
											name="Checkout[invoice_type]" value="2"> 单位</li>
									</ul>
									<div id='CheckoutInvoiceTitle' class=" hide  invoice-title">
										<label for="Checkout[invoice_title]">单位名称：</label> <input
											name="Checkout[invoice_title]" type="text" maxlength="49"
											value="" class="input"> <span
											class="tip-msg J_tipMsg"></span>
									</div>

								</div>

							</div>
						</div>
					</div>
					<!-- 发票信息 END-->
				</div>
				<form id="checkoutForm"
					action="${pageContext.request.contextPath}/AddressServlet?method=addorderlistcart1&g_id=${listgood.g_id}&goodsnum=${goodsnum}"
					method="post">
					<div class="checkout-box-ft">
						<!-- 商品清单 -->
						<div id="checkoutGoodsList" class="checkout-goods-box">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">确认订单信息</h2>
								</div>
								<div class="box-bd">
									<dl class="checkout-goods-list">
										<dt class="clearfix">
											<span class="col col-1">商品名称</span> <span class="col col-2">购买价格</span>
											<span class="col col-3">购买数量</span> <span class="col col-4">小计（元）</span>
										</dt>
										<dd class="item clearfix">

											
												<div class="item-row">
													<div class="col col-1">
														<div class="g-pic">
															<img src="/FlowerShop1.0/img/${listgood.g_imgurl}"
																width="40" height="40" />
														</div>
														<div class="g-info">${listgood.g_name}</div>
													</div>

													<div class="col col-2">${listgood.goods_price}元</div>
												    <div class="col col-3">${goodsnum}</div>
													<div class="col col-4" id="totalprice">${totalmoney}元</div>
												</div>
												<%-- <input type="hidden" name="goodcid" value="${listgood.c_id}" />--%>	
												<input type="hidden" name="goodgid" value="${listgood.g_id}" /> 
											
										</dd>
										<dd class="item clearfix">
									</dl>
									</div>
									<div class="checkout-count clearfix">
										<div class="checkout-count-extend xm-add-buy">
											<h3 class="title">
												会员留言</h3>
												</br>
												<input type="text" />
										</div>
										<!-- checkout-count-extend -->
										<div class="checkout-price">
											<ul>
												<!--  -->
												<!--  ------------数据-------------------------------------->
												<!--  -->
												<input type="hidden" name="add_id_order" id="add_id_order" >
												<!--  -->
												




												<li>订单总额：<span>${totalmoney}元</span></li>
												<li>运费：<span id="postageDesc">0元</span></li>
											</ul>
											<p class="checkout-total">
											<input type="hidden" name="totalmoney" value="${totalmoney}">
												应付总额：<span><strong>${totalmoney}</strong>元</span>
											</p>
										</div>
										
									</div>
								</div>
							</div>
						</div>
						<!-- 商品清单 END -->
						<input type="hidden" id="couponType" name="Checkout[couponsType]">
						<input type="hidden" id="couponValue" name="Checkout[couponsValue]">
						<div class="checkout-confirm">
							<a href="${pageContext.request.contextPath}/CartServlet?method=gotoCart" class="btn btn-lineDakeLight btn-back-cart">返回购物车</a>
							<input type="submit" class="btn btn-primary" value="立即下单"
								id="checkoutToPay" />
						</div>
					</div>
			</div>

			</form>

		</div>
		<!-- 禮品卡提示 S-->
		<div class="modal hide lipin-modal" id="lipinTip">
			<div class="modal-header">
				<h2 class="title">温馨提示</h2>
				<p>
					为保障您的利益与安全，下单后礼品卡将会被使用，<br> 且订单信息将不可修改。请确认收货信息：
				</p>
			</div>
			<div class="modal-body">
				<ul>
					<li><strong>收&nbsp;&nbsp;货&nbsp;&nbsp;人：</strong><span
						id="lipin-uname"></span>
					</li>
					<li><strong>联系电话：</strong><span id="lipin-uphone"></span>
					</li>
					<li><strong>收货地址：</strong><span id="lipin-uaddr"></span>
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<span class="btn btn-primary" id="useGiftCard" >确认下单</span><span
					class="btn btn-dakeLight" id="closeGiftCard">返回修改</span>
			</div>
		</div>
		<!--  禮品卡提示 E-->
		<!-- 预售提示 S-->
		<div class="modal hide yushou-modal" id="yushouTip">
			<div class="modal-body">
				<h2>请确认收货地址及发货时间</h2>
				<ul class="list">
					<li><strong>请确认配送地址，提交后不可变更：</strong>
						<p id="yushouAddr"></p> <span class="icon-common icon-1"></span></li>
					<li><strong>支付后发货</strong>
						<p>如您随预售商品一起购买的商品，将与预售商品一起发货</p> <span class="icon-common icon-2"></span>
					</li>
					<li><strong>以支付价格为准</strong>
						<p>如预售产品发生调价，已支付订单价格将不受影响。</p> <span class="icon-common icon-3"></span>
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<p id="yushouOk" class="yushou-ok">
					<span class="icon-checkbox"><i class="iconfont">&#xe626;</i>
					</span> 我已确认收货地址正确，不再变更
				</p>
				<span class="btn btn-lineDakeLight" data-dismiss="modal">返回修改地址</span>
				<span class="btn btn-primary" id="yushouCheckout">继续下单</span>

			</div>
		</div>
		<!--  预售提示 E-->

		<!--  <script id="newAddrTemplate" type="text/x-dot-template">
        <dl class="item selected" data-isnew="true" data-consignee="{{=it.consignee}}" data-tel="{{=it.tel}}" data-province="{{=it.province}}" data-provincename="{{=it.provinceName}}" data-city="{{=it.city}}" data-cityname="{{=it.cityName}}" data-county="{{=it.county}}" data-countyname="{{=it.countyName}}" data-zipcode="{{=it.zipcode}}" data-street="{{=it.street}}" data-tag="{{=it.tag}}">
            <dt>
                <strong class="itemConsignee">{{=it.consignee}}</strong>
                {{? it.tag }}
                    <span  class="itemTag tag">{{=it.tag}}</span>
                {{?}}
            </dt>
            <dd>
                <p class="tel itemTel">{{=it.tel}}</p>
                <p  class="itemRegion">{{=it.provinceName}} {{=it.cityName}} {{=it.countyName}}</p>
                <p  class="itemStreet">{{=it.street}} ({{=it.zipcode}})</p>
                <span class="edit-btn J_editAddr">编辑</span>
            </dd>
        </dl>
</script>-->


		<!-- 保险弹窗 -->
		<!-- 保险弹窗 -->




		<script src="/FlowerShop1.0/frontmanager/js/base.min.js"></script>

		<script type="text/javascript"
			src="/FlowerShop1.0/frontmanager/js/address_all.js"></script>

		<script type="text/javascript"
			src="/FlowerShop1.0/frontmanager/js/checkout.min.js"></script>
	</div>

	<!--收货地址body部分结束-->

	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="/Shop1.0/frontmanger/js/unslider.min.js"
		type="text/javascript"></script>
	<script src="/Shop1.0/frontmanger/js/index.js" type="text/javascript"></script>










<!--//body  -->	


	<!-- <a href="#" class="to-buy">PROCEED TO BUY</a> -->
	<div class="clearfix"> </div>
 

  </body>
</html>
