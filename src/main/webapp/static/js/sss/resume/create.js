layui.use(['tree', 'form'], function () {
    var form = layui.form
        , $ = layui.$;

    /**
     * 新建处理
     */
    form.on('submit(*)', function (data) {
        var createresumeData = {
            name: $("#name").val(),
            address: $("#address").val(),
            phone: $("#phone").val()
        };
        console.log('createresumeData=' + JSON.stringify(createresumeData));

        // 新建请求
        $.ajax({
            type: 'POST',
            url: 'create',
            data: createresumeData,
            dataType: 'json',
            contentType: 'application/x-www-form-urlencoded',
            success: function (data) {
                if (data) {
                    if (data.code == 0) {
                        layer.open({
                            title: '提示信息'
                            , content: '新建成功！'
                            , yes: function (index, layero) {
                                window.location.reload();
                            }
                        });
                    } else if (data.statusCode == 1) {
                        layer.open({
                            title: '提示信息'
                            , content: '新建失败，' + data.message + '！'
                            , yes: function (index, layero) {
                                layer.close(index);
                            }
                        });
                    } else {
                        layer.open({
                            title: '提示信息'
                            , content: '新建失败，请稍后重试！'
                            , yes: function (index, layero) {
                                layer.close(index);
                            }
                        });
                    }
                } else {
                    layer.open({
                        title: '提示信息'
                        , content: '新建失败，请稍后重试！'
                        , yes: function (index, layero) {
                            layer.close(index);
                        }
                    });
                }
            },
            error: function (data) {
                layer.open({
                    title: '提示信息'
                    , content: '新建失败，请稍后重试！'
                    , yes: function (index, layero) {
                        layer.close(index);
                    }
                });
            }
        });
    });
});