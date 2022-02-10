<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <c:if test="${!isSuccessful}">
        <title>Так делать нельзя</title>
    </c:if>
    <c:if test="${!isSuccessful}">
        <title>Превосходно</title>
    </c:if>

    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/main.js"></script>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
        <c:if test="${!isSuccessful}">
            <span class="header_2">
            <h2>Видимо ваш email был введен некорректно, но есть возможность все исправить</h2>
                <button class="button_first_view "
                        type="button" onclick="window.location.href = 'userInfo_${currentUsername}'">
                Мои данные
            </button>
            </span>
        </c:if>
        <c:if test="${isSuccessful}">
            <span class="header_2">
            <h2>Все прошло успешно</h2>
                <button class="button_first_view " type="button" onclick="window.location.href = '/'">
                На главную
            </button>
            </span>
        </c:if>
        <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>