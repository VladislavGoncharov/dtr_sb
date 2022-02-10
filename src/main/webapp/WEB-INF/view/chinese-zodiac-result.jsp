<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${chineseZodiac.chineseZodiac}</title>
    <link rel="shortcut icon" href="../../resources/images/clock.ico"/>
    <link rel="stylesheet" href="../../resources/style/style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@600&display=swap" rel="stylesheet">
    <script src="../../resources/js/main.js"></script>

<body>
<jsp:include page="include/header.jsp"/>
<main>
    <article>
    <br>
    <span class="header_2">
        <h2>По Китайскому Знаку Зодиака вы ${chineseZodiac.chineseZodiac}</h2>
    </span>
    <img class="img_chinese_zodiac" src="../../resources/images/chinese_zodiac/${chineseZodiac.imgName}.png"/>
    <p class="text_zodiacSing">${chineseZodiac.textAboutTheChineseZodiac1}</p>
    <p class="text_zodiacSing">${chineseZodiac.textAboutTheChineseZodiac2}</p>
    <span class="header_2">
        <h4 class="date_zodiacSing">Года Китайского Знака Зодиака ${chineseZodiac.chineseZodiac}:</h4>
        <h4 class="date_zodiacSing">${chineseZodiac.dateChineseZodiac}</h4>
    </span>
    <br>
    <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>