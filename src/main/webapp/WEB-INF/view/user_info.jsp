<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Мои данные</title>
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

        <br>
        <form>
            <fieldset>
                <legend>${username}</legend>
                <br>
                <table>
                    <tr>
                        <td rowspan="6">
                            <img class="img_user" src="../../resources/images/smail/smail_${userInfo.img}.png"
                                 alt="Изображение не найдено"/>
                        </td>
                        <td>
                            Возраст
                        </td>
                        <td class="td_user_info">
                            <c:if test="${userInfo.age==''}">
                                ...
                            </c:if>
                            ${userInfo.age}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Имя
                        </td>
                        <td class="td_user_info">
                            <c:if test="${userInfo.name==''}">
                                ...
                            </c:if>
                            ${userInfo.name}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Фамилия
                        </td>
                        <td class="td_user_info">
                            <c:if test="${userInfo.surname==''}">
                                ...
                            </c:if>
                            ${userInfo.surname}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email
                        </td>
                        <td class="td_user_info">
                            <c:if test="${userInfo.email==''}">
                                ...
                            </c:if>
                            ${userInfo.email}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Город
                        </td>
                        <td class="td_user_info">
                            <c:if test="${userInfo.city==''}">
                                ...
                            </c:if>
                            ${userInfo.city}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Номер телефона
                        </td>
                        <td class="td_user_info">
                            <c:if test="${userInfo.phone==''}">
                                ...
                            </c:if>
                            ${userInfo.phone}
                        </td>
                    </tr>
                    <c:if test="${currentUsername==username}">
                        <tr>
                            <td colspan="3">
                                <input class="button" type="button"
                                       value="Изменить" onclick="window.location.href='/updateUserInfo'"/>
                            </td>
                        </tr>
                    </c:if>
                </table>
                <br>
            </fieldset>
        </form>
        <br><br>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
        <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>