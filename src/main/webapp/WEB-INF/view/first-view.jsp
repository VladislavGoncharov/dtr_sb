<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DateTimeResult</title>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.png"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>
</head>

<body>

<header>
    <nav></nav>
    <br>
    <div>
        <h1>Добро пожаловать на DateTimeResult.ru</h1>
    </div>
    <div id="current_date_time_block"
         style="color:black;font-weight: bolder; font-size: calc(1em + 1vh);margin: 1.5% 4%;
                text-shadow: 2px 3px 10px white,-2px -3px 10px white,2px -3px 10px white,-2px 3px 10px white">
    </div>
</header>
<main>
    <br>
    <security:authorize access="isAnonymous()==false">
        Здравствуйте, ${userName}
        <a href="<c:url value="/logout" />">ВЫХОД</a>
    </security:authorize>
    <security:authorize access="isAnonymous()==true">
        Привет, ${userName}
        <a href="/login">ВХОД</a>
    </security:authorize>

    <br>
    <br>


    <br>
    <ul>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'changeTheDate'">
                Посчитать количество дней в промежутке    ONLY FOR USER
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'changeTheTime'">
                Прибавить (отнять) время    ONLY FOR ADMIN
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'timeUnitConverted'">
                Конвертируем время
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'workingDaysAndWeekends'">
                <span>Расчет не стандартных рабочих и выходных дней
                </span>
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'registration'">
                <span>Regist
                </span>
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'login'">
                <span>Login
                </span>
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'admin'">
                <span>Admin
                </span>
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view" type="button" onclick="window.location.href = 'userInfo'">
                <span>info
                </span>
            </button>
            <br>
        </li>
    </ul>

</main>

<footer>
    <br>
    <dl>
        <dt>
            Контакты с разработчиком:
        </dt>
        <dd>
            <a href="https://vk.com/veyvik87" target="_blank">Вконтакте</a>
        </dd>
        <dd>
            <a href="mailto:veyvik87@gmail.com?subject=Приглашаю вас на работу Junior Java Developer" target="_blank">Gmail</a>
        </dd>
    </dl>
</footer>
</body>
</html>