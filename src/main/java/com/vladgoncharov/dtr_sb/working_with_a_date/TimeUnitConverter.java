package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

// Класс конвертирует указанную единицу времени в различные единицы времени
// (Пример: часы в секунды,минуты,часы,дни,недели,месяца,года)
@Data
public class TimeUnitConverter {

    private String years;
    private String months;
    private String weeks;
    private String days;
    private String hours;
    private String minutes;
    private String seconds;

    private double amountOfTimeDouble;
    private int amountOfTimeInt;
    private String unitsOfMeasurementText;

    private final String[] unitsOfMeasurement =
        {
        "секунда", "минута", "час", "день", "неделя", "месяц", "год"
        };

    public TimeUnitConverter() {

    }

    public void getResult(){
        amountOfTimeInt = (int) amountOfTimeDouble;

        switch (unitsOfMeasurementText) {
            case "секунда":
                countingSeconds();
                changeTextTimeName("секунда","секунды","секунд");
                break;
            case "минута":
                countingMinutes();
                changeTextTimeName("минута","минуты","минут");
                break;
            case "час":
                countingHours();
                changeTextTimeName("час","часа","часов");
                break;
            case "день":
                countingDays();
                changeTextTimeName("день","дня","дней");
                break;
            case "неделя":
                countingWeeks();
                changeTextTimeName("неделя","недели","недель");
                break;
            case "месяц":
                countingMonths();
                changeTextTimeName("месяц","месяца","месяцев");
                break;
            case "год":
                countingYears();
                changeTextTimeName("год","года","лет");
                break;
        }
    }

    // Метод разделяет числа пробелом по тысячам (83 566 684 482)
    private String numberSeparator(double number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

    private void changeTextTimeName(String timeName1,String timeName2,String timeName3){
        char[] arrayCharAmountOfTime = String.valueOf(amountOfTimeInt).toCharArray();
        char lastDigit = arrayCharAmountOfTime[arrayCharAmountOfTime.length-1];

        if (lastDigit == '1' && amountOfTimeDouble !=11) setUnitsOfMeasurementText(timeName1);

        else if (lastDigit > '1' && lastDigit < '5' && amountOfTimeDouble !=12
                && amountOfTimeDouble !=13 && amountOfTimeDouble !=14) setUnitsOfMeasurementText(timeName2);
        else
            setUnitsOfMeasurementText(timeName3);
    }

    private void countingSeconds(){
        setSeconds(numberSeparator(amountOfTimeDouble));
        setMinutes(numberSeparator(amountOfTimeDouble / 60));
        setHours(numberSeparator(amountOfTimeDouble / 60 / 60));
        setDays(numberSeparator(amountOfTimeDouble / 24 / 60 / 60));
        setWeeks(numberSeparator(amountOfTimeDouble / 7 / 24 / 60 / 60));
        setMonths(numberSeparator(amountOfTimeDouble / 4.34524 / 7 / 24 / 60 / 60));
        setYears(numberSeparator(amountOfTimeDouble / 12 / 4.34524 / 7 / 24 / 60 / 60));
    }
    private void countingMinutes(){
        setSeconds(numberSeparator(amountOfTimeDouble * 60));
        setMinutes(numberSeparator(amountOfTimeDouble));
        setHours(numberSeparator(amountOfTimeDouble / 60));
        setDays(numberSeparator(amountOfTimeDouble / 24 / 60));
        setWeeks(numberSeparator(amountOfTimeDouble / 7 / 24 / 60));
        setMonths(numberSeparator(amountOfTimeDouble / 4.34524 / 7 / 24 / 60));
        setYears(numberSeparator(amountOfTimeDouble / 12 / 4.34524 / 7 / 24 / 60));

    }
    private void countingHours(){
        setSeconds(numberSeparator(amountOfTimeDouble * 60 * 60));
        setMinutes(numberSeparator(amountOfTimeDouble * 60));
        setHours(numberSeparator(amountOfTimeDouble));
        setDays(numberSeparator(amountOfTimeDouble / 24));
        setWeeks(numberSeparator(amountOfTimeDouble / 7 / 24));
        setMonths(numberSeparator(amountOfTimeDouble / 4.34524 / 7 / 24));
        setYears(numberSeparator(amountOfTimeDouble / 12 / 4.34524 / 7 / 24));

    }
    private void countingDays(){
        setSeconds(numberSeparator(amountOfTimeDouble * 60 * 60 * 24));
        setMinutes(numberSeparator(amountOfTimeDouble * 60 * 24));
        setHours(numberSeparator(amountOfTimeDouble * 24));
        setDays(numberSeparator(amountOfTimeDouble));
        setWeeks(numberSeparator(amountOfTimeDouble / 7));
        setMonths(numberSeparator(amountOfTimeDouble / 4.34524 / 7));
        setYears(numberSeparator(amountOfTimeDouble / 12 / 4.34524 / 7));

    }
    private void countingWeeks(){
        setSeconds(numberSeparator(amountOfTimeDouble * 60 * 60 * 24 * 7));
        setMinutes(numberSeparator(amountOfTimeDouble * 60 * 24 * 7));
        setHours(numberSeparator(amountOfTimeDouble * 24 * 7));
        setDays(numberSeparator(amountOfTimeDouble * 7));
        setWeeks(numberSeparator(amountOfTimeDouble));
        setMonths(numberSeparator(amountOfTimeDouble / 4.34524));
        setYears(numberSeparator(amountOfTimeDouble / 12 / 4.34524));
    }
    private void countingMonths(){
        setSeconds(numberSeparator(Math.round (amountOfTimeDouble * 60 * 60 * 24 * 7 * 4.34524)));
        setMinutes(numberSeparator(Math.round (amountOfTimeDouble * 60 * 24 * 7 * 4.34524)));
        setHours(numberSeparator(Math.round(amountOfTimeDouble * 24 * 7 * 4.34524)));
        setDays(numberSeparator(amountOfTimeDouble * 7 * 4.34524));
        setWeeks(numberSeparator(amountOfTimeDouble * 4.34524));
        setMonths(numberSeparator(amountOfTimeDouble));
        setYears(numberSeparator(amountOfTimeDouble / 12));
    }
    private void countingYears(){
        setSeconds(numberSeparator(Math.round (amountOfTimeDouble * 60 * 60 * 24 * 7 * 4.34524 * 12)-14* amountOfTimeDouble));
        setMinutes(numberSeparator(Math.round (amountOfTimeDouble * 60 * 24 * 7 * 4.34524 * 12)));
        setHours(numberSeparator(Math.round(amountOfTimeDouble * 24 * 7 * 4.34524 * 12)));
        setDays(numberSeparator(amountOfTimeDouble * 7 * 4.34524 * 12));
        setWeeks(numberSeparator(amountOfTimeDouble * 4.34524 * 12));
        setMonths(numberSeparator(amountOfTimeDouble * 12));
        setYears(numberSeparator(amountOfTimeDouble));
    }
}
