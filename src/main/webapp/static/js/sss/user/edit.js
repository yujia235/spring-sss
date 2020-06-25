layui.use(['tree', 'form'], function () {
    var form = layui.form
        , $ = layui.$;

    form.verify({
        // 应用中文名
        verifyAppNameCn: function (value, item) {
            if (!value || !value.trim()) {
                return '应用中文名不能为空';
            }
            // 中文|英文|数字|下划线
            if (!new RegExp('^[\u4E00-\u9FA5A-Za-z0-9_]+$').test(value)) {
                return '应用中文名不能有特殊字符';
            }
        },

        // 应用英文名
        verifyAppNameEn: function (value, item) {
            if (!value || !value.trim()) {
                return '应用英文名不能为空';
            }
            // 英文|数字|下划线
            if (!new RegExp('^[A-Za-z0-9_]+$').test(value)) {
                return '应用英文名不能有特殊字符';
            }
        }
    });

    /**
     * 修改处理
     */
    form.on('submit(*)', function (data) {
        var configAppEditData = {
            id: $("#id_text").val(),
            appNameCn: $("#app_name_cn_text").val(),
            appNameEn: $("#app_name_en_text").val()
        };
        console.log('configAppEditData=' + JSON.stringify(configAppEditData));

        // 修改请求
        $.ajax({
            type: 'POST',
            url: 'update',
            data: configAppEditData,
            dataType: 'json',
            contentType: 'application/x-www-form-urlencoded',
            success: function (data) {
                if (data) {
                    if (data.statusCode == 0) {
                        layer.open({
                            title: '提示信息'
                            , content: '修改成功！'
                            , yes: function (index, layero) {
                                window.location.reload();
                            }
                        });
                    } else if (data.statusCode == 1) {
                        layer.open({
                            title: '提示信息'
                            , content: '修改失败，' + data.message + '！'
                            , yes: function (index, layero) {
                                layer.close(index);
                            }
                        });
                    } else {
                        layer.open({
                            title: '提示信息'
                            , content: '修改失败，请稍后重试！'
                            , yes: function (index, layero) {
                                layer.close(index);
                            }
                        });
                    }
                } else {
                    layer.open({
                        title: '提示信息'
                        , content: '修改失败，请稍后重试！'
                        , yes: function (index, layero) {
                            layer.close(index);
                        }
                    });
                }
            },
            error: function (data) {
                layer.open({
                    title: '提示信息'
                    , content: '修改失败，请稍后重试！'
                    , yes: function (index, layero) {
                        layer.close(index);
                    }
                });
            }
        });
    });
});