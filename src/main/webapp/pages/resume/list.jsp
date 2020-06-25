<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>简历列表</title>
    <link rel="stylesheet" href="/static/js/layui-v2.3.0/css/layui.css" charset="UTF-8">
    <style>
        .layui-table-header .laytable-cell-1-updateReason{
            margin-left: 120px;
        }
        .layui-table-body .laytable-cell-1-updateReason{
            height: auto;
        }
    </style>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <jsp:include page="../left.jsp" />
        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                <!-- 查询条件 -->
                <form class="layui-form">
                    <div style="padding: 10px 20px 0px 40px">
                        <a id="toCreate" class="layui-btn layui-btn-sm" >新建</a>
                        <a id="toEdit" class="layui-btn layui-btn-sm" >修改</a>
                        <a id="toDelete" class="layui-btn layui-btn-sm" >删除</a>
                    </div>
                </form>

                <!-- 配置列表 -->
                <table class="layui-table" id="resumeList"></table>
            </div>
        </div>
    </div>

    <script src="/static/js/sss/resume/list.js" type="text/javascript" charset="UTF-8"></script>

</body>
</html>
