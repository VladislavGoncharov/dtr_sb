<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Посчитали :)</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

</head>
<body>
<header>
    <br>
    <div>
        <a  class="header_1" href="/" >Добро пожаловать на DateTimeResult.ru</a>
    </div>
    <div id="current_date_time_block">
    </div>
</header></header>
<main>
    <article>
    <br>
    <table class="table_result">
        <tbody>
        <tr>
            <td colspan="2">
                Результат в
            </td>
        </tr>
        <tr>
            <td>
                годах:
            </td>
            <td>
                ${timeUnitConverted.years}
            </td>
        </tr>
        <tr>
            <td>
                неделях:
            </td>
            <td>
                ${timeUnitConverted.weeks}
            </td>
        </tr>
        <tr>
            <td>
                днях:
            </td>
            <td>
                ${timeUnitConverted.days}
            </td>
        </tr>
        <tr>
            <td>
                часах:
            </td>
            <td>
                ${timeUnitConverted.hours}
            </td>
        </tr>
        <tr>
            <td>
                минутах:
            </td>
            <td>
                ${timeUnitConverted.minutes}
            </td>
        </tr>
        <tr>
            <td>
                секундах:
            </td>
            <td>
                ${timeUnitConverted.seconds}
            </td>
        </tr>
        </tbody>
    </table>
    <br>
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