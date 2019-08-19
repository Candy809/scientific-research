<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>内蒙古工业大学研究生个人成果管理系统用户登录</title>
    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery1.7.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Validform_v5.3.2_min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var $tab_li = $('#tab ul li');
            $tab_li.hover(function () {
                $(this).addClass('selected').siblings().removeClass('selected');
                var index = $tab_li.index(this);
                $('div.tab_box > div').eq(index).show().siblings().hide();
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            /*学生登录信息验证*/
            $("#stu_username_hide").focus(function () {
                var username = $(this).val();
                if (username == '输入学号') {
                    $(this).val('');
                }
            });
            $("#stu_username_hide").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('输入学号');
                }
            });
            $("#stu_password_hide").focus(function () {
                var username = $(this).val();
                if (username == '输入密码') {
                    $(this).val('');
                }
            });
            $("#stu_password_hide").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('输入密码');
                }
            });
            $(".stu_login_error").Validform({
                tiptype: function (msg, o, cssctl) {
                    var objtip = $(".stu_error_box");
                    cssctl(objtip, o.type);
                    objtip.text(msg);
                },
                // ajaxPost: true
            });
            /*导师登录信息验证*/
            $("#tea_username_hide").focus(function () {
                var username = $(this).val();
                if (username == '输入教工号') {
                    $(this).val('');
                }
            });
            $("#tea_username_hide").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('输入教工号');
                }
            });
            $("#tea_password_hide").focus(function () {
                var username = $(this).val();
                if (username == '输入密码') {
                    $(this).val('');
                }
            });
            $("#tea_password_hide").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('输入密码');
                }
            });
            $(".tea_login_error").Validform({
                tiptype: function (msg, o, cssctl) {
                    var objtip = $(".tea_error_box");
                    cssctl(objtip, o.type);
                    objtip.text(msg);
                },
                // ajaxPost: true
            });
            /*教务登录信息验证*/
            $("#sec_username_hide").focus(function () {
                var username = $(this).val();
                if (username == '输入教务号') {
                    $(this).val('');
                }
            });
            $("#sec_username_hide").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('输入教务号');
                }
            });
            $("#sec_password_hide").focus(function () {
                var username = $(this).val();
                if (username == '输入密码') {
                    $(this).val('');
                }
            });
            $("#sec_password_hide").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('输入密码');
                }
            });
            $(".sec_login_error").Validform({
                tiptype: function (msg, o, cssctl) {
                    var objtip = $(".sec_error_box");
                    cssctl(objtip, o.type);
                    objtip.text(msg);
                }
            });
        });


    </script>

</head>

<body>
<div id="tab">
    <ul class="tab_menu">
        <li class="selected">学生登录</li>
        <li>导师登录</li>
        <li>教务登录</li>
    </ul>
    <div class="tab_box">
        <!-- 学生登录开始 -->
        <div>
            <div class="stu_error_box"></div>
            <s:form cssClass="stu_login_error" namespace="/" action="student_login" theme="simple" method="POST">
                <%-- 错误信息回显--%>
                <s:actionerror/>
                <div id="username">
                    <label>学&nbsp;&nbsp;&nbsp;号：</label>
                    <s:textfield type="text" id="stu_username_hide" name="stu_username" value="输入学号" nullmsg="学号不能为空！"
                                 datatype="s6-18" errormsg="学号范围在6~18个字符之间！" sucmsg="学号验证通过！" required="true"/>

                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <s:textfield type="password" id="stu_password_hide" name="stu_password" value="输入密码"
                                 nullmsg="密码不能为空！"
                                 datatype="*6-16" errormsg="密码范围在6~16位之间！" required="true"/>
                </div>
                <div>
                    <tr>
                        <th>
                            <span class="requiredField">*</span>验证码:
                        </th>
                        <td>
                            <span class="fieldSet">
                                <input type="text" id="stu_checkcode" name="stu_checkcode" class="text captcha"
                                       maxlength="4" autocomplete="off"><img id="stu_checkImg" class="captchaImage"
                                                                             src="${pageContext.request.contextPath}/stu_check_execute.action"
                                                                             onclick="change()"
                                                                             title="点击更换验证码">
                            </span>
                        </td>
                    </tr>
                </div>

                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </s:form>
        </div>
        <!-- 学生登录结束-->
        <!-- 导师登录开始-->
        <div class="hide">
            <div class="tea_error_box"></div>
            <s:form cssClass="tea_login_error" method="POST" namespace="/" action="teacher_login" theme="simple">
                <%-- 错误信息回显--%>
                <s:actionerror/>
                <div id="username">
                    <label>教工号：</label>

                    <s:textfield id="tea_username_hide" type="text" name="tea_username" value="输入教工号" nullmsg="教工号不能为空！"
                                 datatype="s6-18" errormsg="教工号范围在6~18个字符之间！" sucmsg="教工号验证通过！" required="true"/>

                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <s:textfield type="password" id="tea_password_hide" name="tea_password" value="输入密码"
                                 nullmsg="密码不能为空！"
                                 datatype="*6-16" errormsg="密码范围在6~16位之间！" required="true"/>
                </div>
                <div>
                    <tr>
                        <th>
                            <span class="requiredField">*</span>验证码:
                        </th>
                        <td>
                            <span class="fieldSet">
                                <input type="text" id="tea_checkcode" name="tea_checkcode" class="text captcha"
                                       maxlength="4" autocomplete="off"><img id="tea_checkImg" class="captchaImage"
                                                                             src="${pageContext.request.contextPath}/tea_check_execute.action"
                                                                             onclick="change()"
                                                                             title="点击更换验证码">
                            </span>
                        </td>
                    </tr>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </s:form>
        </div>
        <!-- 导师登录结束-->
        <!-- 教务登录开始-->
        <div class="hide">
            <div class="sec_error_box"></div>
            <s:form cssClass="sec_login_error" method="POST" namespace="/" action="admin_login" theme="simple">
                <%-- 错误信息回显--%>
                <s:actionerror/>
                <div id="username">
                    <label>教务号：</label>
                    <s:textfield id="sec_username_hide" type="text" name="admin_username" value="输入教务号"
                                 nullmsg="教务号不能为空！"
                                 datatype="s6-18" errormsg="教务号范围在6~18个字符之间！" sucmsg="教务号验证通过！" required="true"/>

                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <s:textfield type="password" id="sec_password_hide" name="admin_password" value="输入密码"
                                 nullmsg="密码不能为空！"
                                 datatype="*6-16" errormsg="密码范围在6~16位之间！" required="true"/>
                </div>
                <div>
                    <tr>
                        <th>
                            <span class="requiredField">*</span>验证码:
                        </th>
                        <td>
                            <span class="fieldSet">
                                <input type="text" id="admin_checkcode" name="admin_checkcode" class="text captcha"
                                       maxlength="4" autocomplete="off"><img id="admin_checkImg" class="captchaImage"
                                                                             src="${pageContext.request.contextPath}/admin_check_execute.action"
                                                                             onclick="change()"
                                                                             title="点击更换验证码">
                            </span>
                        </td>
                    </tr>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </s:form>
        </div>
        <!-- 教务登录结束-->
    </div>
</div>
<%--<s:debug></s:debug>--%>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/0.jpg"></a></li>
        <li><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/1.jpg"></a></li>
        <li><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/2.jpg"></a></li>
    </ul>
</div>
</body>
</html>