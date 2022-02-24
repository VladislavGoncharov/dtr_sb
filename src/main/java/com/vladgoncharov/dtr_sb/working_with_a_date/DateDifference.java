package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Класс высчитывает разницу в датах
@Data
public class DateDifference {

    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}", message = "Обрати внимание на формат ===> дд.мм.гггг")
    private String firstDateString;
    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}", message = "Обрати внимание на формат ===> дд.мм.гггг")
    private String secondDateString;

    private LocalDate firstLocalDate;
    private LocalDate secondLocalDate;

    private int year;
    private int month;
    private int day;
    private String textYear;
    private String textMonth;
    private String textDay;

    private String resultInMonths;
    private String resultInDays;
    private String resultInHours;
    private String resultInMinutes;
    private String resultInSeconds;

    public DateDifference() {
    }

    /* Метод, где даты преобразуются в тип LocalDate и определяется какая из дат раньше,
     а какая позже для уменьшения возможных ошибок */
    public void getResult() {

        firstLocalDate = dateConversionInLocalDate(firstDateString);
        secondLocalDate = dateConversionInLocalDate(secondDateString);

        if (firstLocalDate.isAfter(secondLocalDate))
            dateConversions(secondLocalDate, firstLocalDate);
        else
            dateConversions(firstLocalDate, secondLocalDate);

        dateStringFormat();
    }

    // Метод высчитывания разницы между датами в разный единицах измерения
    private void dateConversions(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);

        setYear(period.getYears());
        setMonth(period.getMonths());
        setDay(period.getDays());

        int resInMonths = year * 12 + month;
        setResultInMonths(numberSeparator(resInMonths));

        int resInDays = methodCountTheDays(startDate, endDate);
        setResultInDays(numberSeparator(resInDays));

        int resInHours = resInDays * 24;
        setResultInHours(numberSeparator(resInHours));

        long resInMinutes = resInHours * 60L;
        setResultInMinutes(numberSeparator(resInMinutes));

        long resInSeconds = resInMinutes * 60L;
        setResultInSeconds(numberSeparator(resInSeconds));

        methodCorrectSpellingOfTheTimeText();
    }

    // Метод преобразования даты из String в LocalDate
    private LocalDate dateConversionInLocalDate(String newDate) {
        int day = Integer.parseInt(newDate.substring(0, 2));
        int month = Integer.parseInt(newDate.substring(3, 5));
        int year = Integer.parseInt(newDate.substring(6, 10));

        return LocalDate.of(year, month, day);
    }

    // Метод подсчета количества дней в указанный период
    private int methodCountTheDays(LocalDate startDate, LocalDate endDate) {
        int yearStartDate = startDate.getYear();
        int yearEndDate = endDate.getYear();

        //количество дней до конца начального года
        int daysBeforeEndYear =
                LocalDate.of(yearStartDate, 12, 31).getDayOfYear() - startDate.getDayOfYear();
        //количество дней до конца конечного года
        int daysOfEndDate = endDate.getDayOfYear();

        //если начальный и конечный год одинаковый
        if (yearStartDate == yearEndDate) {
            return endDate.getDayOfYear() - startDate.getDayOfYear();
        }
        //если конечный год больше на один, чем начальный год
        else if (yearEndDate - yearStartDate == 1) {
            return daysBeforeEndYear + daysOfEndDate;
        }
        else {
            int totalDays = daysBeforeEndYear + daysOfEndDate;
            for (int i = yearStartDate + 1; i < yearEndDate; i++) {
                int dayOfYear = LocalDate.of(i, 12, 31).getDayOfYear();
                totalDays += dayOfYear;
            }
            return totalDays;
        }
    }

    // Метод который правильно выдает текст единицы времени (год,лет и тд.)
    private void methodCorrectSpellingOfTheTimeText() {
        int lastDigitYear = Integer.parseInt(String.valueOf(year).substring(String.valueOf(year).length() - 1));

        if (lastDigitYear == 1) setTextYear("год");
        else if (lastDigitYear > 1 && lastDigitYear < 5) setTextYear("года");
        else setTextYear("лет");

        if (month == 1) setTextMonth("месяц");
        else if (month > 1 && month < 5) setTextMonth("месяца");
        else setTextMonth("месяцев");

        if (day == 1 || day == 21 || day == 31) setTextDay("день");
        else if (day == 2 || day == 3 || day == 4 || day == 22 || day == 23 || day == 24) setTextDay("дня");
        else setTextDay("дней");

    }

    // Метод разделяет числа пробелом по тысячам (83 566 684 482)
    private String numberSeparator(long number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

    private void dateStringFormat(){
        firstDateString = firstLocalDate
                .format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("ru")));
        secondDateString = secondLocalDate
                .format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("ru")));
    }

}
