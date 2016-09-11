<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css"
    href="<c:url value="/resources/css/city_list.css"/>">
<title>城市列表</title>
</head>
<body>

    <div id="header">
        <div id="headerinside">
            <a href="http://www.58.com/">
                <img src="<c:url value="/resources/images/logo.gif" />" id="logo"/>
            </a>
            <div id="postgg">
                免费发布/查询 租房、二手房、招聘求职、二手车、二手市场、<br>
                宠物买卖、家政保洁、休闲娱乐 等本地生活信息。
            </div>
            <div id="flashimg">
                <img src="<c:url value="/resources/images/city_1.gif" />" style="opacity: 1;"/>
                <img src="<c:url value="/resources/images/city_2.gif" />" style="opacity: 0.5;"/>
            </div>
        </div>
    </div>
    <dl id="clist">
        <c:forEach items="${map }" var="entry">
            <dt>${entry.key }</dt>
            <dd>
                <c:forEach items="${entry.value }" var="city">
                    <td><a
                        href="${pageContext.request.contextPath }/house?cid=${city.id }">${city.name }</a></td>
                </c:forEach>
            </dd>
        </c:forEach>
    </dl>

    <script type="text/javascript">
        var oFimg = document.getElementById("flashimg");
        var oarray = oFimg.getElementsByTagName("img");
        var imgnum = oarray.length -1;
    	function fout() {
    	    var o = oarray[imgnum];
    	    if (o != null) {
    	        if (o.style.opacity == null || o.style.opacity == '') {
    	            o.style.opacity = 1;
    	        }
    	        
    	        var opacitynum = o.style.opacity;
    	        if (opacitynum < 0.11) {
    	            o.style.display = 'none';
    	            o.parentNode.insertBefore(o, oarray[0]);
    	            o.style.display = '';
    	            o.style.filter = '';
    	            o.style.opacity = 1;
    	            setTimeout('fout()', 3000);
    	            return;
    	        } else {
    	            o.style.filter = 'alpha(opacity:' + (opacitynum * 100 - 10) + ')';
    	            o.style.opacity = opacitynum - 0.1;
    	            setTimeout('fout()', 50);
    	        }
    	    }
    	}
    	fout();
    </script>
</body>
</html>