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

</head>
<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
    <br>
    <table class="table_result">
        <tbody>
        <tr>
            <td colspan="2">
                Результат в
            </td>
        </tr>
        <tr>
            <td>
                годах:
            </td>
            <td>
                ${timeUnitConverted.years}
            </td>
        </tr>
        <tr>
            <td>
                неделях:
            </td>
            <td>
                ${timeUnitConverted.weeks}
            </td>
        </tr>
        <tr>
            <td>
                днях:
            </td>
            <td>
                ${timeUnitConverted.days}
            </td>
        </tr>
        <tr>
            <td>
                часах:
            </td>
            <td>
                ${timeUnitConverted.hours}
            </td>
        </tr>
        <tr>
            <td>
                минутах:
            </td>
            <td>
                ${timeUnitConverted.minutes}
            </td>
        </tr>
        <tr>
            <td>
                секундах:
            </td>
            <td>
                ${timeUnitConverted.seconds}
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