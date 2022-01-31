<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Новый пользователь</title>
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
        <fieldset>
            <legend>User info ${currentUsername}</legend>
            <br>
            <table>
                <tr>
                    <td>
                        age
                    </td>
                    <td>
                        ${userInfo.age}
                    </td>
                </tr>
                <tr>
                    <td>
                        name
                    </td>
                    <td>
                        ${userInfo.name}
                    </td>
                </tr>
                <tr>
                    <td>
                        surname
                    </td>
                    <td>
                        ${userInfo.surname}
                    </td>
                </tr>
                <tr>
                    <td>
                        email
                    </td>
                    <td>
                        ${userInfo.email}
                    </td>
                </tr>
                <tr>
                    <td>
                        city
                    </td>

                    <td>
                        ${userInfo.city}
                    </td>
                </tr>
                <tr>
                    <td>
                        phone
                    </td>

                    <td>
                        ${userInfo.phone}
                    </td>
                </tr>
                <tr>
                    <td>
                        img
                    </td>
                    <td>
                        ${userInfo.img}
                    </td>
                </tr>
            </table>
        </fieldset>
        <input class="button" type="button" value="update" onclick="window.location.href='/updateUserInfo'"/>

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