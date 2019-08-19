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
        <s:form cssClass="layui-form" namespace="/" method="POST" action="lunwen_lunwenshenhe" theme="simple"
                enctype="multipart/form-data">
            <s:hidden name="lw_id" value="%{model.lw_id}"/>
            <s:hidden name="lw_defen" value="%{model.lw_defen}"/>
            <s:hidden name="lw_bianhao" value="%{model.lw_bianhao}"/>
            <s:hidden name="lw_name" value="%{model.lw_name}"/>
            <s:hidden name="lw_zuozhe1" value="%{model.lw_zuozhe1}"/>
            <s:hidden name="lw_zuozhe2" value="%{model.lw_zuozhe2}"/>
            <s:hidden name="lw_kanwu" value="%{model.lw_kanwu}"/>
            <s:hidden name="lw_juanhao" value="%{model.lw_juanhao}"/>
            <s:hidden name="lw_jiansuo" value="%{model.lw_jiansuo}"/>
            <s:hidden name="lw_jiaocai" value="%{model.lw_jiaocai}"/>
            <s:hidden name="lw_zizhu" value="%{model.lw_zizhu}"/>
            <s:hidden name="lw_image" value="%{model.lw_image}"/>
            <s:hidden name="lw_imagename" value="%{model.lw_imagename}"/>
            <s:hidden name="stu_lunwen_id" value="%{model.stu_lunwen_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">论文编号</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.lw_bianhao}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">论文名称</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.lw_name}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">第一作者</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.lw_zuozhe1}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">第二作者</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.lw_zuozhe2}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">刊物名称</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.lw_kanwu}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">卷号</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.lw_juanhao}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">检索类型</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.lw_jiansuo}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">编入教材</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.lw_jiaocai}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">资金资助</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.lw_zizhu}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">相关文件下载</label>
                <div class="layui-input-block">
                    <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/lunwen_execute.action?fileName=<s:property value="%{model.lw_imagename}"/> ">下载</a>
                </div>
            </div>

            <s:hidden name="lw_shenhe" value="审核通过"/>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">审核通过</button>
                    <s:a cssClass="layui-btn layui-btn-primary" action="lunwen_getlunwenAll" namespace="/" theme="simple">审核驳回</s:a>
                </div>
            </div>
            </form>
        </s:form>
    </div>

    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>

</body>
</html>