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
    
    <title>修改信息</title>
    
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
      $("#gt_typename").blur(function(){
            var gt_typenameold="${goodtype.gt_typename}";
			var gt_typename = $("#gt_typename").val();
			$.post("GoodsTypeServlet",{method:"gt_typenameVertify02",gt_typename:gt_typename,gt_typenameold:gt_typenameold},function(data){
				var num = data;
				if (num==1) {
					if (gt_typename==""||gt_typename==null) {
						$("#gt_typenamespan").html("<img src='/Shop1.0/images/no.gif' height='18px'/>种类名不能为空！");						
					} else {
						$("#gt_typenamespan").html("<img src='/Shop1.0/images/yes.gif' height='18px'/>");		
					};
				}else{
					$("#gt_typenamespan").html("<img src='/Shop1.0/images/no.gif' height='18px'/>种类名已存在，请重新修改！");
				}
			});
		});
   
   
   $("#btn1").click(function(){ 
        var gt_typenameold="${goodtype.gt_typename}"; 
   		var gt_typename = $("#gt_typename").val();
   		var gtype_id = $("#gtype_id").val();
   		var gt_mark = $("#gt_mark").val();
   		var btn1span = $("#btn1span").val();
			if (gt_typename!=""&&gt_typename!=null&&gt_typename.indexOf(" ")==-1) {
				$.post("GoodsTypeServlet",{method:"goodstypeUpdate",gtype_id:gtype_id,gt_typename:gt_typename,gt_mark:gt_mark},function(data){
					var num = data;
					if (num==1) {
					    alert("修改成功");
						window.location.href="${pageContext.request.contextPath}/GoodsTypeServlet?method=goodstypeFindAll";
					} else if(num==2){
						$("#btn1span").html("种类名已存在，请重新修改！");
					};
				});
			}
			else
			{
			    $("#btn1span").html("种类名不能为空，请重新修改！");	
			}
		});
   
   });
</script>
  </head>
  
  <body>
     <div class="wrap">
   
   
  <div class="page-title">
    <span class="modular fl"><i></i><em>修改信息</em></span>
  </div>
   
   
  
   <input type="hidden" id="gtype_id" name="gtype_id" value="${goodtype.gt_id}">
   
   <br>分类名称：<input type="text" id="gt_typename" name="gt_typename" class="textBox length-long" placeholder="${goodtype.gt_typename}"/><span id="gt_typenamespan"></span><br><br>
        分类描述：<textarea rows="5" cols="30" type="text" id="gt_mark" name="gt_mark" class="textBox length-long" placeholder="输入分类描述"/></textarea>
   <br><br><input type="submit" id="btn1" value="保存" class="tdBtn" ><span id="btn1span"></span>
   
   

 </div>
 
  </body>
</html>
