function dateFormat(date, fmt) {
    if (undefined == date || "" == date || null == date) {
        return "";
    }
    fmt = fmt || 'yyyy-MM-dd HH:mm:ss';
    date = new Date(Number(date));
    var o = {
        "M+": date.getMonth() + 1, // 月份
        "d+": date.getDate(), // 日
        "H+": date.getHours(), // 小时
        "m+": date.getMinutes(), // 分
        "s+": date.getSeconds(), // 秒
        "q+": Math.floor((date.getMonth() + 3) / 3), // 季度
        "S": date.getMilliseconds()   // 毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k  in  o)
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    return fmt;
}

function stringToDate(string, fmt) {
    fmt = fmt || 'yyyy-MM-dd';

    if (string == undefined || string == "") {
        return null;
    }
    else if (fmt == 'yyyy-MM-dd') {
        return new Date(string.replace(/-/, "/"));
    }
    else {
        var str = string.split(" ");
        var date = str[0].split('-');
        return new Date(date[0], date[1] - 1, date[2]);
    }
}

function get3MonthBefore() {
    var nowYear, nowMonth, nowDate;
    var currDate = new Date();
    nowYear = currDate.getFullYear();
    nowMonth = currDate.getMonth() + 1;
    nowDate = currDate.getDate();

    endTime = nowYear + '-' + nowMonth + '-' + nowDate

    var arr = endTime.split('-');
    var year = arr[0]; //获取当前日期的年份
    var month = arr[1]; //获取当前日期的月份
    var day = arr[2]; //获取当前日期的日
    var days = new Date(year, month, 0);
    days = days.getDate(); //获取当前日期中月的天数
    var year2 = year;
    var month2 = parseInt(month) - 3;
    if (month2 <= 0) {
        year2 = parseInt(year2) - 1;
        month2 = 12 + parseInt(month) - 3;
    }
    var day2 = day;
    var days2 = new Date(year2, month2, 0);
    days2 = days2.getDate();
    if (day2 > days2) {
        day2 = days2;
    }
    if (month2 < 10) {
        month2 = '0' + month2;
    }
    startTime = year2 + '-' + month2 + '-' + day2;
}

String.prototype.startWith = function (str) {
    var reg = new RegExp("^" + str);
    return reg.test(this);
}
String.prototype.endWith = function (str) {
    var reg = new RegExp(str + "$");
    return reg.test(this);
}
String.prototype.replaceAll = function (s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}

// 加载接待组树
var selectedGroupId = "";
var selectedGroupName = "";

// 递归实现一个深拷贝
function deepClone(source){
    if(!source || typeof source !== 'object'){
        throw new Error('error arguments', 'shallowClone');
    }
    var targetObj = source.constructor === Array ? [] : {};
    for(var keys in source){
        if(source.hasOwnProperty(keys)){
            if(source[keys] && typeof source[keys] === 'object'){
                targetObj[keys] = source[keys].constructor === Array ? [] : {};
                targetObj[keys] = deepClone(source[keys]);
            }else{
                targetObj[keys] = source[keys];
            }
        }
    }
    return targetObj;
}