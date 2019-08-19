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
        <s:form cssClass="layui-form" namespace="/" method="POST" action="xueshu_xueshushenhe" theme="simple"
                enctype="multipart/form-data">
            <s:hidden name="xs_id" value="%{model.xs_id}"/>
            <s:hidden name="xs_shenhe" value="%{model.xs_shenhe}"/>
            <s:hidden name="xs_canhuiren" value="%{model.xs_canhuiren}"/>
            <s:hidden name="xs_huiyimingcheng" value="%{model.xs_huiyimingcheng}"/>
            <s:hidden name="xs_zhubandanwei" value="%{model.xs_zhubandanwei}"/>
            <s:hidden name="xs_huiyileixing" value="%{model.xs_huiyileixing}"/>
            <s:hidden name="xs_xuekemenlei" xs_xuekemenlei="%{model.xs_xuekemenlei}"/>
            <s:hidden name="xs_canhuidizhi" value="%{model.xs_canhuidizhi}"/>
            <s:hidden name="xs_tijiaolunwen" value="%{model.xs_tijiaolunwen}"/>
            <s:hidden name="xs_teyaobaogao" value="%{model.xs_teyaobaogao}"/>
            <s:hidden name="xs_lunwentimu" value="%{model.xs_lunwentimu}"/>
            <s:hidden name="xs_baogaotimu" value="%{model.xs_baogaotimu}"/>
            <s:hidden name="xs_huiyijianjie" value="%{model.xs_huiyijianjie}"/>
            <s:hidden name="xs_zijinzizhu" value="%{model.xs_zijinzizhu}"/>
            <s:hidden name="xs_zizhujine" value="%{model.xs_zizhujine}"/>

            <s:hidden name="xs_image" value="%{model.xs_image}"/>
            <s:hidden name="xs_imagename" value="%{model.xs_imagename}"/>
            <s:hidden name="stu_xueshu_id" value="%{model.stu_xueshu_id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">会议名称</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.xs_huiyimingcheng}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">参会人</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_canhuiren}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">主办单位</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_zhubandanwei}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">会议类型</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_huiyileixing}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">学科门类</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_xuekemenlei}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">参会地址</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_canhuidizhi}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">论文提交</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_tijiaolunwen}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">特邀报告</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_teyaobaogao}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">论文题目</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_lunwentimu}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">报告题目</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_baogaotimu}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">会议简介</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_huiyijianjie}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">基金资助</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_zijinzizhu}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">资助金额</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.xs_zizhujine}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">相关文件下载</label>
                <div class="layui-input-block">
                    <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/xueshu_execute.action?fileName=<s:property value="%{model.xs_imagename}"/> ">下载</a>
                </div>
            </div>

            <s:hidden name="xs_shenhe" value="审核通过"/>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">审核通过</button>
                    <s:a cssClass="layui-btn layui-btn-primary" action="xueshu_getxueshuAll" namespace="/" theme="simple">审核驳回</s:a>
                </div>
            </div>
            </form>
        </s:form>
    </div>

    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>

</body>
</html>