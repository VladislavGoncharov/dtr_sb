package com.vladgoncharov.dtr_sb.working_with_a_date;

import javax.validation.constraints.Pattern;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;

// Класс высчитывает разницу в датах
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

    private String resultInMonths;
    private String resultInDays;
    private String resultInHours;
    private String resultInMinutes;
    private String resultInSeconds;

    private String textYear;
    private String textMonth;
    private String textDay;


    public DateDifference() {
    }

    /* Метод, где даты преобразуются в тип LocalDate и определяется какая из дат раньше,
     а какая позже для уменьшения возможных ошибок */
    public void methodGetTheDateDifference() {

        firstLocalDate = dateConversionInLocalDate(firstDateString);
        secondLocalDate = dateConversionInLocalDate(secondDateString);

        if (firstLocalDate.isAfter(secondLocalDate))
            dateConversions(secondLocalDate, firstLocalDate);
        else
            dateConversions(firstLocalDate, secondLocalDate);
    }

    // Метод высчитывания разницы между датами в разный единицах измерения
    public void dateConversions(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);

        this.year = period.getYears();
        this.month = period.getMonths();
        this.day = period.getDays();


        int resInMonths = year * 12 + month;
        this.resultInMonths = numberSeparator(resInMonths);

        int resInDays = methodCountTheDays(startDate, endDate);
        this.resultInDays = numberSeparator(resInDays);

        int resInHours = resInDays * 24;
        this.resultInHours = numberSeparator(resInHours);

        long resInMinutes = resInHours * 60L;
        this.resultInMinutes = numberSeparator(resInMinutes);

        long resInSeconds = resInMinutes * 60L;
        this.resultInSeconds = numberSeparator(resInSeconds);

        methodCorrectSpellingOfTheTimeText();
    }

    // Метод преобразования даты из String в LocalDate
    public LocalDate dateConversionInLocalDate(String newDate) {
        System.out.println(newDate);
        int day = Integer.parseInt(newDate.substring(0, 2));
        int month = Integer.parseInt(newDate.substring(3, 5));
        int year = Integer.parseInt(newDate.substring(6, 10));

        return LocalDate.of(year, month, day);
    }

    // Метод подсчета количества дней в указанный период
    public int methodCountTheDays(LocalDate startDate, LocalDate endDate) {
        int getYearStartDate = startDate.getYear();
        int getDaysBeforeEndYear =
                LocalDate.of(getYearStartDate, 12, 31).getDayOfYear() - startDate.getDayOfYear();

        int getYearEndDate = endDate.getYear();
        int daysOfEndDate = endDate.getDayOfYear();
        if (getYearStartDate == getYearEndDate) {
            return endDate.getDayOfYear() - startDate.getDayOfYear();
        } else if (getYearEndDate - getYearStartDate == 1) {
            return getDaysBeforeEndYear + daysOfEndDate;
        } else {
            int totalDays = getDaysBeforeEndYear + daysOfEndDate;
            for (int i = getYearStartDate + 1; i < getYearEndDate; i++) {
                int dayOfYear = LocalDate.of(i, 12, 31).getDayOfYear();
                totalDays += dayOfYear;
            }
            return totalDays;
        }
    }

    // Метод который правильно выдает текст единицы времени (год,лет и тд.)
    public void methodCorrectSpellingOfTheTimeText() {
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
    public String numberSeparator(long number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

    public String getFirstDateString() {
        return firstDateString;
    }

    public String getSecondDateString() {
        return secondDateString;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getResultInMonths() {
        return resultInMonths;
    }

    public String getResultInDays() {
        return resultInDays;
    }

    public String getResultInHours() {
        return resultInHours;
    }

    public String getResultInMinutes() {
        return resultInMinutes;
    }

    public String getResultInSeconds() {
        return resultInSeconds;
    }

    public String getTextYear() {
        return textYear;
    }

    public void setTextYear(String textYear) {
        this.textYear = textYear;
    }

    public String getTextMonth() {
        return textMonth;
    }

    public void setTextMonth(String textMonth) {
        this.textMonth = textMonth;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public void setFirstDateString(String firstDateString) {
        this.firstDateString = firstDateString;
    }

    public void setSecondDateString(String secondDateString) {
        this.secondDateString = secondDateString;
    }

    public LocalDate getFirstLocalDate() {
        return firstLocalDate;
    }

    public void setFirstLocalDate(LocalDate firstLocalDate) {
        this.firstLocalDate = firstLocalDate;
    }

    public LocalDate getSecondLocalDate() {
        return secondLocalDate;
    }

    public void setSecondLocalDate(LocalDate secondLocalDate) {
        this.secondLocalDate = secondLocalDate;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setResultInMonths(String resultInMonths) {
        this.resultInMonths = resultInMonths;
    }

    public void setResultInDays(String resultInDays) {
        this.resultInDays = resultInDays;
    }

    public void setResultInHours(String resultInHours) {
        this.resultInHours = resultInHours;
    }

    public void setResultInMinutes(String resultInMinutes) {
        this.resultInMinutes = resultInMinutes;
    }

    public void setResultInSeconds(String resultInSeconds) {
        this.resultInSeconds = resultInSeconds;
    }
}
