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
    
    <title>修改花材信息</title>
    
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
         var floType_name="${flowerType.floType_name}";
         var floType_mean="${flowerType.floType_mean}";
         $("#floType_name").val(floType_name);
         $("#floType_mean").val(floType_mean);
     }); 
    $(function () {
		$("#btn1").click(function(){  
		var floType_id=$("#floType_id").val();  
		var floType_name=$("#floType_name").val();
   		var floType_mean=$("#floType_mean").val();
			if (floType_name!=""&&floType_name!=null&&floType_name.indexOf(" ")==-1) {
				$.post("FlowerTypeServlet",{method:"redact_FlowerType",floType_id:floType_id,floType_name:floType_name,
				floType_mean:floType_mean},function(data){
					var num = data;
					if(num==3)
					{
					alert("花材名不可以与其他花材名相同，请重新修改");
					}
					if (num==1) {
					    alert("修改成功");
						window.location.href="${pageContext.request.contextPath}/FlowerTypeServlet?method=flowertype_list";
					} else if(num==2){
						alert("修改失败");
					};
				});
			}
			else
			{alert("请完整花材信息");}
		});

		
		
	});
</script>
  </head>
  
  <body>
     <div class="wrap">
   
   
  <div class="page-title">
    <span class="modular fl"><i></i><em>修改花材信息</em></span>
  </div>
   
   
  
   <input type="hidden" id="floType_id" name="floType_id" value="${flowerType.floType_id}">
   
   <br>花材名称：<input type="text" id="floType_name" name="floType_name" class="textBox length-long" /><br><br>
        花语：<textarea rows="5" cols="30"  id="floType_mean" name="floType_mean" class="textBox length-long" /></textarea>
   <br><br><input type="submit" id="btn1" value="保存" class="tdBtn" ><span id="btn1span"></span>
 </div>
 
  </body>
</html>
