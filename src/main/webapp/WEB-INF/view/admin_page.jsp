<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Секретное место</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/main.js"></script>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
    <span class="header_2">
        <h2>Admin</h2>
    </span>
        <ul>
            <%--            <security:authorize access="hasAnyRole('ADMIN')">--%>
            <li>
                <button class="button_first_view" type="button"
                        onclick="window.location.href = 'registrationModerator'">
                    Добавить модератора
                </button>
            </li>
            <li>
                <button class="button_first_view" type="button" onclick="window.location.href = 'showMODERATOR'">
                    Список всех модераторов
                </button>
                <span class="button_first_view">
                ${numberOfModerators}
                </span>
            </li>
            <%--            </security:authorize>--%>
            <li>
                <button class="button_first_view" type="button" onclick="window.location.href = 'showUSER'">
                    Список всех пользователей
                </button>
                <span class="button_first_view">
                    ${numberOfUsers}
                </span>

            </li>
        </ul>


        <br><br>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
        <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>