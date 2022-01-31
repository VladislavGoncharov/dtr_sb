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
            <%--@elvariable id="userInfo" type="com.vladgoncharov.dtr_sb.entity.AppUserInfo"--%>
            <form:form action="userInfo_${currentUsername}" method="post" modelAttribute="userInfo">
                <form:hidden path="id"/>
                <form:hidden path="checkingEmail"/>
                <table>
                    <tr>
                        <td>
                            Возраст:
                        </td>
                        <td>
                            <form:input path="age"/>
                            <form:errors path="age"/>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            Имя
                        </td>
                        <td>
                            <form:input path="name"/>
                            <form:errors path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            surname
                        </td>
                        <td>
                            <form:input path="surname"/>
                            <form:errors path="surname"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            email
                        </td>
                        <td>
                            <form:input path="email"/>
                            <form:errors path="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            city
                        </td>
                        <td>
                            <form:input path="city"/>
                            <form:errors path="city"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            phone
                        </td>

                        <td>
                            <form:input path="phone"/>
                            <form:errors path="phone"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            img
                        </td>
                        <td>
                            <form:input path="img"/>
                        </td>
                    </tr>
                </table>

                <input type="submit" value="OK">
            </form:form>

        </fieldset>
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