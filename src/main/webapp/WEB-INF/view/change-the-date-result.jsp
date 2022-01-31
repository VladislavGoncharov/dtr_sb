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

<body>
<header>
    <br>
    <div>
        <a  class="header_1" href="/" >Добро пожаловать на DateTimeResult.ru</a>
    </div>
    <div id="current_date_time_block">
    </div>
</header>
<main>
    <article>
    <br>
    <table class="table_result">
        <tbody>
        <tr>
        <td colspan="2">
                ${dateDifference.year} ${dateDifference.textYear} ${dateDifference.month} ${dateDifference.textMonth}
            ${dateDifference.day} ${dateDifference.textDay}
        </td>
        </tr>
        <tr>
            <td>
                В месяцах:
            </td>
            <td>
                ${dateDifference.resultInMonths}
            </td>
        </tr>
        <tr>
            <td>
                В днях:
            </td>
            <td>
                ${dateDifference.resultInDays}
            </td>
        </tr>
        <tr>
            <td>
                В часах:
            </td>
            <td>
                ${dateDifference.resultInHours}
            </td>
        </tr>
        <tr>
            <td>
                В минутах:
            </td>
            <td>
                ${dateDifference.resultInMinutes}
            </td>
        </tr>
        <tr>
            <td>
                В секундах:
            </td>
            <td>
                ${dateDifference.resultInSeconds}
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