layui.use(['table', 'form', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , laydate = layui.laydate;

    /**
     * 监听查询条件提交
     */
    form.on('submit()', function (data) {
        return false;
    });

    /**
     * 渠道列表数据展示
     */
    table.render({
        elem: '#resumeList'
        , url: '/resume/list'
        , method: 'post'
        , id: 'list'
        , request: {
            pageName: 'pageNo' // 页码的参数名称，默认：page
            , limitName: 'pageSize' // 每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'code' // 数据状态的字段名称，默认：code
            , code: 0 // 成功的状态码，默认：0
            , msgName: 'msg' // 状态信息的字段名称，默认：msg
            , countName: 'count' // 数据总数的字段名称，默认：count
            , dataName: 'data' // 数据列表的字段名称，默认：data
        }
        , page: { // 支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] // 自定义分页布局
            , curr: 1 // 设定初始在第 1 页
            , groups: 5 // 只显示5个连续页码
            , first: '首页' // 显示首页
            , last: '尾页' // 显示尾页
            , limit: 10 // 每页显示的条数
            , limits: [10, 20, 30, 40, 50] // 每页条数的选择项
        }
        , cols: [[
            {type: 'checkbox', width: 30, align: 'center'}
            , {field: 'id', width: 50, title: 'ID', sort: true, type: 'numbers', align: 'center'}
            , {field: 'name', width: 140, title: '姓名', align: 'center'}
            , {field: 'address', width: 150, title: '地址', align: 'center'}
            , {field: 'phone', width: 150, title: '电话', align: 'center'}
        ]]
        // , width: 1200
        , height: 480
        , even: true
        , done: function (res, curr, count) {
        }
    });

    /**
     * 修改处理
     */
    $("#toEdit").on('click', function () {
        // list即为基础参数id对应的值
        var checkRow = table.checkStatus('list');
        // 选中行校验
        if (checkRow == undefined || checkRow.data.length < 1) {
            layer.open({
                title: '提示信息'
                , content: '请选中一行数据！'
            });
            return;
        } else if (checkRow.data.length > 1) {
            layer.open({
                title: '提示信息'
                , content: '不能选中选中多行数据！'
            });
            return;
        }

        // 修改
        $.post('toEdit', {id: checkRow.data[0].id}, function (str) {
            layer.open({
                title: ['修改简历', 'color:#009688;font-size:15px;'],
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['900px', '600px'], //宽高
                content: str, //注意，如果str是object，那么需要字符拼接。
                success: function (layero, index) {
                    form.render();
                    console.log(layero, index);
                }
            });
        });
    });

    /**
     * 删除
     */
    $("#toDelete").on('click', function () {
        // list即为基础参数id对应的值
        var checkRow = table.checkStatus('list');
        // 选中行校验
        if (checkRow == undefined || checkRow.data.length < 1) {
            layer.open({
                title: '提示信息'
                , content: '请选中一行数据！'
            });
            return;
        } else if (checkRow.data.length > 1) {
            layer.open({
                title: '提示信息'
                , content: '不能选中选中多行数据！'
            });
            return;
        }
        checkRow.data[0].id

        // 删除
        $.ajax({
            type: 'POST',
            url: 'delete',
            data: {id:checkRow.data[0].id},
            dataType: 'json',
            contentType: 'application/x-www-form-urlencoded',
            success: function (data) {
                if (data) {
                    if (data.code == 0) {
                        layer.open({
                            title: '提示信息'
                            , content: '删除成功！'
                            , yes: function (index, layero) {
                                window.location.reload();
                            }
                        });
                    } else if (data.statusCode == 1) {
                        layer.open({
                            title: '提示信息'
                            , content: '删除失败，' + data.message + '！'
                            , yes: function (index, layero) {
                                layer.close(index);
                            }
                        });
                    } else {
                        layer.open({
                            title: '提示信息'
                            , content: '删除失败，请稍后重试！'
                            , yes: function (index, layero) {
                                layer.close(index);
                            }
                        });
                    }
                } else {
                    layer.open({
                        title: '提示信息'
                        , content: '删除失败，请稍后重试！'
                        , yes: function (index, layero) {
                            layer.close(index);
                        }
                    });
                }
            },
            error: function (data) {
                layer.open({
                    title: '提示信息'
                    , content: '删除失败，请稍后重试！'
                    , yes: function (index, layero) {
                        layer.close(index);
                    }
                });
            }
        });
    });

    /**
     * 新建处理
     */
    $("#toCreate").on('click', function () {
        // 新建
        $.get('toCreate', function (str) {
            layer.open({
                title: ['新建简历', 'color:#009688;font-size:15px;'],
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['900px', '600px'], //宽高
                content: str, //注意，如果str是object，那么需要字符拼接。
                success: function (layero, index) {
                    form.render();
                    console.log(layero, index);
                }
            });
        });
    });
});