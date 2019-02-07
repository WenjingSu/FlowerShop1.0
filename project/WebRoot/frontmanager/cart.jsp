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
    
    <title>Cart</title>
    
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
					  <!-- <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
					<link href="frontmanager/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="frontmanager/js/jquery.magnific-popup.js" type="text/javascript"></script>
					-//pop-up-box--
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<form id="Form" action="GoodsFrontServlet?method=fuzzy_find_goods" method="post">
						    <input type="text" class="textBox length-long" placeholder="输入产品名称..." name="search"/>
						   
						    </form>
						</div>
						<p>按enter以查询</p>
					</div>				
				</div> -->
				<!--  <script>
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
				</script>			 -->
	<!---->		
		</div>
	</div>
</div>
<!--//header-->

<script type="text/javascript">
	$(document).ready(function() {
		$(".gwc_tb2 input[name=newslist]").click(function() {
		
			GetCount();
			
		});
	});
	//******************
	function GetCount() {
		var zong = 0;
		var shuliang = 0;
		
		$(".gwc_tb2 input[name=newslist]").each(
				function() {
				
					if ($(this).prop("checked")) {
						for ( var i = 0; i < $(this).length; i++) {
							zong += parseFloat($(this).parent().parent().find(
									"#total1").text());
							shuliang += parseInt($(this).parent().parent().find(
									"#text_box1").val());
						}
					}
				});
		$("#shuliang").html((shuliang).toFixed(0));
		$("#zong1").html((zong).toFixed(2));
		$("#jz1").css("display", "none");
		$("#jz2").css("display", "block");
	}
</script>


<!---商品加减算总数---->
<script type="text/javascript">
        function createXMLHttpRequest() {//解决浏览器的兼容问题
		   var xmlHttp;
		   if (window.XMLHttpRequest) {//
		   xmlHttp = new XMLHttpRequest(); //FF
           } else {
		   xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //IE	
		   }
		   return xmlHttp;
	       }

	    $(function() {
		   var zong = $("#zong1");
		   var shuliang= $("#shuliang");
		   $(".gwc_tb2 tr").each(function() {
				var t = $(this).find("#text_box1");//数量
				var t2 = $(this).find("#text_box2");//单价
				var total1 = $(this).find("#total1");//小计		
				var cheak = $(this).find("#newslist-2");//cid checkbox
				var c_id=$(this).find("#c_id");
				$(this).find("#add").click(
					function() {
						if (t.val() < parseInt(t.attr("num"))) {
							t.val(parseInt(t.val()) + 1);//t.val()获取id为"#text_box1"的value值，转换为int类型并加1，再赋值给吞t。val()
							var money = (parseInt(t.val()) * parseFloat(t2.text())).toFixed(2);
							total1.html(money);
							var xmlHttp = createXMLHttpRequest();
							var method = "post";
							var url = "CartServlet";
							xmlHttp.open(method, url, true);
							//post必须设置请求头，才能发送数据
							xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
							xmlHttp.send("method=UpdateAmountInCart"+ "&" + "c_id=" +cheak.val()+"&"+"amount="+t.val());
							xmlHttp.onreadystatechange = function()
							{
							  if (xmlHttp.readyState == 4)
							  {
								text = xmlHttp.responseText;
							  }
							}
							  if (cheak.is(":checked")) 
							  {
								var zongMoney = 0;
								zongMoney = eval(parseFloat(zong.text())+ parseFloat(t2.text()));
								zong.text(zongMoney.toFixed(2));			 
								var shuliangTotal=0;
								shuliangTotal= eval(parseInt(shuliang.text())+ 1);
							    shuliang.html(shuliangTotal.toFixed(0));
							   }
							}
						});
							$(this).find("#min").click(
								function() {
									if (t.val() > 1) {
							           t.val(parseInt(t.val()) - 1);
									   var money = (parseInt(t.val()) * parseFloat(t2.text())).toFixed(2);
									   total1.html(money);
									   var xmlHttp = createXMLHttpRequest();
									   var method = "post";
									   var url = "CartServlet";
									   xmlHttp.open(method, url, true);
										//post必须设置请求头，才能发送数据
									   xmlHttp.setRequestHeader(
									   "Content-type","application/x-www-form-urlencoded;charset=utf-8");
										xmlHttp.send("method=UpdateAmountInCart"
												+ "&" + "c_id=" +cheak.val()+"&"+"amount="+t.val());
													
										xmlHttp.onreadystatechange = function()
										 {
											if (xmlHttp.readyState == 4)
											 {
												text = xmlHttp.responseText;
											 }
										 }			
											if (cheak.is(":checked")) {
											    var zongMoney = 0;
												zongMoney = eval(parseFloat(zong.text())-parseFloat(t2.text()));
												zong.text(zongMoney.toFixed(2));
												
											    var shuliangTotal=0;
									            shuliangTotal= eval(parseInt(shuliang.text())- 1);
									            shuliang.html(shuliangTotal.toFixed(0));
											 }
									}
								});
							var m = (parseInt(t.val()) * parseFloat(t2.text())).toFixed(2);
							total1.text(m);
							$(this).find("#delete").click(function(){
                               //alert( cheak.val());
			                   var re=confirm("是否删除");
					           if(re==true){
					                    var xmlHttp = createXMLHttpRequest();
										var method = "post";
										var url = "CartServlet";
										xmlHttp.open(method, url, true);
										//post必须设置请求头，才能发送数据
										xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
										xmlHttp.send("method=deleteCart"+ "&" + "c_id=" + cheak.val());
									    xmlHttp.onreadystatechange = function()
										 {
										    if (xmlHttp.readyState == 4)
											  {
												text = xmlHttp.responseText;
												//alert(text);
												location.reload();
											  }
										 }
					                }
                                });		
						  });
	});
	
	          $(function() {
		           $("#jz2").click(function() {
		           //alert("go to order");
			       var arrcid = "";
			       var arrNum = "";
		           $(".gwc_tb2 tr").each(function() {
				   var check = $(this).find("#newslist-2");
				   var t1 = $(this).find("#text_box1");
				     if (check.is(":checked")) {
				 	    arrcid +=   "," +check.attr("value"); 
				     }
			        });
			       var totalmoney=$("#zong1").html();
			       
		           var xmlHttp = createXMLHttpRequest();
			       var method = "post";
			       var url = "AddressServlet";
		           xmlHttp.open(method, url, true);
				  //post必须设置请求头，才能发送数据
		           xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
                   xmlHttp.send("method=setsession&arrcid=" + arrcid+"&totalmoney="+totalmoney);
				   xmlHttp.onreadystatechange = function()
				  {
					 if (xmlHttp.readyState == 4)
						{
					     text = xmlHttp.responseText;
						 window.location.href = "<%=path%>/AddressServlet?method=addorderlistall";
						}	
			       }
		         });
	 });
