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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%--=================================== 顶部 ===================================--%>
    <%@ include file="/jsp/student/top.jsp" %>
    <%--=================================== 菜单 ===================================--%>
    <%@ include file="/jsp/student/menu.jsp" %>
    <%--=================================== 底部 ===================================--%>
    <%@ include file="/jsp/student/footer.jsp" %>

    <%--=================================== 主体 ===================================--%>
    <div class="layui-body">


        <div>
            <object codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
                    classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="300" height="90">
                <param value="http://qimok.cn/clock.swf" name="movie">
                <param value="high" name="quality">
                <param value="always" name="allowScriptAccess">
                <param value="internal" name="allowNetworking">
                <param value="transparent" name="wmode">
                <embed wmode="transparent" type="application/x-shockwave-flash"
                       pluginspage="http://www.macromedia.com/go/getflashplayer" allownetworking="internal"
                       allowscriptaccess="always" quality="high" src="http://qimok.cn/clock.swf" width="1200"
                       height="360">
            </object>
        </div>

    </div>

    <%--=================================== 分割线 ===================================--%>
        <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
        <script>
            //JavaScript代码区域
            layui.use('element', function(){
                var element = layui.element;

            });
        </script>

</body>
</html>