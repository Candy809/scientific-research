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
            学术交流信息添加页面
        </blockquote>
        <s:form namespace="/" cssClass="layui-form" action="xueshu_save" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="xs_shenhe" value="未通过审核"/>
            <s:hidden name="xs_defen" value="0"/>
            <s:hidden name="stu_xueshu_id" value="%{#session.student.stu_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">你的名字</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 value="%{#session.student.stu_name}" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">参会人</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入参会人"
                                 name="xs_canhuiren" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">会议名称</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入会议名称"
                                 name="xs_huiyimingcheng" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">主办单位</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入主办单位"
                                 name="xs_zhubandanwei" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">会议类型</label>
                <div class="layui-input-block">
                    <s:radio list="#{'国际':'国际&nbsp&nbsp&nbsp&nbsp','国内':'国内'}" name="xs_huiyileixing" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学科门类</label>
                <div class="layui-input-block">
                    <s:radio list="#{'社科类':'社科类&nbsp&nbsp&nbsp&nbsp','理工类':'理工类'}" name="xs_xuekemenlei" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">参会地址</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入参会地址"
                                 name="xs_canhuidizhi" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">提交论文</label>
                <div class="layui-input-block">
                    <s:radio list="#{'是':'是&nbsp&nbsp&nbsp&nbsp;','否':'否'}" name="xs_tijiaolunwen" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">特邀报告</label>
                <div class="layui-input-block">
                    <s:radio list="#{'是':'是&nbsp&nbsp&nbsp&nbsp','否':'否'}" name="xs_teyaobaogao" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">论文题目</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入论文题目"
                                 name="xs_lunwentimu" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">报告题目</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入报告题目"
                                 name="xs_baogaotimu" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">基金资助</label>
                <div class="layui-input-block">
                    <s:radio list="#{'是':'是&nbsp&nbsp&nbsp&nbsp','否':'否'}" name="xs_zijinzizhu" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">资助金额</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入资助金额"
                                 name="xs_zizhujine" required="true"/>
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