<jsp:useBean id="workingDaysAndWeekends" scope="request" type="com.vladgoncharov.dtr_sb.working_with_a_date.WorkingDaysAndWeekends"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Посчитали :)</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/main.js"></script>

<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
        <table class="table_result">
            <caption><h2>Календарь рабочих и выходных дней</h2></caption>
            <thead>
            <th>
                Пн
            </th>
            <th>
                Вт
            </th>
            <th>
                Ср
            </th>
            <th>
                Чт
            </th>
            <th>
                Пт
            </th>
            <th>
                Сб
            </th>
            <th>
                Вс
            </th>
            </thead>
            <tbody>
            <c:forEach items="${workingDaysAndWeekends.numberOfWeeks}">
                <tr>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                    <td class="td_${workingDaysAndWeekends.dayFromList}">
                            ${workingDaysAndWeekends.dayFromList}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <th colspan="7">Закрашенные ячейки означают ваши трудовые будни</th>
            </tr>
            </tfoot>
        </table>
        <br>
        <br>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
        <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>