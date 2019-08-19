<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>研究生个人成果管理系统</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="page-header col-md-6 col-md-offset-3">
    <h1>研究生密码修改 <small>请认真填写</small></h1>
</div>

<div class="col-md-6 col-md-offset-3">
    <s:actionerror/>
    <s:fielderror/>
    <s:form namespace="/" method="POST" action="student_xiugai" theme="simple" enctype="multipart/form-data">
        <s:hidden name="stu_id" value="%{model.stu_id}"/>
        <s:hidden name="stu_age" value="%{model.stu_age}"/>
        <s:hidden name="stu_gender" value="%{model.stu_gender}"/>
        <s:hidden name="stu_mobile" value="%{model.stu_mobile}"/>
        <s:hidden name="stu_email" value="%{model.stu_email}"/>
        <s:hidden name="stu_qq" value="%{model.stu_qq}"/>
        <s:hidden name="stu_address" value="%{model.stu_address}"/>
        <s:hidden name="stu_name" value="%{model.stu_name}"/>
        <s:hidden name="stu_username" value="%{model.stu_username}"/>

        <div class="form-group">
            <label>研究生姓名</label>
            <s:textfield cssClass="form-control" value="%{model.stu_name}" disabled="true"/>
        </div>
        <div class="form-group">
            <label>研究生学号</label>
            <s:textfield cssClass="form-control" value="%{model.stu_username}" disabled="true"/>
        </div>
        <div class="form-group">
            <label>研究生班级</label>
            <s:textfield cssClass="form-control" value="%{model.stu_class}" name="stu_class" required="true"/>
        </div>
        <div class="form-group">
            <label>研究生密码</label>
            <s:textfield cssClass="form-control" placeholder="请输入新密码" name="stu_password"/>
        </div>

        <button type="submit" class="btn btn-default">提交</button>
    </s:form>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>