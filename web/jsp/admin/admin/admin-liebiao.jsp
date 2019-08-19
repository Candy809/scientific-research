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
    <script type="text/javascript">
        function to_page(page) {
            if (page) {
                $("#page").val(page);
            }
            document.adminForm.submit();
        }
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%--=================================== 顶部 ===================================--%>
    <%@ include file="/jsp/admin/top.jsp" %>
    <%--=================================== 菜单 ===================================--%>
    <%@ include file="/jsp/admin/menu.jsp" %>
    <%--=================================== 底部 ===================================--%>
    <%@ include file="/jsp/admin/footer.jsp" %>

    <%--=================================== 主体 ===================================--%>
    <div class="layui-body">
        <blockquote class="layui-elem-quote">
            管理员列表页面，你可以在这里
            <a class="layui-btn layui-btn-warm"
               href="${pageContext.request.contextPath}/admin_saveUI.action">
                <i class="layui-icon layui-icon-add-1"></i>添加管理员
            </a>
            ，或者以Excel形式
            <a class="layui-btn layui-btn"
               href="${pageContext.request.contextPath}/admin_exportExcel.action">
                <i class="layui-icon layui-icon-list"></i>导出管理员
            </a>
        </blockquote>
        <form action="${pageContext.request.contextPath}/admin_findAll.action" id="adminForm" name="adminForm"
              method="post">
            <div class="layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr style="text-align: center">
                        <th>管理员工号</th>
                        <th>管理员姓名</th>
                        <th>校区</th>
                        <th>移动电话</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list">
                        <tr>
                            <td><s:property value="admin_username"/></td>
                            <td><s:property value="admin_name"/></td>
                            <td><s:property value="admin_address"/></td>
                            <td><s:property value="admin_mobile"/></td>
                            <td>
                                <a class="layui-btn layui-btn-sm"
                                   href="${pageContext.request.contextPath}/admin_delete.action?admin_id=<s:property value="admin_id"/>">
                                    <i class="layui-icon layui-icon-delete"></i>删除
                                </a>
                                <a class="layui-btn layui-btn-normal layui-btn-sm"
                                   href="${pageContext.request.contextPath}/admin_edit.action?admin_id=<s:property value="admin_id"/>">
                                    <i class="layui-icon layui-icon-edit"></i>修改
                                </a>
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
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;
        });
    </script>
</body>
</html>