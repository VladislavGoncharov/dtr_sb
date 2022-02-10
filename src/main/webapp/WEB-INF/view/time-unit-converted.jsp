<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Конвертируем время</title>
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
    <h2>Тут мы преобразовывать время</h2>
    </span>
    <br>
    <%--@elvariable id="timeUnitConverted" type="com.vladgoncharov.dtr_sb.working_with_a_date.TimeUnitConverter"--%>
    <form:form action="timeUnitConvertedResult" method="get" modelAttribute="timeUnitConverted">
        <fieldset>
            <legend>Заполните форму</legend>
            <br>
            <div>
                <label> Введите число и выберите единицу измерения:
                    <form:input class="input" path="amountOfTime" type="number" min="1" max="1000000000" value="0" placeholder="8728"/>
                </label>
                    <form:select class="dropdown_list" path="UOM">
                        <form:options class="dropdown_list_options" items="${timeUnitConverted.unitsOfMeasurement}"/>
                    </form:select>

            </div>
            <br>
            <input class="button" type="submit" name="Посчитать">
            <input class="button" type="reset" name="Очистить" onclick="window.location.href = 'timeUnitConverted'">
        </fieldset>

    </form:form>
    <br><br>
    <h3>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
    </h3>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>