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
    
    <title>User Zone</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="/FlowerShop1.0/frontmanager/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/FlowerShop1.0/frontmanager/js/jquery-1.9.1.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/FlowerShop1.0/frontmanager/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="/FlowerShop1.0/frontmanager/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="/FlowerShop1.0/frontmanager/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="/FlowerShop1.0/frontmanager/js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="/FlowerShop1.0/frontmanager/js/responsiveslides.min.js"></script>

<script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
    
 
  </script>
  


  </head>
  
  <body>
   <!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-sm-4 world">
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
				      <li><a>个人中心</a>
				      	<div class="mepanel">
						<div class="row">
						<div class="col1">
								<div class="h_nav">
									<h4>个人资料</h4>
									<ul>
								      <li><a href="${pageContext.request.contextPath}/UserFrontServlet?method=userPageSkip">修改头像</a></li>
								      <li><a href="${pageContext.request.contextPath}/UserFrontServlet?method=userInfoSkip">修改个人资料</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>安全设置</h4>
									<ul> 
									<li><a href="${pageContext.request.contextPath}/UserFrontServlet?method=userUpdatePwdSkip">修改登录密码</a></li>
									<li><a href="${pageContext.request.contextPath}/frontmanager/userPhone.jsp">手机绑定</a></li>
									<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByType&floType_id=${flowerTypes.floType_id}">身份认证</a></li>
										
									
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>账号绑定</h4>
									<ul>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=100&floPriceMax=200">支付宝绑定</a></li>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=200&floPriceMax=300">微信绑定</a></li>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=300&floPriceMax=600">微博绑定</a></li>
										<li><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=600&floPriceMax=20000">邮箱绑定</a></li>
									</ul>	
								</div>												
							</div>
						  
						  </div>
						  
						</div>
					</li>
<!-- ======================================================================================== -->
				    <li class="grid"><a  href="${pageContext.request.contextPath}/UserFrontServlet?method=userorderlist">我的花礼</a>
			        </li>
				<li><a  href="${pageContext.request.contextPath}/UserFrontServlet?method=exit">安全退出</a></li>				
				<li><a class="color6" href="contact.html">联系我们</a></li>
			  </ul> 
			</div>
				<!-- <div class="col-sm-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div> -->
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="/FlowerShop1.0/frontmanager/js/modernizr.custom.min.js"></script>    
					<link href="/FlowerShop1.0/frontmanager/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="/FlowerShop1.0/frontmanager/js/jquery.magnific-popup.js" type="text/javascript"></script>
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
<!--banner-->
<!--content-->
<div class="products">
	<div class="container">
		<!-- <h1>haha</h1> -->
		
		
		<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
						<h3 class="cate">安全设置</h3>
							 <ul class="menu-drop">
							<%-- <li class="item1"><a href="${pageContext.request.contextPath}/UserFrontServlet?method=userPageSkip">修改头像</a>
								
							</li>
							<li class="item2"><a href="${pageContext.request.contextPath}/UserFrontServlet?method=userInfoSkip">修改个人资料</a>
								
							</li> --%>
							
						</ul>
					</div>
				<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
<!--//menu-->

				
		</div>
<script type="text/javascript">
	$(function old() {		
		$("#oldpassword").blur(function() {
			$.post("UserFrontServlet",{method:"userPwdVertify",oldpassword:$("#oldpassword").val()},function(data){
				var num = data;
				if (num==1) {
					$("#oldpasswordspan").html("<img src='/FlowerShop1.0/images/yes.gif' height='18px'/>");
					
				} else{
					$("#oldpasswordspan").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>密码错误！");
					
				}
			});
		});
	});
	
	$(function new1() {
		$("#newpassword1").blur(function() {
		
			var newpassword1 = $("#newpassword1").val();
			var oldpassword = $("#oldpassword").val();
			var newpassword2 = $("#newpassword2").val();
			var reg=/^[0-9a-zA-Z_]{8,20}$/;
			
			if(newpassword1==""||newpassword1==null){
				$("#newpassword1span").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>密码不能为空！");
				$("#newpassword2span").html("");
				
			}else if(!reg.test(newpassword1)){
				$("#newpassword1span").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>必须由数字、字母下划线组成（8-20位）！");
				$("#newpassword2span").html("");
			}else if(newpassword1!=newpassword2){
				$("#newpassword1span").html("<img src='/FlowerShop1.0/images/yes.gif' height='18px'/>");
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>密码不一致");
			}else if(newpassword1==newpassword2){
				$("#newpassword1span").html("<img src='/FlowerShop1.0/images/yes.gif' height='18px'/>");
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/yes.gif' height='18px'/>");
			}
		});
	});
	$(function new2() {	
		$("#newpassword2").blur(function() {
			var newpassword1 = $("#newpassword1").val();
			var newpassword2 = $("#newpassword2").val();
			var oldpassword = $("#oldpassword").val();
			var reg=/^[0-9a-zA-Z_]{8,20}$/;
			if (oldpassword!=""&&newpassword1==oldpassword) {
				$("#newpassword2span").html("");			
			}else if (newpassword1==""||newpassword1==null) {
				$("#newpassword2span").html("");			
			}else if(!reg.test(newpassword1)){
				$("#newpassword2span").html("");
			}else if(newpassword1!=newpassword2){
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>密码不一致");
			}else if(newpassword1==newpassword2){
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/yes.gif' height='18px'/>");
			}
		});
	});
	
	$(function pwd() {	
		$("#btn1").click(function(){
			$.post("UserFrontServlet",{method:"userPwdVertify",oldpassword:$("#oldpassword").val()},function(data){
				var n = data;
				var newpassword1 = $("#newpassword1").val();
				var newpassword2 = $("#newpassword2").val();
				var reg=/^[0-9a-zA-Z_]{8,20}$/;
				if (n==1&&newpassword1!=""&&newpassword1!=null&&newpassword1==newpassword2&&reg.test(newpassword1)==true) {
					$.post("UserFrontServlet",{method:"userUpdatePwd",newpassword:$("#newpassword1").val()},function(data){
						var nu = data;
						if (nu==1) {
						    alert("修改密码成功,请重新登录!");
						    window.parent.location="${pageContext.request.contextPath}/UserFrontServlet?method=userUpdateLoginSkip";
						    
							
						} else{
							alert("修改密码失败,请重新修改!");
						}
					});
				} else{
					$("#pwd").html("请输入正确的密码！");
				};
			});
		});
	});
	
</script>		
		
		
		<div class="col-md-9 product-bottom">
		
              <div class="">旧密码：
              
                <input type="password" class="textBox length-middle"
					id="oldpassword" style="width:300px;"/><span id="oldpasswordspan" style="width:200px"></span>
			
			  </div>
			  <br>
			  <div class="">新密码：
                <input type="password" class="textBox length-middle"
					id="newpassword1" style="width:300px;"/><span id="newpassword1span"></span>
			
			  </div>
              <br>
               <div class="">新密码：
                <input type="password" class="textBox length-middle"
					id="newpassword2" style="width:300px;"/><span id="newpassword2span"></span>
			  </div>
              <br>  
              <div>
              <input type="button"  id="btn1" value="保存" 
               style="outline:none;border:none;background:rgb(82,208,196);padding:8px 0;color:#fff;width:12%;height:5.5%;font-size:1em;text-transform:uppercase;margin:2em 0 0;"
              />
              </div>
                  
        </form>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//content-->
<!--//banner-->

<!--content-->

<!--//content-->
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onFocus="this.value='';" onBlur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						
						
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						
						
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						
						
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus  dui. </li>
						
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
