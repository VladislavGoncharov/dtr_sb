<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${zodiacSign.zodiacSign}</title>
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
        <h2>По знаку зодиака вы ${zodiacSign.zodiacSign}</h2>
        <h4 class="date_zodiacSing">${zodiacSign.dateZodiacSign}</h4>
    </span>
    <img class="img_zodiac_sign" src="../../resources/images/zodiac_sign/${zodiacSign.imgName}.png"/>
    <p class="text_zodiacSing">${zodiacSign.textAboutTheZodiacSign1}</p>
    <p class="text_zodiacSing">${zodiacSign.textAboutTheZodiacSign2}</p>
    <br>
    <input class="button" type="button" value="Назад" onclick="history.back();return false;"/>
    <br>
    </article>
</main>
<jsp:include page="include/footer.jsp"/>
</body>
</html>