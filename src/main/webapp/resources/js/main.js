/* Функция добавления ведущих нулей
(если число меньше десяти, перед числом добавляем ноль) */
function zero_first_format(value) {
    if (value < 10) {
        value = '0' + value;
    }
    return value;
}

// Функция меняющая число месяца на буквенное значение
function name_month(value) {
    switch (value) {
        case 1:
            return "Января";
        case 2:
            return "Февраля";
        case 3:
            return "Марта";
        case 4:
            return "Апреля";
        case 5:
            return "Мая";
        case 6:
            return "Июня";
        case 7:
            return "Июля";
        case 8:
            return "Августа";
        case 9:
            return "Сентября";
        case 10:
            return "Октября";
        case 11:
            return "Ноября";
        case 12:
            return "Декабря";
    }
}

// Функция получения текущей даты и времени
function date_time() {
    var current_datetime = new Date();
    var day = zero_first_format(current_datetime.getDate());
    var month = name_month(current_datetime.getMonth() + 1);
    var year = current_datetime.getFullYear();
    var hours = zero_first_format(current_datetime.getHours());
    var minutes = zero_first_format(current_datetime.getMinutes());
    var seconds = zero_first_format(current_datetime.getSeconds());

    return day + " " + month + " " + year + " " + hours + ":" + minutes + ":" + seconds;
}

/* Выводим текущую дату и время на сайт в блок с id "current_date_time_block"
каждую секунду получаем текущую дату и время
и вставляем значение в блок с id "current_date_time_block2" */
setInterval(function () {
    document.getElementById('current_date_time_block').innerHTML = date_time();
}, 10);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Разделитель//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Показывает скрытое, скрывает видимое
function flip_flop( id )
{
    element = document.getElementById( id );

    element.style.display = element.style.display == "none" ? "" : "none";
}
