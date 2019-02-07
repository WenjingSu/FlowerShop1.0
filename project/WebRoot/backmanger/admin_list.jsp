<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<title>管理员列表</title>
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
			
			$(function() {
				$("#add_manager").click(function() {
					var role = $("#a1").attr("href");
					if(role == 1) {
						window.location.href = "${pageContext.request.contextPath}/backmanger/add_manager.jsp";
					} else if(role == 2) {
						alert("您没有使用此功能的权限。");
					}
				});
				$("a[id^='revise']").click(function() {
					var role = $("#a1").attr("href");
					if(role == 1) {
						like = window.confirm("确定要修改权限么？");
						if(like == true) {
							var mid = $(this).attr("name");
							var role1 = $(this).attr("class");
							
							$.post("ManagerServlet", {
								method: "revise_manager",
								m_id: mid,
								m_role: role
							}, function(data) {
								var num = data;
								if(num == 1) {
									alert("修改成功!");
									window.location.href = "${pageContext.request.contextPath}/ManagerServlet?method=managerFindAll";
								} else if(num == 2) {
									alert("修改失败!");
								};
							});
						}
					} else if(role == 2) {
						alert("您没有使用此功能的权限。");
					}
				});
				$("a[id^='del']").click(function() {
					var role = $("#a1").attr("href");
					if(role == 1) {
						like = window.confirm("确定要删除么？");
						if(like == true) {
							var mid = $(this).attr("name");
							$.post("ManagerServlet", {
								method: "del_manager",
								m_id: mid
							}, function(data) {
								var num = data;
								if(num == 1) {
									alert("删除成功!");
									window.location.href = "${pageContext.request.contextPath}/ManagerServlet?method=managerFindAll";
								} else if(num == 2) {
									alert("删除失败!");
								};
							});
						} else {

						}
					} else if(role == 2) {
						alert("您没有使用此功能的权限。");
					}
				});
			});
		</script>
	</head>

	<body>
		<div class="wrap">
			<div class="page-title">
				<span class="modular fl"><i class="user"></i><em>管理员列表</em></span>
				<a id="a1" href="${manager.role}"></a>
				<span class="modular fr"><a class="pt-link-btn" id="add_manager">+添加管理员</a></span>
			</div>
			<table class="list-style Interlaced" style="text-align: center;">
				<tr>
					<th>管理员id</th>
					<th>管理员帐号</th>
					<th>管理员等级</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="managers">
					<tr>
						<td style="width: 15%;">${managers.m_id}</td>
						<td>${managers.m_name}</td>
						<c:if test="${managers.role eq 2}">
						<td>普通管理员</td>
						</c:if>
						<c:if test="${managers.role eq 1}">
						<td>超级管理员</td>
						</c:if>
						
						<td class="center">
							<a id="revise" name="${managers.m_id}" class="${managers.role}"><img src="images/icon_edit.gif" /></a>
							<a id="del" name="${managers.m_id}"><img src="images/icon_drop.gif" /></a>
						</td>
					</tr>
				</c:forEach>

			</table>
			
		</div>
	</body>
</html>