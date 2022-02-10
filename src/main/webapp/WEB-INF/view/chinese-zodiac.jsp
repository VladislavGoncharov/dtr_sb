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
    <title>Китайский календарь?!что?</title>
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
        <h2>Кто я по китайскому календарю?!</h2>
    </span>
    <br>
    <%--@elvariable id="chineseZodiac" type="com.vladgoncharov.dtr_sb.working_with_a_date.ChineseZodiac"--%>
    <form:form action="chineseZodiacResult" method="post" modelAttribute="chineseZodiac">

        <fieldset>
            <legend>Заполните формы по шаблону</legend>
            <br>
            <table class="table_forms_working_with_a_date">
                <tbody>
                <tr>
                    <td>
                        <label for="year">Введите год вашего рождения:</label>
                    </td>
                    <td>
                        <form:input class="input" path="year" maxlength="4"
                                    min="1" max="9999" placeholder="2020" name="year"/>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2">
                        <input class="button" type="submit" value="Посчитать">
                        <input class="button" type="reset" value="Очистить"
                               onclick="window.location.href = 'chineseZodiac'">
                    </td>
                </tr>
                </tfoot>

            </table>
            <br>
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