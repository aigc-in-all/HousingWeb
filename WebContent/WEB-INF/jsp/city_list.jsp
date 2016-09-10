<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
    <table border="1" align="center" style="text-align: center">
        <c:forEach items="${map }" var="entry">
            <tr>
                <td colspan="20"><strong>${entry.key }</strong></td>
            </tr>
            <tr>
                <c:forEach items="${entry.value }" var="city">
                    <td><a href="${pageContext.request.contextPath }/house?cid=${city.id }">${city.name }</a></td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>