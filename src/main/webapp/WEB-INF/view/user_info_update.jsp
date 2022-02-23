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
    <title>Изменить данные</title>
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
            <%--@elvariable id="appUserInfo" type="com.vladgoncharov.dtr_sb.entity.AppUserInfo"--%>
            <form:form action="userInfo_${currentUsername}" method="post" modelAttribute="appUserInfo">
            <fieldset>
                <legend>${currentUsername}</legend>
                <br>
                <form:hidden path="id"/>
                <form:hidden path="checkingEmail"/>
                <table>
                    <tr>
                        <td rowspan="12">
                            <img class="img_user" src="../../resources/images/smail/smail_${appUserInfo.img}.png"
                                 alt="Изображение не найдено"/>
                        </td>
                        <td>
                            Возраст
                        </td>
                        <td>
                            <form:input cssClass="input" path="age" placeholder="25"/>
                            <form:errors path="age"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td class="td_error">
                            <form:errors path="age"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Имя
                        </td>
                        <td>
                            <form:input cssClass="input" path="name" placeholder="Иван"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td class="td_error">
                            <form:errors path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Фамилия
                        </td>
                        <td>
                            <form:input cssClass="input" path="surname" placeholder="Иванов"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td class="td_error">
                            <form:errors path="surname"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            <form:input cssClass="input" path="email" placeholder="ivanov_ivan@gmail.com"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td class="td_error">
                            <form:errors path="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Город
                        </td>
                        <td>
                            <form:input cssClass="input" path="city" placeholder="Москва"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td class="td_error">
                            <form:errors path="city"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Номер телефона
                        </td>
                        <td>
                            <form:input cssClass="input" path="phone" placeholder="+79991122333"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td class="td_error">
                            <form:errors path="phone"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <input type="button" class="button" value="Выбрать смайл" onclick="flip_flop('table_smail');"/>
                            <div id="table_smail" class="table_smail" style="display: none;">
                                <div>
                                    <div class="radio_button_smail smail_small_1">
                                        <form:radiobutton path="img" value="1" label=""/>
                                    </div>
                                    <div class="radio_button_smail smail_small_2">
                                        <form:radiobutton path="img" value="2" label=""/>
                                    </div>
                                    <div class="radio_button_smail smail_small_3">
                                        <form:radiobutton path="img" value="3" label=""/>
                                    </div>
                                </div>
                                <div>
                                    <div class="radio_button_smail smail_small_4">
                                        <form:radiobutton path="img" value="4" label=""/>
                                    </div>
                                    <div class="radio_button_smail smail_small_5">
                                        <form:radiobutton path="img" value="5" label=""/>
                                    </div>
                                    <div class="radio_button_smail smail_small_6">
                                        <form:radiobutton path="img" value="6" label=""/>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input class="button" type="reset" value="Очистить"
                                   onclick="window.location.href='updateUserInfo_clear'">
                            <input class="button" type="submit" value="Сохранить">
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