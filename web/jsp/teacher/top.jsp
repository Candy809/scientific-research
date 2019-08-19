<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>研究生个人成果管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
</head>
<body>
<div class="layui-header">
    <div class="layui-logo">研究生个人成果管理系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                老师：${teacher.tea_name}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="${pageContext.request.contextPath}/teacher_ziliaoUI.action?tea_id=<s:property value="%{#session.tea_id}"/>">修改资料</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index.jsp">退出系统</a></li>
    </ul>
</div>
</body>
</html>