<jsp:useBean id="dateDifference" scope="request" type="com.vladgoncharov.dtr_sb.working_with_a_date.DateDifference"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
    <br>
    <table class="table_result">
        <tbody>
        <tr>
        <td>
               Между
        </td>
        <td>
                ${dateDifference.firstDateString}
        </td>
        </tr>
        <tr>
        <td>
                И
        </td>
        <td>
                ${dateDifference.secondDateString}
        </td>
        </tr>
        <tr>
        <td colspan="2" class="td_big_font_size">
                ${dateDifference.year} ${dateDifference.textYear} ${dateDifference.month} ${dateDifference.textMonth}
            ${dateDifference.day} ${dateDifference.textDay}
        </td>
        </tr>
        <tr>
            <td>
                В месяцах:
            </td>
            <td>
                ${dateDifference.resultInMonths}
            </td>
        </tr>
        <tr>
            <td>
                В днях:
            </td>
            <td>
                ${dateDifference.resultInDays}
            </td>
        </tr>
        <tr>
            <td>
                В часах:
            </td>
            <td>
                ${dateDifference.resultInHours}
            </td>
        </tr>
        <tr>
            <td>
                В минутах:
            </td>
            <td>
                ${dateDifference.resultInMinutes}
            </td>
        </tr>
        <tr>
            <td>
                В секундах:
            </td>
            <td>
                ${dateDifference.resultInSeconds}
            </td>
        </tr>
        </tbody>
    </table>
    <br>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>