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
        <s:form cssClass="layui-form" namespace="/" method="POST" action="zhuanli_zhuanlishenhe" theme="simple"
                enctype="multipart/form-data">
            <s:hidden name="zl_id" value="%{model.zl_id}"/>
            <s:hidden name="zl_defen" value="%{model.zl_defen}"/>
            <s:hidden name="zl_mingcheng" value="%{model.zl_mingcheng}"/>
            <s:hidden name="zl_leixing" value="%{model.zl_leixing}"/>
            <s:hidden name="zl_dengjibianhao" value="%{model.zl_dengjibianhao}"/>
            <s:hidden name="zl_fanwei" value="%{model.zl_fanwei}"/>
            <s:hidden name="zl_zhuangtai" value="%{model.zl_zhuangtai}"/>
            <s:hidden name="zl_shuming" value="%{model.zl_shuming}"/>
            <s:hidden name="zl_shenqinghao" value="%{model.zl_shenqinghao}"/>
            <s:hidden name="zl_zhiwu" value="%{model.zl_zhiwu}"/>
            <s:hidden name="zl_famingren" value="%{model.zl_famingren}"/>
            <s:hidden name="zl_famingrendanwei" value="%{model.zl_famingrendanwei}"/>
            <s:hidden name="zl_zhuanlifei" value="%{model.zl_zhuanlifei}"/>
            <s:hidden name="zl_zhuanlifeishijian" value="%{model.zl_zhuanlifeishijian}"/>


            <s:hidden name="zl_image" value="%{model.zl_image}"/>
            <s:hidden name="zl_imagename" value="%{model.zl_imagename}"/>
            <s:hidden name="stu_zhuanli_id" value="%{model.stu_zhuanli_id}"/>

            <div class="layui-form-item">
                <label class="layui-form-label">专利名称</label>
                <div class="layui-input-block">
                    <s:textfield type="text" cssClass="layui-input" value="%{model.zl_mingcheng}" lay-verify="title" autocomplete="off" disabled="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">专利类型</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_leixing}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">登记编号</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_dengjibianhao}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">专利范围</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_fanwei}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">专利状态</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_zhuangtai}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">学校署名</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_shuming}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">申请号</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_shenqinghao}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">职务专利</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_zhiwu}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发明人姓名</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_famingren}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">工作单位</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_famingrendanwei}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">专利费金额</label>
                    <div class="layui-input-inline">
                        <s:textfield type="text" cssClass="layui-input" value="%{model.zl_zhuanlifei}" lay-verify="title" autocomplete="off" disabled="true"/>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">相关文件下载</label>
                <div class="layui-input-block">
                    <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/zhuanli_execute.action?fileName=<s:property value="%{model.zl_imagename}"/> ">下载</a>
                </div>
            </div>

            <s:hidden name="zl_shenhe" value="审核通过"/>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">审核通过</button>
                    <s:a cssClass="layui-btn layui-btn-primary" action="zhuanli_getzhuanliAll" namespace="/" theme="simple">审核驳回</s:a>
                </div>
            </div>
            </form>
        </s:form>
    </div>

    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>

</body>
</html>