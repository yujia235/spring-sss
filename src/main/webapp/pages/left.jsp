<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-layout layui-layout-admin">
    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="left">
                <c:forEach items="${sessionScope.userFunc}" var="item">
                    <c:if test="${item.funcType eq 0 }">

                        <c:set var="contains" value="no" />
                        <c:forEach var="it" items="${sessionScope.menuNode }">
                            <c:if test="${it eq item.funcId }">
                                <c:set var="contains" value="yes" />
                            </c:if>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${contains=='yes' }">
                                <li class="layui-nav-item layui-nav-itemed">
                            </c:when>
                            <c:otherwise>
                                <li class="layui-nav-item">
                            </c:otherwise>
                        </c:choose>

                            <a class="menuNode" href="javascript:;" id="${item.funcId}" onclick="nodeStatus(this.id)">${item.funcName}<span class="layui-nav-more"></span></a>
                            <dl class="layui-nav-child" >
                                <c:forEach items="${sessionScope.userFunc}" var="itemChild">
                                    <c:if test="${itemChild.funcType eq 1 and itemChild.funcPid eq item.funcId}">
                                        <dd id="itemChild">
                                            <a href="${itemChild.funcUrl}" lay-href="">${itemChild.funcName}</a>
                                        </dd>
                                    </c:if>
                                </c:forEach>
                            </dl>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<script src="/static/js/jquery.min.js" type="text/javascript" charset="UTF-8"></script>
<script src="/static/js/common.js" type="text/javascript" charset="UTF-8"></script>
<script src="/static/js/layui-v2.3.0/layui.js" type="text/javascript" charset="UTF-8"></script>
<script>
    layui.use('element', function(){
        var $ = layui.jquery;
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(left)', function(elem){

        });
    });

    function nodeStatus(id) {
        if (typeof id == "undefined" || id == null || id == "") {
            return;
        }
        var attrClass = $("[id='"+id+"']").parent().attr("class");
        var isOpen=0;
        if (attrClass == "layui-nav-item") {
            //节点打开
            isOpen=1;
        }
        $.get("/xxx"+id+"/"+isOpen);
    }
</script>