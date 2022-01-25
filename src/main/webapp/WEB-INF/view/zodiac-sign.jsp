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
    <title>Узнаем знак зодиака</title>
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
        <h2>Кто я по знаку зодиака?!</h2>
    </span>
    <br>
    <%--@elvariable id="zodiacSign" type="com.vladgoncharov.dtr_sb.working_with_a_date.ZodiacSign"--%>
    <form:form action="zodiacSignResult" method="post" modelAttribute="zodiacSign">

        <fieldset>
            <legend>Заполните формы по шаблону</legend>
            <br>
            <table class="table_forms_working_with_a_date">
                <tbody>
                <tr>
                    <td>
                        <label for="day">Выберите день:</label>
                    </td>
                    <td>
                        <form:select class="dropdown_list" name="day" path="day">
                            <form:options class="dropdown_list_options" items="${zodiacSign.daysOfMonth}"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="month">Выберите месяц:</label>
                    </td>
                    <td>
                        <form:select class="dropdown_list" name="month" path="month">
                            <form:options class="dropdown_list_options" items="${zodiacSign.monthMap}"/>
                        </form:select>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2">
                        <input class="button" type="submit" value="Посчитать">
                        <input class="button" type="reset" value="Очистить"
                               onclick="window.location.href = 'zodiacSign'">
                    </td>
                </tr>
                </tfoot>

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