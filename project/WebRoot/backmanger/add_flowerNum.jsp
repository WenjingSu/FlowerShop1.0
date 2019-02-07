<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <base href="<%=basePath%>">
<title>添加新枝数</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="backmanger/style/adminStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#btn1").click(function(){    
   		var floNum_name = $("#floNum_name").val();
   		var floNum_mean = $("#floNum_mean").val();
			if (floNum_name!=""&&floNum_name!=null&&floNum_name.indexOf(" ")==-1) {
				$.post("FlowerNumServlet",{method:"add_FlowerNum",floNum_name:floNum_name,floNum_mean:floNum_mean},function(data){
					var num = data;
					if (num==1) {
					    alert("添加成功");
						window.location.href="${pageContext.request.contextPath}/FlowerNumServlet?method=flowernum_list";
					} 
					else if(num==3){
						alert("该枝数名已存在，请重新添加");
					}
					else if(num==2){
						alert("添加失败");
					};
				});
			}
			else{
			alert("枝数名不能为空");
			}
		});
	});
</script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="flowerNum"></i><em>添加新枝数</em></span>
  </div>
  <table class="noborder">
   <tr>
    <td width="15%" style="text-align:right;">请输入枝数名：</td>
    <td><input type="text" class="textBox length-middle" id="floNum_name"/>
    		<span id="floNum_name_span"></span>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">请输入枝数含义：</td>
    <td><textarea rows="5" cols="30" id="floNum_mean" type="text" name="floNum_mean" class="textBox length-middle" placeholder="输入枝数含义"></textarea>
    		<span id="floNum_mean_span"></span>
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
