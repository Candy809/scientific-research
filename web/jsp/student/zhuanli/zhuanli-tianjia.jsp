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
            专利信息添加页面
        </blockquote>
        <s:form namespace="/" cssClass="layui-form" action="zhuanli_save" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="zl_shenhe" value="未通过审核"/>
            <s:hidden name="zl_defen" value="0"/>
            <s:hidden name="stu_zhuanli_id" value="%{#session.student.stu_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">你的名字</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 value="%{#session.student.stu_name}" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专利名称</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入专利名称"
                                 name="zl_mingcheng" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专利类型</label>
                <div class="layui-input-block">
                    <s:radio
                            list="#{'发明专利':'发明专利&nbsp;&nbsp;&nbsp;&nbsp;','实用新型':'实用新型&nbsp;&nbsp;&nbsp;&nbsp;','外观设计':'外观设计&nbsp;&nbsp;&nbsp;&nbsp;','其他知识产权':'其他知识产权&nbsp;&nbsp;&nbsp;&nbsp;','计算机软件登记':'计算机软件登记'}"
                            name="zl_leixing" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">登记编号</label>
                <div class="layui-input-block">
                    <s:radio
                            list="#{'A':'A&nbsp;&nbsp;&nbsp;&nbsp;','B':'B&nbsp;&nbsp;&nbsp;&nbsp;','C':'C'}"
                            name="zl_dengjibianhao" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专利范围</label>
                <div class="layui-input-block">
                    <s:radio list="#{'国内':'国内&nbsp;&nbsp;&nbsp;&nbsp;','国外':'国外'}"
                             name="zl_fanwei" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专利状态</label>
                <div class="layui-input-block">
                    <s:radio
                            list="#{'专利申请':'专利申请&nbsp;&nbsp;&nbsp;&nbsp;','专利公开':'专利公开&nbsp;&nbsp;&nbsp;&nbsp;','专利授权':'专利授权&nbsp;&nbsp;&nbsp;&nbsp;','专利失效':'专利失效'}"
                            name="zl_zhuangtai" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学校署名</label>
                <div class="layui-input-block">
                    <s:radio list="#{'第一单位':'第一单位&nbsp;&nbsp;&nbsp;&nbsp;','非第一单位':'非第一单位'}"
                             name="zl_shuming" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">申请号</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入申请号"
                                 name="zl_shenqinghao" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">职务专利</label>
                <div class="layui-input-block">
                    <s:radio list="#{'是':'是&nbsp;&nbsp;&nbsp;&nbsp;','否':'否'}"
                             name="zl_zhiwu" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">发明人姓名</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入发明人姓名"
                                 name="zl_famingren" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">工作单位</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入发明人工作单位"
                                 name="zl_famingrendanwei" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专利费金额</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input" placeholder="请输入专利费支付金额"
                                 name="zl_zhuanlifei" required="true"/>
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