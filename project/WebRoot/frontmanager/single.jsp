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
    
    <title>Single</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="frontmanager/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="/FlowerShop1.0/frontmanager/js/jquery-1.9.1.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="frontmanager/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<script type="application/x-javascript"> 
   addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!---->

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
				<!-- <div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
					</div>				
				</div>		 -->
	<!---->		
		</div>
	</div>
</div>
<!---->


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
		
		$('.value-plus1').on('click',function() {
			var divUpd = $(this).parent().find('.value1');
			var newVal = parseInt(divUpd.val(), 10) + 1;
			var a = document.getElementById("amount").innerHTML;
			if (newVal <= a) {
				divUpd.val(newVal);
			    $("#total_price").html($("#item_price").html()*newVal);
				} else {
				alert("当前库存量为" + a);
				};		
				});

		$('.value-minus1').on('click',function() {
			var divUpd = $(this).parent().find('.value1');
			var newVal = parseInt(divUpd.val(), 10) - 1;
			var a = document.getElementById("amount").innerHTML;
			if (newVal >= 1&& a!=0){
			divUpd.val(newVal);
			$("#total_price").html($("#item_price").html()*newVal);
		    }				
		});

		$("#btn1").click(function() {
			var g_id = document.getElementById("g_id").value;
			var c = $(".value1").val();
			//alert(gid + "---" + c);
			var xmlHttp = createXMLHttpRequest();
			var method = "post";
			var url = "CartServlet";
			xmlHttp.open(method, url, true);
			//post必须设置请求头，才能发送数据
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			xmlHttp.send("method=goodCart" + "&" + "g_id=" + g_id + "&"+ "amount=" + c);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {
				var text = xmlHttp.responseText;	
				  if(text==1){
				  window.location.href="<%=path%>/CartServlet?method=gotoCart";
				} if(text==2){
				  alert("您尚未登陆，请先登录");
				 
				}
			}
			};
			});
      
			
	});
	
</script>

<script type="text/javascript">
$(function() {
$("#btn2").click(function() {
			var u_id=$("#u_id").val();
			if(u_id==""||u_id==null)
			{
			alert("您尚未登陆，请先登录");
			}
			else
			{
			var g_id = $("#g_id").val();
          	var c = $(".value1").val();  
			window.location.href="<%=path%>/AddressServlet?method=order&g_id="+g_id+"&buynum="+c+"";
		    }
	  	
			});

});
</script>
<div class="single">

<div class="container">
<div class="col-md-9">
	<div class="col-md-5 grid">		
		<div class="flexslider">
			  <ul class="slides">
			    <%-- <li data-thumb="img/${good.g_imgurl}">
			        <div class="thumb-image"> <img alt="" src="img/${good.g_imgurl}" data-imagezoom="true" class="img-responsive"> </div>
			    </li> --%>
			    <li data-thumb="img/${images[1]}">
			         <div class="thumb-image"> <img alt="" src="img/${images[1]}" data-imagezoom="true" class="img-responsive"> </div>
			    </li>
			    <li data-thumb="img/${images[2]}">
			       <div class="thumb-image"> <img alt="" src="img/${images[2]}" data-imagezoom="true" class="img-responsive"> </div>
			    </li> 
			    <li data-thumb="img/${images[3]}">
			       <div class="thumb-image"> <img alt="" src="img/${images[3]}" data-imagezoom="true" class="img-responsive"> </div>
			    </li>
			  </ul>
		</div>
	</div>	
 <div class="col-md-7 single-top-in">
						<div class="single-para simpleCart_shelfItem">
						    <input type="hidden" id="g_id" value="${good.g_id}">
							<h1>${good.g_name}</h1>
							<span>选用花材：</span>
							<c:forEach items="${types}" var="types">
							<span>${types.floType_name}</span>
							</c:forEach>
							<p></p>
							<span>枝数：${flowernum.floNum_name}</span>
							<p></p>
							<span>花语：${good.g_info}</span>
							<p></p>
							<span>库存：</span><span id="amount">${good.amount}</span><span>件</span>
							
							<p></p>
							<span>单价：</span><span id="item_price" class="add-to item_price">${good.goods_price}</span><span>元</span>
							<div class="star-on">
								
							<div>
									<a href="${pageContext.request.contextPath}/ReviewFrontServlet?method=findReviewBygid&g_id=${good.g_id}">查看商品评论 </a>		
							</div>
							<div class="clearfix"> </div>
							</div>
							
						
							
							<div class="star-on">
								
								<div>
									<a>选择商品数量:</a>
									<input type="button" id="min" name="" class="value-minus1"
						             style=" width:26px;border:1px solid #ccc;"
						             value="-" /> 
						             
						            <input type="text" id="text_box1" class="value1"
						             num="" name="" value="1"
						             style="height:26px;width:30px; text-align:center; border:1px solid #ccc;"
						             readonly="readonly" /> 
						             
						             <input type="button" id="add" name="" class="value-plus1"
						             style="border:1px solid #ccc;"
						             value="+" />
								</div>
							<div class="clearfix"> </div>
							</div>
							
							<div class="star-on">
							<div>
									<a>总价：</a>
									<span class="total_price" id="total_price" >${good.goods_price}</span>		
							</div>
							<div class="clearfix"> </div>
							</div>
							<input type="hidden" id="u_id" value="${user.u_id}">
							<button type="button" id="btn1" style="outline:none;border:none;background:rgb(82,208,196);padding:8px 0;color:#fff;width:20%;font-size:1em;text-transform:uppercase;margin:2em 0 0;">加入购物车</button>
							<button type="button" id="btn2" style="outline:none;border:none;background:rgb(82,208,196);padding:8px 0;color:#fff;width:20%;font-size:1em;text-transform:uppercase;margin:2em 0 0;">直接购买</button>
								
						</div>
					</div>
			<div class="clearfix"> </div>
			
</div>

<!----->
<div class="col-md-3 product-bottom">
			<!--categories-->
				
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
<!--seller-->
				<div class="product-bottom">
					<h3 class="cate">热销商品</h3>
					<c:forEach items="${list1}" var="list1">
					<div class="product-go">
						<div class=" fashion-grid">
							<a><img class="img-responsive " src="img/${list1.g_imgurl}" style="width:65px;height:69px;"></a>	
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2"><a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list1.g_id}" >${list1.g_name}</a></h6>
							<span class=" price-in1"> ￥${list1.goods_price}</span>
						</div>	
						<div class="clearfix"> </div>
					</div>
					</c:forEach>
						
							
				</div>


				
		</div>
		<div class="clearfix"> </div>
	</div>
	</div>
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<!-- <h2>Newsletter</h2>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form> -->
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<!-- <div class="footer-bottom">
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
	</div> -->
</div>
<!-- slide -->
<script src="frontmanager/js/jquery.min.js"></script>
<script src="frontmanager/js/imagezoom.js"></script>
<!-- start menu -->
<link href="frontmanager/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="frontmanager/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="frontmanager/js/simpleCart.min.js"> </script>
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
						<!-- FlexSlider -->
  <script defer src="frontmanager/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="frontmanager/css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
<!---pop-up-box---->
					<link href="frontmanager/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="frontmanager/js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
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

  </body>
</html>
