<jsp:useBean id="pharmacyCalculation" scope="request" type="com.vladgoncharov.dtr_sb.working_with_a_date.PharmacyCalculation"/>
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
        <br>
        <table class="table_result table_pharmacy">
            <caption><h2>Расчет на ${pharmacyCalculation.month}</h2></caption>
            <thead>
            <th>
                День
            </th>
            <th>
                Выручка
            </th>
            <th>
                СТМ
            </th>
            </thead>
            <tbody>
            <c:forEach var="objectPharmacyCalculation" items="${pharmacyCalculation.objectPharmacyCalculation}">
                <tr class="tr_${objectPharmacyCalculation.colorLine}">
                    <td>
                            ${objectPharmacyCalculation.day}
                    </td>
                    <td>
                            ${objectPharmacyCalculation.amountOfRevenueForDay}
                    </td>
                    <td>
                            ${objectPharmacyCalculation.amountOfSTMForDay}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <th>
                    Общая Сумма:
                </th>
                <th>
                    ${pharmacyCalculation.amountOfRevenue}
                </th>
                <th>
                    ${pharmacyCalculation.amountOfSTM}
                </th>
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