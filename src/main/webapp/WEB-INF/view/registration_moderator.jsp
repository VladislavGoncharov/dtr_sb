<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"  %>
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
    <title>Регистрация нового модератора</title>
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
        <h2>Регистрация нового пользователя</h2>
    </span>

    <br>

    <%--@elvariable id="moderator" type="com.vladgoncharov.dtr_sb.entity.AppUser"--%>
    <form:form action="registrationModerator" method="post" modelAttribute="moderator">
        <fieldset>
            <legend>Заполните формы</legend>
            <br>

            <table>
                <form:hidden path="userId"/>
                <tr>
                    <td>
                        <label for="userName">Введите логин:</label>
                    </td>
                    <td>
                        <form:input class="input" type="text" path="username" name="userName" maxlength="36"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="td_error">
                        <form:errors path="username"/>
                            ${exceptionUsername}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Введите пароль:</label>
                    </td>
                    <td>
                        <form:input class="input" type="password" path="encrytedPassword"
                                    name="password" maxlength="128"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"class="td_error">
                        <form:errors path="encrytedPassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="passwordCheck">Подтвердите пароль:</label>
                    </td>
                    <td>
                        <form:input class="input" type="password" path="encrytedPasswordCheck"
                                    name="passwordCheck" maxlength="128"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="td_error">
                            ${exceptionPasswordCheck}
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="button" type="submit" value="Добавить" >
                        <input class="button" type="reset" value="Очистить">
                    </td>
                </tr>
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