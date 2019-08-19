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
    <%@ include file="/jsp/teacher/top.jsp" %>
    <%--=================================== 菜单 ===================================--%>
    <%@ include file="/jsp/teacher/menu.jsp" %>
    <%--=================================== 底部 ===================================--%>
    <%@ include file="/jsp/teacher/footer.jsp" %>

    <%--=================================== 主体 ===================================--%>
    <div class="layui-body">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>论文信息审核页面</legend>
        </fieldset>
        <s:form cssClass="layui-form" namespace="/" method="POST" action="keyan_keyanshenhe" theme="simple"
                enctype="multipart/form-data">
            <s:hidden name="ky_id" value="%{model.ky_id}"/>
            <s:hidden name="ky_defen" value="%{model.ky_defen}"/>
            <s:hidden name="ky_bianhao" value="%{model.ky_bianhao}"/>
            <s:hidden name="ky_mingcheng" value="%{model.ky_mingcheng}"/>
            <s:hidden name="ky_fuzeren" value="%{model.ky_fuzeren}"/>
            <s:hidden name="ky_laiyuan" value="%{model.ky_laiyuan}"/>
            <s:hidden name="ky_leixing" value="%{model.ky_leixing}"/>
            <s:hidden name="ky_dengji" value="%{model.ky_dengji}"/>
            <s:hidden name="ky_jingfei" value="%{model.ky_jingfei}"/>
            <s:hidden name="ky_renwu" value="%{model.ky_renwu}"/>
            <s:hidden name="ky_image" value="%{model.ky_image}"/>
            <s:hidden name="ky_imagename" value="%{model.ky_imagename}"/>
            <s:hidden name="stu_keyan_id" value="%{model.stu_keyan_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">项目编号</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.ky_bianhao}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">项目名称</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.ky_mingcheng}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">项目负责人</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.ky_fuzeren}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">项目来源</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.ky_laiyuan}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">项目类型</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.ky_leixing}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">项目等级</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.ky_dengji}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">项目总经费</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.ky_jingfei}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">主要任务</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.ky_renwu}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">相关文件下载</label>
                <div class="layui-input-block">
                    <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/keyan_execute.action?fileName=<s:property value="%{model.ky_imagename}"/> ">下载</a>
                </div>
            </div>

            <s:hidden name="ky_shenhe" value="审核通过"/>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">审核通过</button>
                    <s:a cssClass="layui-btn layui-btn-primary" action="keyan_getlunwenAll" namespace="/" theme="simple">审核驳回</s:a>
                </div>
            </div>
            </form>
        </s:form>
    </div>

    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>

</body>
</html>