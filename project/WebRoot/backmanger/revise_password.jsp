<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">

<title>修改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="backmanger/style/adminStyle.css"
	type="text/css"></link>
<script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	$(function old() {		
		$("#oldpassword").blur(function() {
			$.post("ManagerServlet",{method:"pwd",oldpassword:$("#oldpassword").val()},function(data){
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
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>两次密码不一致！");
			}else if(newpassword1==newpassword2){
				$("#newpassword1span").html("<img src='/FLowerShop1.0/images/yes.gif' height='18px'/>");
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
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/no.gif' height='18px'/>两次密码不一致！");
			}else if(newpassword1==newpassword2){
				$("#newpassword2span").html("<img src='/FlowerShop1.0/images/yes.gif' height='18px'/>");
			}
		});
	});
	
	$(function pwd() {	
		$("#btn1").click(function(){
			$.post("ManagerServlet",{method:"pwd",oldpassword:$("#oldpassword").val()},function(data){
				var n = data;
				var newpassword1 = $("#newpassword1").val();
				var newpassword2 = $("#newpassword2").val();
				var reg=/^[0-9a-zA-Z_]{8,20}$/;
				if (n==1&&newpassword1!=""&&newpassword1!=null&&newpassword1==newpassword2&&reg.test(newpassword1)==true) {
					$.post("ManagerServlet",{method:"m_pwd",newpassword:$("#newpassword1").val()},function(data){
						var nu = data;
						if (nu==1) {
						    alert("修改密码成功,请重新登录!");
						    window.parent.location="${pageContext.request.contextPath}/ManagerServlet?method=exit";
						    
							
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
</head>
<body>
	<div class="wrap">
		<div class="page-title">
			<span class="modular fl"><i class="user"></i><em>修改密码</em>
			</span>
		</div>
		<table class="noborder">
			<tr>
				<td width="15%" style="text-align:right;">当前账号：</td>
				<td><font>${manager.m_name}</font></td>
			</tr>
			<tr>
				<td style="text-align:right;">旧密码：</td>
				<td><input type="password" class="textBox length-middle"
					id="oldpassword" onblur="fun()" /><span id="oldpasswordspan"></span>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">新密码：</td>
				<td><input type="password" class="textBox length-middle"
					id="newpassword1" /><span id="newpassword1span"></span>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">再次确认密码：</td>
				<td><input type="password" class="textBox length-middle"
					id="newpassword2" /><span id="newpassword2span"></span>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;"></td>
				<td>
				<input type="submit" class="tdBtn" value="保存" id="btn1"/>
				<span id="pwd"></span>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>