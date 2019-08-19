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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<%--=================================== 顶部 ===================================--%>
    <%@ include file="/jsp/admin/top.jsp"%>
<%--=================================== 菜单 ===================================--%>
    <%@ include file="/jsp/admin/menu.jsp"%>

<%--=================================== 主体 ===================================--%>
    <div class="layui-body">
        <blockquote class="layui-elem-quote">
            论文分数列表
        </blockquote>

            <div class="layui-form">
                <table class="layui-table">
                    <thead>
                    <tr style="text-align: center">
                        <th>获得资金资助</th>
                        <th>未获得资金资助</th>
                        <th>审核通过</th>
                        <th>审核未通过</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="marks">
                        <tr>
                            <td><s:property value="lw_mark_zijinzizhu_zizhu"/></td>
                            <td><s:property value="lw_mark_zijinzizhu_weizizhu"/></td>
                            <td><s:property value="lw_mark_shenhe_tongguo"/></td>
                            <td><s:property value="lw_mark_shenhe_weitongguo"/></td>
                            <td>
                                <a class="layui-btn layui-btn-normal layui-btn-sm"
                                   href="${pageContext.request.contextPath}/mark_lw_editUI.action?mark_id=<s:property value="mark_id"/>">
                                    <i class="layui-icon layui-icon-edit"></i>修改
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>

        <blockquote class="layui-elem-quote">
            科研项目分数列表
        </blockquote>
            <div class="layui-form">
                <table class="layui-table">
                    <thead>
                    <tr style="text-align: center">
                        <th>类型：一类</th>
                        <th>类型：二类</th>
                        <th>类型：辅导员专项</th>
                        <th>等级：国家级</th>
                        <th>等级：省厅级</th>
                        <th>等级：校级</th>
                        <th>审核通过</th>
                        <th>未通过审核</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="marks">
                        <tr>
                            <td><s:property value="ky_mark_leixing_yilei"/></td>
                            <td><s:property value="ky_mark_leixing_erlei"/></td>
                            <td><s:property value="ky_mark_leixing_fudaoyuan"/></td>
                            <td><s:property value="ky_mark_dengji_guojiaji"/></td>
                            <td><s:property value="ky_mark_dengji_shentingji"/></td>
                            <td><s:property value="ky_mark_dengji_xiaoji"/></td>
                            <td><s:property value="ky_mark_shenhe_tongguo"/></td>
                            <td><s:property value="ky_mark_shenhe_weitongguo"/></td>
                            <td>
                                <a class="layui-btn layui-btn-normal layui-btn-sm"
                                   href="${pageContext.request.contextPath}/mark_ky_editUI.action?mark_id=<s:property value="mark_id"/>">
                                    <i class="layui-icon layui-icon-edit"></i>修改
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>

        <blockquote class="layui-elem-quote">
            学术交流分数列表
        </blockquote>

            <div class="layui-form">
                <table class="layui-table">
                    <thead>
                    <tr style="text-align: center">
                        <th>国际会议</th>
                        <th>国内会议</th>
                        <th>提交论文</th>
                        <th>未提交论文</th>
                        <th>特邀报告</th>
                        <th>未特邀报告</th>
                        <th>资金资助</th>
                        <th>未资金资助</th>
                        <th>审核通过</th>
                        <th>未通过审核</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="marks">
                        <tr>
                            <td><s:property value="xs_mark_leixing_guoji"/></td>
                            <td><s:property value="xs_mark_leixing_guonei"/></td>
                            <td><s:property value="xs_mark_lunwen_tijiao"/></td>
                            <td><s:property value="xs_mark_lunwen_weitijiao"/></td>
                            <td><s:property value="xs_mark_baogao_tijiao"/></td>
                            <td><s:property value="xs_mark_baogao_weitijiao"/></td>
                            <td><s:property value="xs_mark_zijinzizhu_zizhu"/></td>
                            <td><s:property value="xs_mark_zijinzizhu_weizizhu"/></td>
                            <td><s:property value="xs_mark_shenhe_tongguo"/></td>
                            <td><s:property value="xs_mark_shenhe_weitongguo"/></td>
                            <td>
                                <a class="layui-btn layui-btn-normal layui-btn-sm"
                                   href="${pageContext.request.contextPath}/mark_xs_editUI.action?mark_id=<s:property value="mark_id"/>">
                                    <i class="layui-icon layui-icon-edit"></i>修改
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>

        <blockquote class="layui-elem-quote">
            专利信息分数列表
        </blockquote>
            <div class="layui-form">
                <table class="layui-table">
                    <thead>
                    <tr style="text-align: center">
                        <th>国际专利</th>
                        <th>国内专利</th>
                        <th>专利申请</th>
                        <th>专利公开</th>
                        <th>专利授权</th>
                        <th>专利失效</th>
                        <th>审核通过</th>
                        <th>未通过审核</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="marks">
                        <tr>
                            <td><s:property value="zl_mark_fanwei_guonei"/></td>
                            <td><s:property value="zl_mark_fanwei_guoji"/></td>
                            <td><s:property value="zl_mark_zhuangtai_shenqing"/></td>
                            <td><s:property value="zl_mark_zhuangtai_gongkai"/></td>
                            <td><s:property value="zl_mark_zhuangtai_shouquan"/></td>
                            <td><s:property value="zl_mark_zhuangtai_shixiao"/></td>
                            <td><s:property value="zl_mark_shenhe_tongguo"/></td>
                            <td><s:property value="zl_mark_shenhe_weitongguo"/></td>
                            <td>
                                <a class="layui-btn layui-btn-normal layui-btn-sm"
                                   href="${pageContext.request.contextPath}/mark_zl_editUI.action?mark_id=<s:property value="mark_id"/>">
                                    <i class="layui-icon layui-icon-edit"></i>修改
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
    </div>
<%--=================================== 底部 ===================================--%>
    <%@ include file="/jsp/admin/footer.jsp"%>
<%--=================================== 分割线 ===================================--%>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>