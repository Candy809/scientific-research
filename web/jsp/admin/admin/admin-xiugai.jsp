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
    <%@ include file="/jsp/admin/top.jsp" %>
    <%--=================================== 菜单 ===================================--%>
    <%@ include file="/jsp/admin/menu.jsp" %>
    <%--=================================== 底部 ===================================--%>
    <%@ include file="/jsp/admin/footer.jsp" %>

    <%--=================================== 主体 ===================================--%>
    <div class="layui-body">
        <blockquote class="layui-elem-quote layui-text">
            管理员信息修改页面
        </blockquote>
        <s:form namespace="/" cssClass="layui-form" action="admin_update" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="admin_id" value="%{model.admin_id}"/>
            <s:hidden name="admin_password" value="%{model.admin_password}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">管理员工号</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入姓名" name="admin_username"
                                 value="%{model.admin_username}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">管理员姓名</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入姓名" name="admin_name"
                                 value="%{model.admin_name}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">校区</label>
                <div class="layui-input-block">
                    <s:radio list="#{'新城校区':'新城校区&nbsp&nbsp&nbsp&nbsp;','金川校区':'金川校区'}" name="admin_address" value="%{model.admin_address}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入姓名" name="admin_mobile"
                                 value="%{model.admin_mobile}" required="true"/>
                </div>
            </div>
            <div class="layui-anim layui-anim-fadein">
                <button type="submit"
                        class="layui-anim-fadein layui-btn layui-btn-lg layui-btn-radius layui-btn-normal">提交
                </button>
            </div>
        </s:form>
    </div>

    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script>
        //Demo
        layui.use('form', function () {
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function (data) {
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    </script>
</body>
</html>