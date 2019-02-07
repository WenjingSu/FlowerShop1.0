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
    
    <title>Flower Prices Scope</title>
    
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
<link rel="stylesheet" type="text/css" href="/FlowerShop1.0/frontmanager/css/pagination.css" media="all">
<script type="text/javascript" src="/FlowerShop1.0/frontmanager/js/jquery.pagination.js"></script>
<script>
    
    
    function handlePaginationClick(new_page_index, pagination_container) {
    
   	 $("#Form").attr("action", "<%=path%>/GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=${floPriceMin}&floPriceMax=${floPriceMax}&currentPage=" + (new_page_index+1));
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
	// 设置学生默认性别
	//$("#gender").val("${gender}");
	
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
				<div class="col-sm-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="/FlowerShop1.0/frontmanager/js/modernizr.custom.min.js"></script>    
					<link href="/FlowerShop1.0/frontmanager/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="/FlowerShop1.0/frontmanager/js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
						    <form id="Form" action="GoodsFrontServlet?method=goodsFindAllByPrice&floPriceMin=${floPriceMin}&floPriceMax=${floPriceMax}" method="post">
						    <input type="text" class="textBox length-long" placeholder="输入产品名称..." name="search" value="${goodsname}"/>
						   
						    </form>
						</div>
						<p>按enter以查询</p>
					</div>				
				</div>
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

<!--//banner-->
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >手机网站模板</a></div>
<!--content-->
<div class="content">
	<div class="container">
		<div class="content-top">
			<h1>Products</h1>
			<script type="text/javascript">
            function gocart(g_id){
                 function createXMLHttpRequest() {//解决浏览器的兼容问题
		         var xmlHttp;
		           if (window.XMLHttpRequest) {//
			       xmlHttp = new XMLHttpRequest(); //FF
		           } else {
			       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //IE	
		           }
		         return xmlHttp;
	             }
                 var xmlHttp = createXMLHttpRequest();
					var method = "post";
					var url = "CartServlet";
					xmlHttp.open(method, url, true);
					//post必须设置请求头，才能发送数据
					xmlHttp.setRequestHeader("Content-type",
							"application/x-www-form-urlencoded;charset=utf-8");

					xmlHttp.send("method=goodCart" + "&" + "g_id=" + g_id + "&"
							+ "amount=" + 1);
							
							xmlHttp.onreadystatechange = function() {
											if (xmlHttp.readyState == 4) {
												var text = xmlHttp.responseText;
												
											if(text==1){
											alert("添加成功");
                                            window.location.href="<%=path%>/CartServlet?method=gotoCart";
											} else if(text==2){
											alert("您尚未登陆，请先登录");
											
											}

										}
										};
                    } 

</script>
			
			<div class="content-top1">
			<c:forEach items="${list.dataList}" var="list"  varStatus="id">
			
				<div class="col-md-3 col-md2" style="margin:20px 0">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="${pageContext.request.contextPath}/GoodsFrontServlet?method=single_good_detail&g_id=${list.g_id}">
							<img class="img-responsive" style="width:240px;height:250px;" src="img/${list.g_imgurl}" alt="" />
						</a>
						<h3><a href="single.html">${list.g_name}</a></h3>
						<div class="price">
								<h5 class="item_price">￥${list.goods_price}</h5>
								<button type="button" class="item_add"
								onclick="gocart(${list.g_id})">加入购物车</button>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				</c:forEach>
					
			
				
			<!-- <div class="clearfix"> </div> -->
			</div>	
			<div class="content-top1">
			
			
			
			
			<div class="clearfix"> </div>
			</div>	
		</div>
		 <div id="News-Pagination" class="pagination" style="float:right;padding-top: 10px;padding-right: 100px;"></div><!--用来展示分页列表-->
	</div>
</div>
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
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
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
				<div class="col-sm-3 footer-bottom-cate cate-bottom">
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
