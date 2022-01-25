<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DateTimeResult</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/current_time.js"></script>
</head>

<body>

<header>
    <nav></nav>
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
    <br>
        <div>
        <table class="table_login">
            <tr>
                <td>
                    <security:authorize access="isAnonymous()==true">
                        Здравствуйте, ${currentUsername}
                    </security:authorize>
                    <security:authorize access="isAnonymous()==false">
                        С возвращением, ${currentUsername}
                    </security:authorize>
                </td>
                <td>
                    <security:authorize access="isAnonymous()==true">
                      <span class="login">
                        <button class="button_first_view_login" type="button" onclick="window.location.href = 'login'">
                            Войти
                        </button>
                        <button class="button_first_view_login" type="button"
                                onclick="window.location.href = 'registration'">
                            Зарегистрироваться
                        </button>
                      </span>
                    </security:authorize>
                    <security:authorize access="isAnonymous()==false">
                        <span class="login">
                        <button class="button_first_view_login" type="button"
                                onclick="window.location.href = '/logout'">
                            Выход
                        </button>
                      </span>
                    </security:authorize>
                </td>
            </tr>
        </table>
    </div>
    <br>
    <ul>
        <li>
            <button class="button_first_view " type="button" onclick="window.location.href = 'changeTheDate'">
                Посчитать количество дней в промежутке
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view " type="button" onclick="window.location.href = 'changeTheTime'">
                Прибавить (отнять) время
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view " type="button" onclick="window.location.href = 'timeUnitConverted'">
                Конвертируем время
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view " type="button" onclick="window.location.href = 'workingDaysAndWeekends'">
                Расчет не стандартных рабочих и выходных дней
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view " type="button" onclick="window.location.href = 'zodiacSign'">
                Кто я по знаку зодиака?!
            </button>
            <br>
        </li>
        <li>
            <button class="button_first_view " type="button" onclick="window.location.href = 'chineseZodiac'">
                Кто я по китайскому календарю?!
            </button>
            <br>
        </li>
        <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')">
            <li>
                <button class="button_first_view " type="button" onclick="window.location.href = 'admin/adminPage'">
                admin
                </button>
                <br>
            </li>
        </security:authorize>
    </ul>
    <section>
        <table>
            <tr>
                    <security:authorize access="isAnonymous()==false">
                        <div class="textarea">
                        <%--@elvariable id="comment" type="com.vladgoncharov.dtr_sb.entity.Comment"--%>
                        <form:form action="addNewComment" method="post" modelAttribute="comment">
                            <form:textarea class="textarea2"  path="comment" maxlength="255" placeholder="не более 255 символов"/>
                            <form:errors path="comment"/>
                            <div class="right">
                                <input class="button" type="submit" value="Add"/>
                            </div>
                        </form:form>
                        </div>
                    </security:authorize>

                    <security:authorize access="isAnonymous()==true">
                        <input class="button_comment_add" type="button"
                               value="Чтобы написать комментарий необходимо авторизоваться"
                              onclick="window.location.href='login'">
                    </security:authorize>

            <c:forEach var="com" items="${comments}" end="9" >

                <c:url var="deleteButton" value="/deleteComment">
                    <c:param name="commentId" value="${com.id}"/>
                </c:url>

                <tr>
                    <div class="div_comment">

                        <div class="header_comment">
                                ${com.username}
                            <sub class="sup_comment_${com.role}">${com.role}</sub>
                            <div class="span_comment">
                                <c:if test="${com.username != 'admin' && com.username != 'moderator'}">
                                    <c:if test="${com.username == currentUsername}">
                                        <input class="button_comment_delete" type="button" value="D"
                                               onclick="window.location.href='${deleteButton}'">
                                    </c:if>
                                </c:if>
                                <c:if test="${com.username != 'admin'}">
                                    <security:authorize access="hasAnyRole('MODERATOR')">
                                        <input class="button_comment_delete" type="button" value="D"
                                               onclick="window.location.href='${deleteButton}'">
                                    </security:authorize>
                                </c:if>
                                <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                                    <input class="button_comment_delete" type="button" value="D"
                                           onclick="window.location.href='${deleteButton}'">
                                </security:authorize>
                                    ${com.time}
                            </div>
                        </div>
                        <div class="body_comment">
                                ${com.comment}
                        </div>
                    </div>
                </tr>
            </c:forEach>
        </table>
    </section>
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