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
            论文信息修改页面
        </blockquote>
        <s:actionerror/>
        <s:fielderror/>
        <s:form namespace="/" cssClass="layui-form" action="lunwen_update" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="lw_id" value="%{model.lw_id}"/>
            <s:hidden name="lw_defen" value="%{model.lw_defen}"/>
            <s:hidden name="lw_image" value="%{model.lw_image}"/>
            <s:hidden name="lw_imagename" value="%{model.lw_imagename}"/>
            <s:hidden name="lw_shenhe" value="%{model.lw_shenhe}"/>
            <s:hidden name="lw_bianhao" value="%{model.lw_bianhao}"/>
            <s:hidden name="lw_name" value="%{model.lw_name}"/>
            <s:hidden name="stu_lunwen_id" value="%{model.stu_lunwen_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">论文编号</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 value="%{model.lw_bianhao}" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">论文名称</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 value="%{model.lw_name}" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">第一作者</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" name="lw_zuozhe1"
                                 value="%{model.lw_zuozhe1}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">第二作者</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" name="lw_zuozhe2"
                                 value="%{model.lw_zuozhe2}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">论文页码</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" name="lw_yema"
                                 value="%{model.lw_yema}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">资金资助</label>
                <div class="layui-input-block">
                    <s:radio list="#{'是':'是&nbsp&nbsp&nbsp&nbsp','否':'否'}" name="lw_zizhu" value="%{model.lw_zizhu}"
                             required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">检索类型</label>
                <div class="layui-input-block">
                    <s:radio
                            list="#{'SCI':'SCI&nbsp&nbsp&nbsp&nbsp','EI':'EI&nbsp&nbsp&nbsp&nbsp','ISTP':'ISTP&nbsp&nbsp&nbsp&nbsp','CSCD':'CSCD&nbsp&nbsp&nbsp&nbsp'}"
                            name="lw_jiansuo" value="%{model.lw_jiansuo}" required="true"/>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">刊物名称</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" name="lw_kanwu"
                                 value="%{model.lw_kanwu}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">卷号</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" name="lw_juanhao"
                                 value="%{model.lw_juanhao}" required="true"/>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">文件上传</label>
                <input type="file" name="upload">
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