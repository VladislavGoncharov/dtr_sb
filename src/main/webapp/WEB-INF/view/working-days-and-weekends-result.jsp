<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Посчитали :)</title>
    <link rel="shortcut icon" href="../../resources/images/shortcut-timer.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

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
    <br>
    <table>
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
            <tr>
                <td class="td_${workingDaysAndWeekends.dayFromList}" >
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
        </tbody>
        <tfoot>
            <tr>
                <th colspan="7">Закрашенные ячейки означают ваши трудовые будни</th>
            </tr>
        </tfoot>
    </table>
    <br>
    <br>

    <input class="button" type="button" value="Назад" onclick="window.location.href = 'workingDaysAndWeekends'"/>

    <hr>
</main>

</body>
</html>