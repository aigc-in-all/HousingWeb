<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="<c:url value="/resources/css/house_list.css"/>" />
<title>Insert title here</title>
</head>
<body>

    <div class="main">
        <ul class="list">
            <c:forEach items="${list }" var="house">
                <li>
                    <a  href="${house.url }" target="_blank">
                        <div class="img">
                            <img src="${house.img }" />
                        </div>
                        <div class="des">
                            <h2>${house.rentType } ${house.buildRegion } ${house.buildName } ${house.rentRoom }</h2>
                            <p class="room">
                                ${house.houseType } ${house.houseArea } ${house.houseFloor }
                            </p>
                        </div>
                        <div class="money">
                            <span><b>${house.rentPrice }</b>元/月</span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="page">
        <c:if test="${curPage ne '1' }">
            <a href="${pageContext.request.contextPath }/house?cid=${cityId}&page=${curPage - 1}" class="prev"><span>上一页</span></a>
        </c:if>

        <c:forEach items="${pages }" var="page">
            <c:if test="${curPage eq page }">
                    <strong>${page }</strong>
            </c:if>
            <c:if test="${curPage ne page }">
                <a href="${pageContext.request.contextPath }/house?cid=${cityId}&page=${page}"><span>${page }</span></a>
            </c:if>
        </c:forEach>
        <c:if test="${curPage ne pageSize}">
            <a href="${pageContext.request.contextPath }/house?cid=${cityId}&page=${curPage + 1}" class="next"><span>下一页</span></a>
        </c:if>
    </div>
    
</body>
</html>