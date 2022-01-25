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
    <title>Регистрация нового пользователя</title>
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
    <div id="current_date_time_block"
         style="color:black;font-weight: bolder; font-size: calc(1em + 1vh);margin: 1.5% 4%;
                text-shadow: 2px 3px 10px white,-2px -3px 10px white,2px -3px 10px white,-2px 3px 10px white">
    </div>
</header>
<main>
    <article>
    <span class="header_2">
        <h2>Регистрация нового пользователя</h2>
    </span>
    <br>
    <%--@elvariable id="user" type="com.vladgoncharov.dtr_sb.entity.AppUser"--%>
    <form:form action="registration" method="post" modelAttribute="user">
        <fieldset>
            <legend>Заполните формы</legend>
            <br>
            <table>
                <form:hidden path="userId"/>
                <tr>
                    <td>
                        <label for="userName">Введите логин:</label>
                    </td>
                    <td>
                        <form:input class="input" type="text" path="userName" name="userName" maxlength="36"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="textError">
                        <form:errors path="userName"/>
                        ${exceptionUserName}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Введите пароль:</label>
                    </td>
                    <td>
                        <form:input class="input" type="password" path="encrytedPassword"
                                    name="password" maxlength="128"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"class="textError">
                        <form:errors path="encrytedPassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="passwordCheck">Подтвердите пароль:</label>
                    </td>
                    <td>
                        <form:input class="input" type="password" path="encrytedPasswordCheck"
                                    name="passwordCheck" maxlength="128"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="textError">
                                ${exceptionPasswordCheck}
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="button" type="submit" value="Добавить">
                        <input class="button" type="reset" value="Очистить"
                               onclick="window.location.href = 'registration'">
                    </td>
                </tr>
            </table>
            <br>
        </fieldset>
    </form:form>
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