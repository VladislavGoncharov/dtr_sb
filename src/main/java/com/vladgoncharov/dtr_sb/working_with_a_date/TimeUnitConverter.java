package com.vladgoncharov.dtr_sb.working_with_a_date;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Map;

// Класс конвертирует указанную единицу времени в различные единицы времени (Пример: часы в секунды,минуты,часы,дни,недели,месяца,года)
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

    private final Map<Integer, String> unitsOfMeasurement = Map.of(
            0, "секунда",
            1, "минута",
            2, "час",
            3, "день",
            4, "неделя",
            5, "месяц",
            6, "год");

    public TimeUnitConverter() {

    }
    // Главный метод конвертирующий время
    public void theResultOfWorkingWithTime(){
        methodOfMeasuringSeconds();
        methodOfMeasuringMinutes();
        methodOfMeasuringHours();
        methodOfMeasuringDays();
        methodOfMeasuringWeeks();
        methodOfMeasuringMonths();
        methodOfMeasuringYears();
    }

    // Метод вычисления секунд
    public void methodOfMeasuringSeconds() {
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
    public void methodOfMeasuringMinutes() {
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
    public void methodOfMeasuringHours() {
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
    public void methodOfMeasuringDays() {
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
    public void methodOfMeasuringWeeks() {
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
    public void methodOfMeasuringMonths() {
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
    public void methodOfMeasuringYears() {
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
    public String numberSeparator(double number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

    public Map<Integer, String> getUnitsOfMeasurement() {
        return unitsOfMeasurement;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public double getAmountOfTime() {
        return amountOfTime;
    }

    public byte getUOM() {
        return UOM;
    }

    public void setAmountOfTime(double amountOfTime) {
        this.amountOfTime = amountOfTime;
    }

    public void setUOM(byte UOM) {
        this.UOM = UOM;
    }
}
