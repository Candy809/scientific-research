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
            学生信息修改页面
        </blockquote>
        <s:actionerror/>
        <s:fielderror/>
        <s:form namespace="/" cssClass="layui-form" action="student_update" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="stu_id" value="%{model.stu_id}"/>
            <s:hidden name="stu_password" value="%{model.stu_password}"/>

            <div class="layui-form-item">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" name="stu_username" value="%{model.stu_username}"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入姓名" name="stu_name"
                                 value="%{model.stu_name}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <s:radio list="#{'男':'男&nbsp&nbsp&nbsp&nbsp;','女':'女'}" name="stu_gender" value="%{model.stu_gender}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">校区</label>
                <div class="layui-input-block">
                    <s:radio list="#{'新城校区':'新城校区&nbsp&nbsp&nbsp&nbsp;','金川校区':'金川校区'}" name="stu_address" value="%{model.stu_address}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入年龄" name="stu_age"
                                 value="%{model.stu_age}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入电话" name="stu_mobile"
                                 value="%{model.stu_mobile}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入邮箱" name="stu_email"
                                 value="%{model.stu_email}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">QQ</label>
                <div class="layui-input-block">
                    <s:textfield lay-verify="required" cssClass="layui-input" placeholder="请输入QQ" name="stu_qq"
                                 value="%{model.stu_qq}" required="true"/>
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