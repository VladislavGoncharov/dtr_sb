package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;

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

    private double amountOfTime;
    private byte UOM;

    private final Map<Integer, String> unitsOfMeasurement = new LinkedHashMap<>(){{
        put(0, "секунда");
        put(1, "минута");
        put(2, "час");
        put(3, "день");
        put(4, "неделя");
        put(5, "месяц");
        put(6, "год");
    }};

    public TimeUnitConverter() {

    }
    // Главный метод конвертирующий время
    public void getResult(){
        methodOfMeasuringSeconds();
        methodOfMeasuringMinutes();
        methodOfMeasuringHours();
        methodOfMeasuringDays();
        methodOfMeasuringWeeks();
        methodOfMeasuringMonths();
        methodOfMeasuringYears();
    }

    // Метод вычисления секунд
    private void methodOfMeasuringSeconds() {
        switch (UOM) {
            case 0:
                setSeconds(numberSeparator(amountOfTime));
                break;
            case 1:
                setSeconds(numberSeparator(amountOfTime * 60));
                break;
            case 2:
                setSeconds(numberSeparator(amountOfTime * 60 * 60));
                break;
            case 3:
                setSeconds(numberSeparator(amountOfTime * 60 * 60 * 24));
                break;
            case 4:
                setSeconds(numberSeparator(amountOfTime * 60 * 60 * 24 * 7));
                break;
            case 5:
                setSeconds(numberSeparator(Math.round (amountOfTime * 60 * 60 * 24 * 7 * 4.34524)));
                break;
            case 6:
                setSeconds(numberSeparator(Math.round (amountOfTime * 60 * 60 * 24 * 7 * 4.34524 * 12)-14*amountOfTime));
                break;
        }
    }

    // Метод вычисления минут
    private void methodOfMeasuringMinutes() {
        switch (UOM) {
            case 0:
                setMinutes(numberSeparator(amountOfTime / 60));
                break;
            case 1:
                setMinutes(numberSeparator(amountOfTime));
                break;
            case 2:
                setMinutes(numberSeparator(amountOfTime * 60));
                break;
            case 3:
                setMinutes(numberSeparator(amountOfTime * 60 * 24));
                break;
            case 4:
                setMinutes(numberSeparator(amountOfTime * 60 * 24 * 7));
                break;
            case 5:
                setMinutes(numberSeparator(Math.round (amountOfTime * 60 * 24 * 7 * 4.34524)));
                break;
            case 6:
                setMinutes(numberSeparator(Math.round (amountOfTime * 60 * 24 * 7 * 4.34524 * 12)));
                break;
        }
    }

    // Метод вычисления часов
    private void methodOfMeasuringHours() {
        switch (UOM) {
            case 0:
                setHours(numberSeparator(amountOfTime / 60 / 60));
                break;
            case 1:
                setHours(numberSeparator(amountOfTime / 60));
                break;
            case 2:
                setHours(numberSeparator(amountOfTime));
                break;
            case 3:
                setHours(numberSeparator(amountOfTime * 24));
                break;
            case 4:
                setHours(numberSeparator(amountOfTime * 24 * 7));
                break;
            case 5:
                setHours(numberSeparator(Math.round(amountOfTime * 24 * 7 * 4.34524)));
                break;
            case 6:
                setHours(numberSeparator(Math.round(amountOfTime * 24 * 7 * 4.34524 * 12)));
                break;
        }
    }

    // Метод вычисления дней
    private void methodOfMeasuringDays() {
        switch (UOM) {
            case 0:
                setDays(numberSeparator(amountOfTime / 24 / 60 / 60));
                break;
            case 1:
                setDays(numberSeparator(amountOfTime / 24 / 60));
                break;
            case 2:
                setDays(numberSeparator(amountOfTime / 24));
                break;
            case 3:
                setDays(numberSeparator(amountOfTime));
                break;
            case 4:
                setDays(numberSeparator(amountOfTime * 7));
                break;
            case 5:
                setDays(numberSeparator(amountOfTime * 7 * 4.34524));
                break;
            case 6:
                setDays(numberSeparator(amountOfTime * 7 * 4.34524 * 12));
                break;
        }
    }

    // Метод вычисления недель
    private void methodOfMeasuringWeeks() {
        switch (UOM) {
            case 0:
                setWeeks(numberSeparator(amountOfTime / 7 / 24 / 60 / 60));
                break;
            case 1:
                setWeeks(numberSeparator(amountOfTime / 7 / 24 / 60));
                break;
            case 2:
                setWeeks(numberSeparator(amountOfTime / 7 / 24));
                break;
            case 3:
                setWeeks(numberSeparator(amountOfTime / 7));
                break;
            case 4:
                setWeeks(numberSeparator(amountOfTime));
                break;
            case 5:
                setWeeks(numberSeparator(amountOfTime * 4.34524));
                break;
            case 6:
                setWeeks(numberSeparator(amountOfTime * 4.34524 * 12));
                break;
        }
    }

    // Метод вычисления месяцев
    private void methodOfMeasuringMonths() {
        switch (UOM) {
            case 0:
                setMonths(numberSeparator(amountOfTime / 4.34524 / 7 / 24 / 60 / 60));
                break;
            case 1:
                setMonths(numberSeparator(amountOfTime / 4.34524 / 7 / 24 / 60));
                break;
            case 2:
                setMonths(numberSeparator(amountOfTime / 4.34524 / 7 / 24));
                break;
            case 3:
                setMonths(numberSeparator(amountOfTime / 4.34524 / 7));
                break;
            case 4:
                setMonths(numberSeparator(amountOfTime / 4.34524));
                break;
            case 5:
                setMonths(numberSeparator(amountOfTime));
                break;
            case 6:
                setMonths(numberSeparator(amountOfTime * 12));
                break;
        }
    }

    // Метод вычисления лет
    private void methodOfMeasuringYears() {
        switch (UOM) {
            case 0:
                setYears(numberSeparator(amountOfTime / 12 / 4.34524 / 7 / 24 / 60 / 60));
                break;
            case 1:
                setYears(numberSeparator(amountOfTime / 12 / 4.34524 / 7 / 24 / 60));
                break;
            case 2:
                setYears(numberSeparator(amountOfTime / 12 / 4.34524 / 7 / 24));
                break;
            case 3:
                setYears(numberSeparator(amountOfTime / 12 / 4.34524 / 7));
                break;
            case 4:
                setYears(numberSeparator(amountOfTime / 12 / 4.34524));
                break;
            case 5:
                setYears(numberSeparator(amountOfTime / 12));
                break;
            case 6:
                setYears(numberSeparator(amountOfTime));
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
}
