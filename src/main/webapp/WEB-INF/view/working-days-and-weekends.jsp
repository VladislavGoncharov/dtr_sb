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
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/main.js"></script>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
    <span class="header_2">
       <h2>Тут мы будем считать рабочие и выходные дни</h2>
    <p>Формат даты должен быть такой:
        <mark>30.10.2020</mark>
    </p>
    </span>

    <br>
    <%--@elvariable id="workingDaysAndWeekends" type="com.vladgoncharov.dtr_sb.working_with_a_date.WorkingDaysAndWeekends"--%>
    <form:form action="workingDaysAndWeekendsResult" method="get" modelAttribute="workingDaysAndWeekends">

        <fieldset>
            <legend>Заполните формы по шаблону</legend>
            <br>
            <label>Введите первый рабочий день:
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
    <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
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