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

    <%--=================================== 主体 ===================================--%>
    <div class="layui-body">
        <blockquote class="layui-elem-quote layui-text">
            科研分数修改页面
        </blockquote>
        <s:form namespace="/" cssClass="layui-form" action="mark_xs_edit" method="POST" enctype="multipart/form-data"
                theme="simple">
            <s:hidden name="mark_id" value="%{model.mark_id}"/>

            <s:hidden name="lw_mark_zijinzizhu_zizhu" value="%{model.lw_mark_zijinzizhu_zizhu}"/>
            <s:hidden name="lw_mark_zijinzizhu_weizizhu" value="%{model.lw_mark_zijinzizhu_weizizhu}"/>
            <s:hidden name="lw_mark_shenhe_tongguo" value="%{model.lw_mark_shenhe_tongguo}"/>
            <s:hidden name="lw_mark_shenhe_weitongguo" value="%{model.lw_mark_shenhe_weitongguo}"/>

            <s:hidden name="zl_mark_fanwei_guonei" value="%{model.zl_mark_fanwei_guonei}"/>
            <s:hidden name="zl_mark_fanwei_guoji" value="%{model.zl_mark_fanwei_guoji}"/>
            <s:hidden name="zl_mark_zhuangtai_shenqing" value="%{model.zl_mark_zhuangtai_shenqing}"/>
            <s:hidden name="zl_mark_zhuangtai_gongkai" value="%{model.zl_mark_zhuangtai_gongkai}"/>
            <s:hidden name="zl_mark_zhuangtai_shouquan" value="%{model.zl_mark_zhuangtai_shouquan}"/>
            <s:hidden name="zl_mark_zhuangtai_shixiao" value="%{model.zl_mark_zhuangtai_shixiao}"/>
            <s:hidden name="zl_mark_shenhe_tongguo" value="%{model.zl_mark_shenhe_tongguo}"/>
            <s:hidden name="zl_mark_shenhe_weitongguo" value="%{model.zl_mark_shenhe_weitongguo}"/>

            <s:hidden name="ky_mark_leixing_yilei" value="%{model.ky_mark_leixing_yilei}"/>
            <s:hidden name="ky_mark_leixing_erlei" value="%{model.ky_mark_leixing_erlei}"/>
            <s:hidden name="ky_mark_leixing_fudaoyuan" value="%{model.ky_mark_leixing_fudaoyuan}"/>
            <s:hidden name="ky_mark_dengji_guojiaji" value="%{model.ky_mark_dengji_guojiaji}"/>
            <s:hidden name="ky_mark_dengji_shentingji" value="%{model.ky_mark_dengji_shentingji}"/>
            <s:hidden name="ky_mark_dengji_xiaoji" value="%{model.ky_mark_dengji_xiaoji}"/>
            <s:hidden name="ky_mark_shenhe_tongguo" value="%{model.ky_mark_shenhe_tongguo}"/>
            <s:hidden name="ky_mark_shenhe_weitongguo" value="%{model.ky_mark_shenhe_weitongguo}"/>

            <div class="layui-form-item">
                <label class="layui-form-label">国际学术交流</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_leixing_guoji"
                                 value="%{model.xs_mark_leixing_guoji}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">国内学术交流</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_leixing_guonei"
                                 value="%{model.xs_mark_leixing_guonei}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">论文提交</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_lunwen_tijiao"
                                 value="%{model.xs_mark_lunwen_tijiao}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">论文未提交</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_lunwen_weitijiao"
                                 value="%{model.xs_mark_lunwen_weitijiao}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">特邀报告</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_baogao_tijiao"
                                 value="%{model.xs_mark_baogao_tijiao}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">未特邀报告</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_baogao_weitijiao"
                                 value="%{model.xs_mark_baogao_weitijiao}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">资金资助</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_zijinzizhu_zizhu"
                                 value="%{model.xs_mark_zijinzizhu_zizhu}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">未资金资助</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_zijinzizhu_weizizhu"
                                 value="%{model.xs_mark_zijinzizhu_weizizhu}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">审核通过</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_shenhe_tongguo"
                                 value="%{model.xs_mark_shenhe_tongguo}" required="true"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">未通过审核</label>
                <div class="layui-input-block">
                    <s:textfield autocomplete="off" lay-verify="required" cssClass="layui-input"
                                 name="xs_mark_shenhe_weitongguo"
                                 value="%{model.xs_mark_shenhe_weitongguo}" required="true"/>
                </div>
            </div>

            <button type="submit" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal">提交</button>

        </s:form>
    </div>
    <%--=================================== 底部 ===================================--%>
    <%@ include file="/jsp/admin/footer.jsp" %>
    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });
    </script>
</body>
</html>