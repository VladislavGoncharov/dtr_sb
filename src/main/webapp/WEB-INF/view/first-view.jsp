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
    <script src="../../resources/js/main.js"></script>
    <link rel="import" href="include/header.jsp"/>
</head>

<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
        <br>
        <div>
            <table class="table_login">
                <security:authorize access="isAnonymous()==true">
                    <tr>
                        <td>
                            Здравствуйте, Гость
                        </td>
                        <td>
                        <span class="login">
                        <button class="button_first_view_login" type="button" onclick="window.location.href = 'login'">
                            Войти
                        </button>
                        <button class="button_first_view_login" type="button"
                                onclick="window.location.href = 'registration'">
                            Зарегистрироваться
                        </button>
                        </span>
                        </td>
                    </tr>
                </security:authorize>
                <security:authorize access="isAnonymous()==false">
                    <tr>
                        <td colspan="3">
                            С возвращением,
                            <a class="a_user_info_login" onclick="window.location.href='userInfo_${currentUsername}'">
                                    ${currentUsername}
                            </a>
                        </td>
                        <td>
                    <span class="login">
                    <button class="button_first_view_login" type="button"
                            onclick="window.location.href = '/logout'">
                        Выход
                    </button>
                    </span>
                        </td>
                    </tr>
                    <c:if test="${theUserIsReadyToCheckEmail}">
                        <tr>
                            <td colspan="4">
                                <button class="button_first_view_login" type="button" onclick="window.location.href
                                        = 'checkingEmail_${currentUsername}'">
                                    Подтвердить email
                                </button>
                            </td>
                        </tr>
                    </c:if>
                </security:authorize>
            </table>
        </div>
        <br>
        <ul>
            <c:if test="${currentUsername.equals('MKV_1997@mail.ru')||currentUsername.equals('veyvik87')}">
                <li>
                    <button class="button_first_view " type="button"
                            onclick="window.location.href = 'pharmacyCalculation'">
                        Аптечный расчет
                    </button>
                </li>
            </c:if>
            <li>
                <button class="button_first_view " type="button"
                        onclick="window.location.href = 'workingDaysAndWeekends'">
                    Расчет не стандартных рабочих и выходных дней
                </button>
            </li>
            <li>
                <button class="button_first_view " type="button" onclick="window.location.href = 'changeTheTime'">
                    Прибавить (отнять) время
                </button>
            </li>
            <li>
                <button class="button_first_view " type="button" onclick="window.location.href = 'timeUnitConverted'">
                    Конвертируем время
                </button>
            </li>
            <li>
                <button class="button_first_view " type="button" onclick="window.location.href = 'changeTheDate'">
                    Посчитать количество дней в промежутке
                </button>
            </li>
            <li>
                <button class="button_first_view " type="button" onclick="window.location.href = 'zodiacSign'">
                    Кто я по знаку зодиака?!
                </button>
            </li>
            <li>
                <button class="button_first_view " type="button" onclick="window.location.href = 'chineseZodiac'">
                    Кто я по китайскому календарю?!
                </button>
            </li>
        </ul>
        <section>
            <table>
                <tr>
                    <security:authorize access="isAnonymous()==false">
                    <div class="textarea">
                            <%--@elvariable id="comment" type="com.vladgoncharov.dtr_sb.entity.Comment"--%>
                        <form:form action="addNewComment" method="post" modelAttribute="comment">
                            <form:textarea class="textarea2" path="comment" maxlength="255"
                                           placeholder="не более 255 символов"/>
                            <form:errors path="comment"/>
                            <div class="right">
                                <input class="button bca" type="submit" value="Отправить" onclick="false"/>
                            </div>
                        </form:form>
                    </div>
                    </security:authorize>

                    <security:authorize access="isAnonymous()==true">
                    <input class="button_comment_add" type="button"
                           value="Чтобы написать комментарий необходимо авторизоваться"
                           onclick="window.location.href='login'">
                    </security:authorize>

                    <c:forEach var="com" items="${comments}" end="9">

                    <c:url var="deleteButton" value="/deleteComment_${com.id}">
                    </c:url>

                    <tr>
                    <div class="div_comment">

                        <div class="header_comment">
                            <span class="span_comment_time">
<%--                                    Пользователь может удалить свой комментарий--%>
                                <c:if test="${com.role == arrayRoleName[0]}">
                                    <c:if test="${com.username == currentUsername}">
                                        <input class="button_comment_delete" type="button" value="D"
                                               onclick="window.location.href='${deleteButton}'">
                                    </c:if>
                                </c:if>
<%--                                    Модератор может удалять любые комментарии, кроме админа--%>
                                <c:if test="${com.role != arrayRoleName[2]}">
                                    <security:authorize access="hasAnyRole('ROLE_MODERATOR')">
                                        <input class="button_comment_delete" type="button" value="D"
                                               onclick="window.location.href='${deleteButton}'">
                                    </security:authorize>
                                </c:if>
<%--                                    Админ имеет право удалять любые комментарии--%>
                                <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                                    <input class="button_comment_delete" type="button" value="D"
                                           onclick="window.location.href='${deleteButton}'">
                                </security:authorize>
                                    ${com.time}
                            </span>
                            <div >
                                <img class="img_user_comment"
                                     src="../../resources/images/smail/smail_small_${com.img}.png" alt="NO IMG"/>
                                <span class="span_comment_username">
                                 <a class="a_user_info" onclick="window.location.href='userInfo_${com.username}'">
                                         ${com.username}
                                 </a>
                                <sub class="sup_comment_${com.role}">${com.role}</sub>
                                </span>
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
<jsp:include page="include/footer.jsp"/>
</body>
</html>