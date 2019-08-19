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
        <blockquote class="layui-elem-quote">
            学术交流图表信息展示：
        </blockquote>
        <div id="main" style="width:auto;height:400px;"></div>

    </div>
    <%--=================================== 分割线 ===================================--%>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var myChart = echarts.init(document.getElementById('main'));
            // 显示标题，图例和空的坐标轴
            myChart.setOption({
                title: {
                    text: '学术交流得分情况'
                },
                    xAxis: {
                        type: 'category',
                        data: []
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: [],
                        type: 'line',
                        smooth: true
                    }]
            });

            var names = [];
            var nums = [];
            myChart.showLoading();
            $.ajax({
                url: '${pageContext.request.contextPath}/xueshu_tubiao.action',
                type: 'post',
                ContentType: 'application/json;charset=utf-8',
                dataType: 'json',
                success: function (result) {
                    myChart.hideLoading();
                    $.each(result, function (i, n) {
                        names.push(result[i].xs_huiyimingcheng);
                        nums.push(result[i].xs_defen);
                    });
                    myChart.setOption({
                        xAxis: [
                            {
                                type: 'category',
                                data: names
                            }
                        ],
                        series: [{
                            data: nums,
                            type: 'line',
                            smooth: true
                        }]
                    });
                },
                error: function (msg) {
                    alert('错误');
                }
            });
        })
    </script>
</body>
</html>