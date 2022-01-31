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
    <title>Все пользователи</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

</head>
<body>
<header>
    <br>
    <div>
        <a class="header_1" href="/">Добро пожаловать на DateTimeResult.ru</a>
    </div>
    <div id="current_date_time_block">
    </div>
</header>
<main>
    <article>
        <br>
        <table class="table_result table_result_user">
            <caption><h2>${text}</h2></caption>
            <thead>
                <th>
                    ID
                </th>
                <th>
                    Логин
                </th>
                <th>
                    Заблокирован?
                </th>
                <th colspan="2">
                    Опции
                </th>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <c:url var="deleteButton" value="/admin/showUser/deleteUser/${user.userId}">
                    </c:url>
                    <c:url var="blockButton" value="/admin/showUser/blockUser/${user.userId}">
                    </c:url>
                <tr>
                    <td>
                            ${user.userId}
                    </td>
                    <td>
                            ${user.userName}
                    </td>
                    <td>
                        <c:if test="${user.accountNonLocked}">Нет</c:if>
                        <c:if test="${!user.accountNonLocked}">Да</c:if>
                    </td>
                    <td>
                        <input class="button_admin_page delete" type="button" value="Удалить"
                               onclick="window.location.href='${deleteButton}'">
                    </td>
                    <td>
                        <c:if test="${user.accountNonLocked}" >
                        <input class="button_admin_page block" type="button"
                               value="Заблокировать"
                               onclick="window.location.href='${blockButton}'">
                        </c:if>
                        <c:if test="${!user.accountNonLocked}" >
                        <input class="button_admin_page block" type="button"
                               value="Разблокировать"
                               onclick="window.location.href='${blockButton}'">
                        </c:if>
                    </td>
                </tr>

                <%--            <c:url var="updateButton" value="/updateInfo">--%>
                <%--                <c:param name="empId" value="${emp.id}"/>--%>
                <%--            </c:url>--%>

            </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="5">The end</th>
                </tr>
            </tfoot>
        </table>
        <br><br>
        <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
        <br>
    </article>
</main>
</body>
<footer>
    <br>
    <dl>
        <dt>
            Связь с разработчиком:
        </dt>
        <dd>
            <a href="https://vk.com/veyvik87" target="_blank">Вконтакте</a>
        </dd>
        <dd>
            <a href="mailto:veyvik87@gmail.com?subject=Приглашаю вас на работу Junior Java Developer" target="_blank">Gmail</a>
        </dd>
    </dl>
</footer>
</html>