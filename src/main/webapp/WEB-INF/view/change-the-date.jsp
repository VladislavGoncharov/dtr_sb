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
        <h2>Тут мы будем считать дни</h2>
    <p>Формат даты должен быть такой:
        <mark>30.10.2020</mark>
    </p>
    </span>

    <br>
    <%--@elvariable id="dateDifference" type="com.vladgoncharov.dtr_sb.working_with_a_date.DateDifference"--%>
    <form:form action="changeTheDateResult" method="get" modelAttribute="dateDifference">

        <fieldset>
            <legend>Заполните формы по шаблону</legend>
            <br>
            <label>Введите первую дату:
                <form:input class="input" path="firstDateString" placeholder="30.12.2020"/>
                <form:errors path="firstDateString"/>
            </label>
            <br><br>
            <label>Введите вторую дату:
                <form:input class="input" path="secondDateString" placeholder="05.02.2084"/>
                <form:errors path="secondDateString"/>
            </label>
            <br><br>
            <input class="button" type="reset" value="Очистить" onclick="window.location.href = 'changeTheDate'">
            <input class="button" type="submit" value="Посчитать">
        </fieldset>

    </form:form>
    <br><br>
    <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>