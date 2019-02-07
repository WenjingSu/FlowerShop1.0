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
    
    <title>修改用途信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="backmanger/style/adminStyle.css" type="text/css"></link>
  <script type="text/javascript" src="backmanger/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function(){
         var floUse_name="${flowerUse.floUse_name}";
         $("#floUse_name").val(floUse_name);
        
     }); 
    $(function () {
		$("#btn1").click(function(){  
		var floUse_id=$("#floUse_id").val();  
		var floUse_name=$("#floUse_name").val();
   	   
			if (floUse_name!=""&&floUse_name!=null&&floUse_name.indexOf(" ")==-1) {
				$.post("FlowerUseServlet",{method:"redact_FlowerUse",floUse_id:floUse_id,floUse_name:floUse_name,
				},function(data){
					var num = data;
					
					if(num==3)
					{
					alert("用途名不可以与其他花材名相同，请重新修改");
					}
					if (num==1) {
					    alert("修改成功");
						window.location.href="${pageContext.request.contextPath}/FlowerUseServlet?method=flowerUse_list";
					} else if(num==2){
						alert("修改失败");
					};
				});
			}
			else
			{alert("请完整用途信息");}
		});

		
		
	});
</script>
  </head>
  
  <body>
     <div class="wrap">
   
   
  <div class="page-title">
    <span class="modular fl"><i></i><em>修改用途信息</em></span>
  </div>
   
   
  
   <input type="hidden" id="floUse_id" name="floUse_id" value="${flowerUse.floUse_id}">
   
   <br>用途名称：<input type="text" id="floUse_name" name="floUse_name" class="textBox length-long" /><br><br>
   <br><br><input type="submit" id="btn1" value="保存" class="tdBtn" ><span id="btn1span"></span>
 </div>
 
  </body>
</html>
