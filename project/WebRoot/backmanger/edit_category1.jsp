<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加一级分类</title>
    
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
			var gt_typename = $("#gt_typename").val();
			$.post("GoodsTypeServlet",{method:"gt_typenameVertify",gt_typename:gt_typename},function(data){
				var num = data;
				if (num==1) {
					if (gt_typename==""||gt_typename==null) {
						$("#gt_typenamespan").html("<img src='/Shop1.0/images/no.gif' height='18px'/>种类名不能为空！");						
					} else {
						$("#gt_typenamespan").html("<img src='/Shop1.0/images/yes.gif' height='18px'/>");		
					};
				}else{
					$("#gt_typenamespan").html("<img src='/Shop1.0/images/no.gif' height='18px'/>种类名已存在！");
				}
			});
		});
      
      $("#btn1").click(function(){    
   		var gt_typename = $("#gt_typename").val();
   		var gt_mark = $("#gt_mark").val();
   		var btn1span = $("#btn1span").val();
			if (gt_typename!=""&&gt_typename!=null&&gt_typename.indexOf(" ")==-1) {
				$.post("GoodsTypeServlet",{method:"goodstypeAdd",gt_typename:gt_typename,gt_mark:gt_mark},function(data){
					var num = data;
					if (num==1) {
					    alert("添加成功");
						window.location.href="${pageContext.request.contextPath}/GoodsTypeServlet?method=goodstypeFindAll";
					} else if(num==2){
						$("#btn1span").html("<img src='/Shop1.0/images/no.gif' height='18px'/>种类名已存在，请修改！");
					};
				});
			}
			else
			{
			    $("#btn1span").html("种类名不能为空，请修改！");	
			}
		});
      
   });
</script>
  </head>
  
  <body>
     <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>添加一级分类</em></span>
  </div>
   
   <br><input type="text" id="gt_typename" name="gt_typename" class="textBox length-long" placeholder="输入分类名称"/><span id="gt_typenamespan"></span><br><br>
   <textarea rows="5" cols="30" id="gt_mark" type="text" name="gt_mark" class="textBox length-long" placeholder="输入分类描述"/></textarea><span id="gt_markspan"></span>
   <input type="submit" id="btn1" value="保存" class="tdBtn" ><span id="btn1span"></span>
 
 
 </div>
  </body>
 
</html>
