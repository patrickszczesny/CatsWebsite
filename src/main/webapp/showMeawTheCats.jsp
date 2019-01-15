<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        CATS!!!!!
    </title>
</head>
<body>
<c:forEach var="cat" items="${cats}">
    <c:out value="${cat.name}"/><br>
    <c:out value="${cat.race}"/><br>
    <c:out value="${cat.owner}"/>
</c:forEach>
</body>
</html>