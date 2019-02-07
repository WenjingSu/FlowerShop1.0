<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <base href="<%=basePath%>">
<title>添加新花材</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="backmanger/style/adminStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#btn1").click(function(){    
   		var floType_name = $("#floType_name").val();
   		var floType_mean = $("#floType_mean").val();
			if (floType_name!=""&&floType_name!=null&&floType_name.indexOf(" ")==-1) {
				$.post("FlowerTypeServlet",{method:"add_FlowerType",floType_name:floType_name,floType_mean:floType_mean},function(data){
					var num = data;
					if (num==1) {
					    alert("添加成功");
						window.location.href="${pageContext.request.contextPath}/FlowerTypeServlet?method=flowertype_list";
					} 
					else if(num==3){
						alert("该花材名已存在，请重新添加");
					}
					else if(num==2){
						alert("添加失败");
					};
				});
			}
			else{
			alert("花材名不能为空");
			}
		});
	});
</script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="flowerType"></i><em>添加新花材</em></span>
  </div>
  <table class="noborder">
   <tr>
    <td width="15%" style="text-align:right;">请输入花材名：</td>
    <td><input type="text" class="textBox length-middle" id="floType_name"/>
    		
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">请输入花材含义：</td>
    <td><textarea rows="5" cols="30" id="floType_mean" type="text" name="floType_mean" class="textBox length-middle" placeholder="输入花材含义"></textarea>
    		
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
