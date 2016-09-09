<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <td>图片</td>
            <td>名称</td>
            <td>区域</td>
            <td>类型</td>
            <td>面积</td>
            <td>楼层</td>
            <td>类型</td>
            <td>房间</td>
            <td>价格</td>
        </tr>
        <c:forEach items="${list }" var="house">
            <tr>
                <td><img src="${house.img }" style="width: 120px; height: 80px;" /></td>
                <td><a href="${house.url }" target="_blank">${house.buildName }</a></td>
                <td>${house.buildRegion }</td>
                <td>${house.houseType }</td>
                <td>${house.houseArea }</td>
                <td>${house.houseFloor }</td>
                <td>${house.rentType }</td>
                <td>${house.rentRoom }</td>
                <td>${house.rentPrice }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>