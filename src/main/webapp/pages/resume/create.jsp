<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>新建简历</title>
    <link rel="stylesheet" href="/static/js/layui-v2.3.0/css/layui.css" charset="UTF-8">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-body" style="left: 0px; overflow: auto">
        <!-- 内容主体区域 -->
        <div style="width: 500px">
            <form class="layui-form" action="" lay-filter="">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" value="" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-block">
                        <input type="text" id="address" value="" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">电话</label>
                    <div class="layui-input-block">
                        <input type="text" id="phone" value="" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="createConfig" class="layui-btn" lay-submit lay-filter="*">新建</button>
                        <button type="reset" class="layui-btn">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="../../static/js/sss/resume/create.js" charset="UTF-8"></script>

</body>
</html>
