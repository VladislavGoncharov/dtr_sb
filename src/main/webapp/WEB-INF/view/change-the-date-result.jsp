<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Посчитали :)</title>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

<body>
<header>
    <br>
    <div>
        <a  class="header_1" href="/" >Добро пожаловать на DateTimeResult.ru</a>
    </div>
    <div id="current_date_time_block"
         style="color:black;font-weight: bolder; font-size: calc(1em + 1vh);margin: 1.5% 4%;
                text-shadow: 2px 3px 10px white,-2px -3px 10px white,2px -3px 10px white,-2px 3px 10px white">
    </div>
</header>
<main>
    <br>
    <dl>
        <dt>
            <b>
                Ваш результат: ${dateDifference.year} ${dateDifference.textYear}, ${dateDifference.month} ${dateDifference.textMonth},
                ${dateDifference.day} ${dateDifference.textDay}
            </b>
        </dt>
        <dd>
            Ваш результат в месяцах: ${dateDifference.resultInMonths}
        </dd>
        <dd>
            Ваш результат в днях: ${dateDifference.resultInDays}
        </dd>
        <dd>
            Ваш результат в часах: ${dateDifference.resultInHours}
        </dd>
        <dd>
            Ваш результат в минутах: ${dateDifference.resultInMinutes}
        </dd>
        <dd>
            Ваш результат в секундах: ${dateDifference.resultInSeconds}
        </dd>

    </dl>
    <br>

        <input class="button" type="button" value="Назад" onclick="window.location.href = 'changeTheDate'"/>

    <hr>
</main>

</body>
</html>