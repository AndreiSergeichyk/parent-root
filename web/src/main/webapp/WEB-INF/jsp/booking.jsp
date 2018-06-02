<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Жанры:</h1>
<div>
    <div>
        <c:forEach items="${requestScope.genres}" var="genre">
            <br><a href="${pageContext.request.contextPath}/books?genreId=${genre.id}" ${genre.name}></a>
        </c:forEach>
    </div>
    <div>
        <c:forEach items="${requestScope.books}" var="book">
            <br>${book.name}
        </c:forEach>
    </div>
    <form name="paginationOption" action="${pageContext.request.contextPath}/books" method="post">
        <br>Страница:
        <select name="numberPage">
            <option selected>1</option>
            <option>2</option>
            <option>3</option>
        </select>
        <br>Колличество элементов на странице:
        <select name="limit">
            <option selected>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
        <br><input class="paginationButton" type="submit" value="Поиск"/>
    </form>
</div>
</body>
</html>
