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
    
    <title>Register</title>
    
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
				<div class="col-md-4 logo">
					<a href="${pageContext.request.contextPath}/FirstServlet?method=goodstypeFindAll"><img src="images/logo.png" alt=""></a>	
				</div>
		
			<div class="col-md-4 header-left">		
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
				<div class="col-md-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>157 3510 4157</span>
				</div>
		  <div class="col-md-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="${pageContext.request.contextPath}/FirstServlet?method=goodstypeFindAll">主页</a></li>	
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
					<!---//pop-up-box---->
				<!-- <div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
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
<div class="container">


                           <script type="text/javascript">							
								$(function(){
									//帐号验证
									$("#name1").blur(function(){
										var re1=/^[a-zA-Z0-9_]{5,19}$/;
										var name1 = $("#name1").val();
										if(name1==""||name1==null){
										$("#name1span").html("用户名不能为空");
										$("#register1").attr("disabled","disabled");
										}
										else
										{
										if (re1.test(name1)) {
											$("#name1span").html("格式正确");
										} else{
											$("#name1span").html("格式错误");
											$("#register1").attr("disabled","disabled");
										}
										$.post("UserFrontServlet",{method:"userFindbyName",name1:name1},function(data){
											var num = data;
											if (num==1) {
												
											} else if(num==2){
												$("#name1span").html("该帐号已被注册");
												$("#register1").attr("disabled","disabled");
											};
										});
										}
									});
									$("#name1").keyup(function(){
										var name1 = $("#name1").val();
										var num = name1.replace().length;
										$("#name1span").html("<font>"+num+"个字符</font>");
									});
									
									
									//密码验证
									$("#password1").blur(function(){
										var re1=/^[a-zA-Z0-9_]{6,20}$/;
										var password1 = $("#password1").val();
										var password2 = $("#password2").val();
										if(password1==""||password1==null){
										$("#password1span").html("密码不能为空");
										$("#register1").attr("disabled","disabled");
										}
										else{
										if (re1.test(password1)) {
											$("#password1span").html("格式正确");
											if (password1==password2) {
											$("#password2span").html("格式正确");
										    } else{
											      $("#password2span").html("两次密码不一致");
											      $("#register1").attr("disabled","disabled");
										    }
										} else{
											$("#password1span").html("格式错误");
											$("#register1").attr("disabled","disabled");
										}
										}
									});
									$("#password1").keyup(function(){
										var password1 = $("#password1").val();
										var num = password1.replace().length;
										$("#password1span").html(num+"个字符");
									});
									$("#password2").blur(function(){
										var password1 = $("#password1").val();
										var password2 = $("#password2").val();
										if (password1==password2) {
											$("#password2span").html("格式正确");
										} else{
											$("#password2span").html("两次密码不一致");
											$("#register1").attr("disabled","disabled");
										}
									});
									$("#password2").keyup(function(){
										var password2 = $("#password2").val();
										var num = password2.replace().length;
										$("#password2span").html(num+"个字符");
									});
									
									$("#tel1").blur(function (){		
										var tel1 = $("#tel1").val();
										$.post("UserFrontServlet",{method:"userPhoneFindbyName",tel1:tel1},function(data){
											var num = data;
											if (num==1&&tel1!=""&&tel1!=null&&re1.test(tel1)) {
												
											} else if(num==2){
												$("#tel1span").html("该手机号已被注册");
												$("#register1").attr("disabled","disabled");
											};
										});	
									});
									$("#tel1").keyup(function(){
										var re1=/^[0-9]{11}$/;
										var tel1 = $("#tel1").val();
										if (re1.test(tel1)) {
											$("#tel1span").html("");
										} else{
											$("#tel1span").html("请输入正确的11位手机号");
											$("#register1").attr("disabled","disabled");
										}
									});
									//将验证码发送给手机号
									$("#code1").click(function(){														
										var tel1 = $("#tel1").val();		
										      $.post("UserFrontServlet",{method:"userPhoneFindbyName",tel1:tel1},function(data){
											      var num = data;
											          if (num==1) {
											          $.post("UserFrontServlet",{method:"userPhoneCode",tel1:tel1},function(data){
											          var code1 = data;
											          if(code1==2)
											          {}
											          else
											          {
												         $.post("UserFrontServlet",{method:"userPhone",tel1:tel1,code1:code1},function(data){
													     var num = data;
													        if (num==1) {
														    alert("发送成功！");
													        } else if(num==2){
														    alert("发送失败!");
														    $("#register1").attr("disabled","disabled");
													        };
												         });
												         }
										                 });		
											          }else if(num==2){
												         alert("手机号已经被注册");
												         $("#register1").attr("disabled","disabled");
											          };
										          });		
												
										
										
															
									});
									//验证码验证
									$("#code3").blur(function(){
									     var tel1 = $("#tel1").val();
									     var code1 = $("#code3").val();
										 $.post("UserFrontServlet",{method:"userPhoneCodeVertify",tel1:tel1,code1:code1},function(data){
												 var num = data;
												 if (num==1) {
												 $("#register1").removeAttr("disabled");
									             $("#code3span").html("验证码正确");
											     } else if(num==2){
												 $("#register1").attr("disabled","disabled");
											     $("#code3span").html("验证码错误");
											     };
												});
									
									});
									$(".mation input").blur(function(){
										var code3 = $("#code3").val();
										if (code3==""||code3==null) {
											$("#register1").attr("disabled","disabled");
										}
									});
								});				
								
							</script>














	<div class="register">
		<h1>Register</h1>
		  	  <form action="UserFrontServlet?method=userRegister" method="post"> 
				 <div class="col-md-6  register-top-grid" style="margin-left:25%" >
					        <div class="mation">
						    <span>用户名</span>
						    <input id="name1" placeholder="帐号/6-20个字符/只能由字母、数字、下划线组成"
							name="Name" type="text" style="width: 100%;"> <div id="name1span" class="jingwenshitai"></div>
					      
							
							<span>密码</span>    
							<input id="password1" placeholder="密码/6-20个字符/只能由字母、数字、下划线组成" name="Password"
							type="password" style="width: 100%;"><div id="password1span" class="jingwenshitai"></div>
							
							<span>确认密码</span>  <span id="passwordspan"></span>
							<input id="password2" placeholder="验证密码/6-20个字符/只能由字母、数字组成" name="Password"
							type="password" style="width: 100%;">  <div id="password2span" class="jingwenshitai"></div>
							
							<span >手机号</span>
						    <input id="tel1" placeholder="手机号"
							name="Tel" type="text"
							style="width: 100%;margin:1em 0 0;"> <div id="tel1span" class="jingwenshitai"></div>
							
							<span>验证码</span>
							<input id="code3" placeholder="验证码"
							name="Code" type="text"
							style="width: 100%;margin:1em 0 0;"><div id="code3span" class="jingwenshitai"></div>
							<input type="button" id="code1" value="发送验证码"
							style="outline:none;border:none;background:rgb(82,208,196);padding:8px 0;color:#fff;width:20%;font-size:1em;text-transform:uppercase;margin:2em 0 0;">
						    
							<input type="submit" id="register1" value="立即注册" 
							style="outline:none;border:none;background:rgb(82,208,196);padding:8px 0;color:#fff;width:20%;font-size:1em;text-transform:uppercase;margin:2em 0 0;"
							disabled="disabled">
							</div>
				</div>
					 <div class="clearfix"> </div>
					
					 
					 <div class="clearfix"> </div>
					 
				</form>
				
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