</script>
<!--end  -->




<!---->
<div class="container">
	<div class="check-out">
		<!-- <h1>Checkout</h1> -->
    	    <table class="gwc_tb2">
		  <tr>
			<th>全选</th>
			<th>商品信息</th>
			<th></th>
			<th>数量</th>		
			<th>单价</th>
			<th>小计</th>
			<th>操作</th>
		  </tr>
		  <c:forEach items="${list}" var="list">
		  <tr>
		  
		    <td><input type="checkbox"
						value="${list.c_id}" name="newslist" id="newslist-2" /> <input
						type="hidden" id="c_id" value="" /></td>
				
		
			<td><a style="color:#ccc;"href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list.g_id}">${list.g_name}</a></td>	
			<td class="ring-in"><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list.g_id}" class="at-in"><img src="img/${list.g_imgurl}" class="img-responsive" alt=""></a>
			<div class="sed">
				<p>${list.g_info}</p>
			
			</div>
			<div class="clearfix"> </div></td>
			<td><input id="min" name=""
						style="width:20px; height:18px;border:1px solid #ccc;"
						type="button" value="-" /> 
						<input id="text_box1"
						num="${list.amount}" name="" type="text"
						value="${list.goods_amount }"
						style=" width:30px; text-align:center; border:1px solid #ccc;"
						readonly="readonly" /> 
						<input id="add" name="" class="add"
						style=" width:20px; height:18px;border:1px solid #ccc;"
						type="button" value="+" />
			</td>
			
					
			<td id="text_box2">${list.goods_price}</td>
			
			<%-- <td class="check"><input type="text" value="${list.amount}" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		 --%>
			
			<td class="tb1_td6"><label id="total1" class="tot"
			style="color:rgb(82,208,196);font-size:14px; font-weight:bold;"></label></td>
			
			<td class="tb1_td7"><input type="button" value="删除" style="border:1px solid #ccc;"
			id="delete"></td>
		  </tr>
		  </c:forEach>
		 
	</table>
	<table>
		  <tr>
				
				<td>已选商品 <label id="shuliang"
					style="color:rgb(82,208,196);font-size:14px; font-weight:bold;">0</label> 件</td>
				<td>合计(不含运费):<span>￥</span><span
					style=" color:#ff5500;"><label id="zong1"
						style="color:rgb(82,208,196);font-size:14px; font-weight:bold;">0.00</label>
				</span>
				</td>
				<td><span id="jz1"></span><input
					type="button" style="display:block;" id="jz2"
					class="to-buy" value="结算" /></td>
		  </tr>
		</table>
	
	<!-- <a href="#" class="to-buy">PROCEED TO BUY</a> -->
	<div class="clearfix"> </div>
    </div>
</div>
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
