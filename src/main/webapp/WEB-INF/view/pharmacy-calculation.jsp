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
    <title>Считаем выручку</title>
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
        <h2>Тут ты сможешь узнать выручку</h2>
    </span>

        <br>
        <%--@elvariable id="pharmacyCalculation" type="com.vladgoncharov.dtr_sb.working_with_a_date.PharmacyCalculation"--%>
        <form:form action="pharmacyCalculationResult" method="get" modelAttribute="pharmacyCalculation">

            <fieldset>
                <legend>Заполните формы по шаблону</legend>
                <br>
                <label>Введите сумму выручки:
                    <form:input class="input" type="number" path="amountOfRevenue" placeholder="876100" min="0"/>
                </label>
                <br><br>
                <label>Введите сумму СТМ:
                    <form:input class="input" type="number" path="amountOfSTM" placeholder="102500" min="0"/>
                </label>
                <br><br>
                <input class="button" type="reset" value="Очистить" onclick="window.location.href = 'pharmacyCalculation'">
                <input class="button"  type="submit" value="Посчитать">
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