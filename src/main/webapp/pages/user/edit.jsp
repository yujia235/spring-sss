<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改用户</title>
    <link rel="stylesheet" href="/static/js/layui-v2.3.0/css/layui.css" charset="UTF-8">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-body" style="left: 0px; overflow: auto">
        <!-- 内容主体区域 -->
        <div style="width: 500px">
            <form class="layui-form" action="" lay-filter="">
                <div class="layui-form-item" hidden>
                    <div class="layui-input-block">
                        <input type="text" id="id_text" value="${user.id}" lay-verify="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" id="app_id_text" value="${user.userName}" disabled required
                               style="background-color: #F2F2F2;" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="text" id="app_name_cn_text" value="${user.passWord}" required  autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">生日</label>
                    <div class="layui-input-block">
                        <input type="text" id="app_name_en_text" value="${user.birthday}" required autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="editConfig" class="layui-btn" lay-submit lay-filter="*">修改</button>
                        <button type="reset" class="layui-btn">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../../static/js/sss/user/edit.js" charset="UTF-8"></script>
</body>
</html>
