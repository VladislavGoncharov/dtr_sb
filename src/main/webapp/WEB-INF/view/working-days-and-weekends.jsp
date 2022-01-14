<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Считаем рабочие и выходные дни</title>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

</head>
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
       <h2>Тут мы будем считать рабочие и выходные дни</h2>
    <p>Формат даты должен быть такой:
        <mark>30.10.2020</mark>
    </p>
    </span>

    <br>
    <%--@elvariable id="workingDaysAndWeekends" type="com.vladgoncharov.dtr_sb.working_with_a_date.WorkingDaysAndWeekends"--%>
    <form:form action="workingDaysAndWeekendsResult" modelAttribute="workingDaysAndWeekends">

        <fieldset>
            <legend>Заполните формы по шаблону</legend>
            <br>
            <label>Введите дату начала отчета:
                <form:input class="input" path="dateString" placeholder="30.12.2020" maxlength="10"/>
                <form:errors path="dateString"/>
            </label>
            <br><br>
            <label>Введите количество ваших рабочих дней:
               <form:select class="dropdown_list" path="numberOfWorkingDays">
                   <form:options class="dropdown_list_options" items="${workingDaysAndWeekends.numbersFromOneToFifteen_1}"/>
               </form:select>
            </label>
            <br><br>
            <label>Введите количество ваших выходных дней:
                <form:select class="dropdown_list" path="numberOfWeekends">
                    <form:options class="dropdown_list_options" items="${workingDaysAndWeekends.numbersFromOneToFifteen_2}"/>
                </form:select>
            </label>
            <br><br>
            <input class="button" type="submit" value="Посчитать">
            <input class="button" type="reset" value="Очистить" onclick="window.location.href = 'workingDaysAndWeekends'">
        </fieldset>

    </form:form>
    <br><br>
    <input class="button" type="button" value="Назад" onclick="window.location.href = '/'"/>
    <hr>

</main>

</body>
</html>