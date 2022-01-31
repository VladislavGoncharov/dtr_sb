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
    <script src="../../resources/js/current_time.js"></script>

</head>
<body>
<header>
    <br>
    <div>
        <a class="header_1" href="/">Добро пожаловать на DateTimeResult.ru</a>
    </div>
    <div id="current_date_time_block">
    </div>
</header>
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
</body>
<footer>
    <br>
    <dl>
        <dt>
            Связь с разработчиком:
        </dt>
        <dd>
            <a href="https://vk.com/veyvik87" target="_blank">Вконтакте</a>
        </dd>
        <dd>
            <a href="mailto:veyvik87@gmail.com?subject=Приглашаю вас на работу Junior Java Developer" target="_blank">Gmail</a>
        </dd>
    </dl>
</footer>
</html>