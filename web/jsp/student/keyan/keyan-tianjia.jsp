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
        <blockquote class="layui-elem-quote layui-text">
            科研信息添加页面
        </blockquote>
        <s:form namespace="/" cssClass="layui-form" action="keyan_save" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="ky_shenhe" value="未通过审核"/>
            <s:hidden name="ky_defen" value="0"/>
            <s:hidden name="stu_keyan_id" value="%{#session.student.stu_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">你的名字</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 value="%{#session.student.stu_name}" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目编号</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入项目编号"
                                 name="ky_bianhao" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目名称</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入项目名称"
                                 name="ky_mingcheng" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目负责人</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入项目负责人"
                                 name="ky_fuzeren" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目来源</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入项目来源"
                                 name="ky_laiyuan" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目类型</label>
                <div class="layui-input-block">
                    <s:radio
                            list="#{'一类':'一类&nbsp;&nbsp;&nbsp;&nbsp;','二类':'二类&nbsp;&nbsp;&nbsp;&nbsp;','辅导员专项':'辅导员专项'}"
                            name="ky_leixing" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目等级</label>
                <div class="layui-input-block">
                    <s:radio list="#{'国家级':'国家级&nbsp;&nbsp;&nbsp;&nbsp;','省厅级':'省厅级&nbsp;&nbsp;&nbsp;&nbsp;','校级':'校级'}"
                             name="ky_dengji" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目经费</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入项目总经费"
                                 name="ky_jingfei" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">主要任务</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 placeholder="请输入主要承担的任务"
                                 name="ky_renwu" required="true"/>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">文件上传</label>
                <input type="file" name="upload">
                <span class="layui-badge-rim">请选择文件</span>
            </div>

            <button type="submit" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal">提交</button>

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