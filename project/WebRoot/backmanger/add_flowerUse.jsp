<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <base href="<%=basePath%>">
<title>添加新用途</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="backmanger/style/adminStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#btn1").click(function(){    
   		var floUse_name = $("#floUse_name").val();
			if (floUse_name!=""&&floUse_name!=null&&floUse_name.indexOf(" ")==-1) {
				$.post("FlowerUseServlet",{method:"add_FlowerUse",floUse_name:floUse_name},function(data){
					var num = data;
					if (num==1) {
					    alert("添加成功");
						window.location.href="${pageContext.request.contextPath}/FlowerUseServlet?method=flowerUse_list";
					} 
					else if(num==3){
						alert("该用途名已存在，请重新添加");
					}
					else if(num==2){
						alert("添加失败");
					};
				});
			}
			else{
			alert("用途名不能为空");
			}
		});
	});
</script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="flowerType"></i><em>添加新用途</em></span>
  </div>
  <table class="noborder">
   <tr>
    <td width="15%" style="text-align:right;">请输入用途名：</td>
    <td><input type="text" class="textBox length-middle" id="floUse_name"/>		
    </td>
   </tr>
  
   
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" id="btn1" class="tdBtn" value="保存" /></td>
   </tr>
  </table>
 </div>
</body>
</html>
