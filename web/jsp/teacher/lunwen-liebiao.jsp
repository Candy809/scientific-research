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
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ocupload-1.1.2.js"></script>
    <script type="text/javascript">
        function to_page(page) {
            if (page) {
                $("#page").val(page);
            }
            document.lwform.submit();
        }
    </script>
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
        <blockquote class="layui-elem-quote">
            论文审核页面，您可以在这里以Excel形式
            <a class="layui-btn"
               href="${pageContext.request.contextPath}/lunwen_tea_exportExcel.action">
                <i class="layui-icon layui-icon-list"></i>导出论文
            </a>
        </blockquote>


        <form action="${pageContext.request.contextPath}/lunwen_getlunwenAll.action" id="lwform" name="lwform"
              method="post">

            <table class="layui-table" lay-even="" lay-skin="nob">
                <tbody>
                <tr>
                    <td>论文名称：</td>
                    <td>
                        <s:textfield cssClass="layui-input" theme="simple" name="lw_name"></s:textfield>
                    </td>
                    <td>论文编号</td>
                    <td>
                        <s:textfield cssClass="layui-input" theme="simple" name="lw_bianhao"></s:textfield>
                    </td>
                    <td>审核条件</td>
                    <td>
                        <s:select theme="simple" list="#{'审核通过':'审核通过','未通过审核':'未通过审核'}" headerKey=""
                                  headerValue="-请选择-"
                                  name="lw_shenhe"></s:select>
                    </td>
                    <td>
                        <input class="layui-btn layui-btn-primary" type="submit" value="查询"/>
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>论文编号</th>
                        <th>论文名称</th>
                        <th>第一作者</th>
                        <th>第二作者</th>
                        <th>是否编入教材</th>
                        <th>刊物名称</th>
                        <th>卷号</th>
                        <th>是否资金资助</th>
                        <th>检索类型</th>
                        <th>审核状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list">
                            <tr>
                                <td><s:property value="lw_bianhao"/></td>
                                <td><s:property value="lw_name"/></td>
                                <td><s:property value="lw_zuozhe1"/></td>
                                <td><s:property value="lw_zuozhe2"/></td>
                                <td><s:property value="lw_jiaocai"/></td>
                                <td><s:property value="lw_kanwu"/></td>
                                <td><s:property value="lw_juanhao"/></td>
                                <td><s:property value="lw_zizhu"/></td>
                                <td><s:property value="lw_jiansuo"/></td>
                                <td><s:property value="lw_shenhe"/></td>

                                <td>
                                    <a class="layui-btn layui-btn-sm"
                                       href="${pageContext.request.contextPath}/lunwen_shenheUI.action?lw_id=<s:property value="lw_id"/>">审核</a>
                                </td>
                            </tr>
                    </s:iterator>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td style="text-align: center">
                            <ul class="pagination pagination-lg">
                                <li>
                                    <a aria-label="Previous">
                                            <span class="layui-badge layui-bg-blue">共<s:property
                                                    value="totalCount"/>条记录</span>
                                        <span class="layui-badge layui-bg-blue"><s:property
                                                value="totalPage"/>页</span>
                                        <span class="layui-badge layui-bg-blue">每页显示<s:property
                                                value="pageSize"/>条记录</span>
                                    </a>
                                </li>

                                <li>
                                    <s:if test="currPage!=1">
                                        <a href="javascript:to_page(1)" aria-label="Previous">
                                            <i class="layui-icon">&#xe603;</i>首页
                                        </a>
                                        <a href="javascript:to_page(<s:property value="currPage-1"/>)">
                                            <i class="layui-icon">&#xe603;</i>前一页
                                        </a>
                                    </s:if>
                                </li>


                                <s:iterator var="i" begin="1" end="totalPage">
                                    <s:if test="#i == currPage">
                                        <li>
                                            <a>
                                                <s:property value="#i"/>
                                            </a>
                                        </li>
                                    </s:if>
                                    <s:else>
                                        <li>
                                            <a href="javascript:to_page(<s:property value="#i"/>)"><s:property
                                                    value="#i"/></a>
                                        </li>
                                    </s:else>
                                </s:iterator>
                                <li>
                                    <s:if test="currPage!=totalPage">
                                        <a href="javascript:to_page(<s:property value="currPage+1"/>)"
                                           aria-label="Next">
                                            <span aria-hidden="true">&raquo;后一页</span>
                                        </a>
                                        <a href="javascript:to_page(<s:property value="totalPage"/>)"
                                           aria-label="Previous">
                                            <span aria-hidden="true">尾页<i class="layui-icon">&#xe602;</i></span>
                                        </a>
                                    </s:if>
                                </li>
                                <input type="text" size="6" id="page" name="currPage" style="display: none"/>
                            </ul>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
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