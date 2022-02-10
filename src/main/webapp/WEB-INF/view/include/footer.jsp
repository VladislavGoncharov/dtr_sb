<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<footer>
    <table class="table_footer">
        <thead>
        <th class="th_footer">
            Связь с разработчиком
        </th>
        <th class="th_footer" colspan="2">
            Навигация
        </th>
        <th class="th_footer">
            ${currentUsername}
            <security:authorize access="isAnonymous()==true">
                Гость
            </security:authorize>
        </th>
        </thead>
        <tbody>
        <tr>
            <td class="td_footer_text_center">
                <a href="https://vk.com/veyvik87" target="_blank">Вконтакте</a>
            </td>
            <td colspan="2">
                <a onclick="window.location.href='workingDaysAndWeekends'" >Расчет не стандартных рабочих и выходных дней</a>
            </td>
            <td class="td_footer_text_center">
                <security:authorize access="isAnonymous()==true">
                    <a onclick="window.location.href = 'login'">
                        Войти
                    </a>
                </security:authorize>
                <security:authorize access="isAnonymous()==false">
                    <a onclick="window.location.href = 'userInfo_${currentUsername}'">
                        Моё инфо
                    </a>
                </security:authorize>
            </td>
        </tr>
        <tr>
            <td class="td_footer_text_center">
                <a href="mailto:veyvik87@gmail.com?subject=Приглашаю вас на работу Junior Java Developer"
                   target="_blank">Gmail</a>
            </td>
            <td colspan="2">
                <a onclick="window.location.href='changeTheDate'" >Посчитать количество дней в промежутке</a>
            </td>
            <td class="td_footer_text_center">

                <security:authorize access="isAnonymous()==true">
                    <a onclick="window.location.href = 'registration'">
                        Зарегистрироваться
                    </a>
                </security:authorize>
                <security:authorize access="isAnonymous()==false">
                    <a onclick="window.location.href = '/logout'">
                        Выход
                    </a>
                </security:authorize>
            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <a onclick="window.location.href='changeTheTime'" >Прибавить (отнять) время</a>
            </td>
            <td class="td_footer_text_center">
                <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')">
                    <a onclick="window.location.href='admin/adminPage'" >Админ</a>
                </security:authorize>
            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <a onclick="window.location.href='timeUnitConverted'" >Конвертируем время</a>
            </td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <a onclick="window.location.href='zodiacSign'" >Кто я по знаку зодиака?!</a>
            </td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <a onclick="window.location.href='chineseZodiac'" >Кто я по китайскому календарю?!</a>
            </td>
            <td></td>
        </tr>
        </tbody>
    </table>
    <br>
</footer>
</html>

