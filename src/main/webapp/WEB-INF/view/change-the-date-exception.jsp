<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Проблема :(</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

<body>
<header>
    <br>
    <div>
        <a class="header_1" href="/">Добро пожаловать на DateTimeResult.ru</a>
    </div>
    <div id="current_date_time_block"
         style="color:black;font-weight: bolder; font-size: calc(1em + 1vh);margin: 1.5% 4%;
                text-shadow: 2px 3px 10px white,-2px -3px 10px white,2px -3px 10px white,-2px 3px 10px white">
    </div>
</header>
<main>
    <article>
    <br>
    <span class="header_2">
            <h2>Видимо вы совершили ошибку при вводе даты, попробуйте ещё раз</h2>

    </span>

    <dl>
        <dt>Наиболее частые ошибки:</dt>
        <dd>
            <ul>
                <li>"00" такого месяца и числа в месяце нет</li>
                <li>Не всегда в месяце 31 день и даже не всегда 30 ;)</li>
                <li>Не нужно использовать буквы при вводе дат </li>
                <li>Ещё раз напоминаю про чудесный месяц февраль</li>
            </ul>
        </dd>
    </dl>


    <br><br><br><br>
    <input class="button" type="button" value="Попробовать ещё раз" onclick="history.back();return false;"/>
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