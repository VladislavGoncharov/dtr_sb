<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="date" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Секретное место</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>

</head>
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
    <article>
    <span class="header_2">
        <h2>Admin</h2>
    </span>
    <security:authorize access="hasAnyRole('ADMIN')">
        <button class="button_first_view" type="button" onclick="window.location.href = 'registrationModerator'">
            Добавить модератора
        </button>
    </security:authorize>

    <table class="table_result table_result_user">
        <caption><h2>Список пользователей</h2></caption>
        <thead>
        <th>
            ID
        </th>
        <th>
            User name
        </th>
        <th>
            Password
        </th>
        <th>
            Role
        </th>
        <th>
            Enabled
        </th>
        <th>
            Options
        </th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <c:url var="deleteButton" value="/admin/deleteUser">
                <c:param name="userId" value="${user.userId}"/>
            </c:url>
            <c:url var="blockButton" value="/admin/blockUser">
                <c:param name="userId" value="${user.userId}"/>
            </c:url>
            <tr>
                <td >
                    ${user.userId}
                </td>
                <td >
                    ${user.userName}
                </td>
                <td >
<%--                    ${user.encrytedPassword}--%>
                    secret ;}
                </td>
                <td >
                    ${user.roleName.substring(5)}
                </td>
                <td >
                    ${user.accountNonLocked}
                </td>
                <td >
                    <input class="button_admin_page delete" type="button" value="delete" onclick="window.location.href='${deleteButton}'">
                    <br>
                    <input class="button_admin_page block" type="button" value="block" onclick="window.location.href='${blockButton}'">
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

    <br>



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