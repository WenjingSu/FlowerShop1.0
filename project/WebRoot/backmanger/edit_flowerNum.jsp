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
    
    <title>修改枝数信息</title>
    
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
         var floNum_name="${flowerNum.floNum_name}";
         var floNum_mean="${flowerNum.floNum_mean}";
         $("#floNum_name").val(floNum_name);
         $("#floNum_mean").val(floNum_mean);
     }); 
    $(function () {
		$("#btn1").click(function(){  
		var floNum_id=$("#floNum_id").val();  
		var floNum_name=$("#floNum_name").val();
   		var floNum_mean=$("#floNum_mean").val();
			if (floNum_name!=""&&floNum_name!=null&&floNum_name.indexOf(" ")==-1) {
				$.post("FlowerNumServlet",{method:"redact_FlowerNum",floNum_id:floNum_id,floNum_name:floNum_name,
				floNum_mean:floNum_mean},function(data){
					var num = data;
					if(num==3)
					{
					alert("枝数名不可以与其他枝数名相同，请重新修改");
					}
					if (num==1) {
					    alert("修改成功");
						window.location.href="${pageContext.request.contextPath}/FlowerNumServlet?method=flowernum_list";
					} else if(num==2){
						alert("修改失败");
					};
				});
			}
			else
			{alert("请完整枝数信息");}
		});

		
		
	});
</script>
  </head>
  
  <body>
     <div class="wrap">
   
   
  <div class="page-title">
    <span class="modular fl"><i></i><em>修改枝数信息</em></span>
  </div>
   
   
  
   <input type="hidden" id="floNum_id" name="floNum_id" value="${flowerNum.floNum_id}">
   
   <br>枝数名称：<input type="text" id="floNum_name" name="floNum_name" class="textBox length-long" /><br><br>
        枝数含义：<textarea rows="5" cols="30"  id="floNum_mean" name="floNum_mean" class="textBox length-long" /></textarea>
   <br><br><input type="submit" id="btn1" value="保存" class="tdBtn" ><span id="btn1span"></span>
 </div>
 
  </body>
</html>
