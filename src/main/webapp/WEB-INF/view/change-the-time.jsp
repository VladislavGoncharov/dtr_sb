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
    <title>Считаем время</title>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.ico"/>
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
    <span class="header_2">
       <h2>Тут мы будем считать время</h2>
    </span>

    <br>
    <%--@elvariable id="timeDifference" type="com.vladgoncharov.dtr_sb.working_with_a_date.TimeDifference"--%>
    <form:form action="changeTheTimeResult" modelAttribute="timeDifference">

        <fieldset>
            <legend>Заполните форму</legend>
            <br>
            <label for="for_label_time">Введите начальное время:</label>
            <div id="for_label_time">
                <form:input class="input" type="number" path="hours" min="0" max="23"
                            placeholder="12"/>
                <label>:
                    <form:input class="input" type="number" path="minutes" min="0" max="59"
                                placeholder="30"/>
                </label>
                <label>:
                    <form:input class="input" type="number" path="seconds" min="0" max="59"
                                placeholder="00"/>
                </label>
            </div>
            <br>
            <div class="radio_button RBL">
                <form:radiobutton path="plusMinus" value="0" label="Прибавить ( + )"/>
            </div>
            <div class="radio_button RBR">
                <form:radiobutton path="plusMinus" value="1" label="Отнять ( - )"/>
            </div>
            <br>
            <br>
            <label for="for_div">Введите число и выберите единицу измерения:</label>
            <div id="for_div">
                <form:input class="input" type="number" path="amountOfTime" min="0"
                            max="1000000000"/>
                <form:errors path="amountOfTime"/>

                <form:select class="dropdown_list" path="HMS">
                    <form:options class="dropdown_list_options" items="${timeDifference.mapHMS}"/>
                </form:select>
            </div>
            <br>
            <input class="button" type="submit" value="Посчитать">
            <input class="button" type="reset" value="Очистить" onclick="window.location.href = 'changeTheTime'">
        </fieldset>


    </form:form>
    <br><br>
    <h3>
        <input class="button" type="button" value="Назад" onclick="window.location.href = '/'"/>
    </h3>
    <hr>
</main>

</body>
</html>