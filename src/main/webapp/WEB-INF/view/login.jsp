<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>С возвращением</title>
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
        <h2>С возвращением</h2>
    </span>

    <br>
    <form name='f' action="/j_spring_security_check" method='POST'>
        <fieldset>
            <legend>Заполните формы</legend>
            <br>
            <table>
                <c:if test="${param.error != null}">
                    <tr>
                        <td class="td_error" colspan="2">
                            Неверный логин или пароль
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <%--@declare id="username"--%>
                        <label for='username'>Логин:</label>
                    </td>
                    <td>
                        <input id="username" class="input" type='text' name='username' placeholder="Логин">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for='password'>Пароль:</label>
                    </td>
                    <td>
                        <input id="password" class="input" type='password' name='password' placeholder="Пароль"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label>Вас запомнить?
                            <input class="input checkbox" type="checkbox" name="remember-me"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="button" name="submit" type="submit" value="Войти"/>
                        <input class="button" type="reset" value="Очистить"/>
                    </td>
                </tr>
            </table>
            <br>
        </fieldset>
    </form>
    <br><br>
    <div>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
        <input class="button" type="button" value="Зарегистрироваться"
               onclick="window.location.href = '/registration'"/>
    </div>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>