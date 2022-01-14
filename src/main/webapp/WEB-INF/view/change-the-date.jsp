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
    <title>Считаем дни</title>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.png"/>
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
    <div id="current_date_time_block"
         style="color:black;font-weight: bolder; font-size: calc(1em + 1vh);margin: 1.5% 4%;
                text-shadow: 2px 3px 10px white,-2px -3px 10px white,2px -3px 10px white,-2px 3px 10px white">
    </div>
</header>
<main>
    <span class="header_2">
        <h2>Тут мы будем считать дни</h2>
    <p>Формат даты должен быть такой:
        <mark>30.10.2020</mark>
    </p>
    </span>

    <br>
    <%--@elvariable id="dateDifference" type="com.vladgoncharov.dtr_sb.working_with_a_date.DateDifference"--%>
    <form:form action="changeTheDateResult" modelAttribute="dateDifference">

        <fieldset>
            <legend>Заполните формы по шаблону</legend>
            <br>
            <label>Введите первую дату:
                <form:input class="input" path="firstDateString" placeholder="30.12.2020"/>
                <form:errors path="firstDateString"/>
            </label>
            <br><br>
            <label>Введите вторую дату:
                <form:input class="input"  id="secondDate" path="secondDateString" placeholder="05.02.2084"/>
                <form:errors path="secondDateString"/>
            </label>
            <br><br>
            <input class="button" type="submit" value="Посчитать">
            <input class="button" type="reset" value="Очистить" onclick="window.location.href = 'changeTheDate'">
        </fieldset>

    </form:form>
    <br><br>
    <input class="button" type="button" value="Назад" onclick="window.location.href = '/'"/>
    <hr>

</main>
</body>
</html>