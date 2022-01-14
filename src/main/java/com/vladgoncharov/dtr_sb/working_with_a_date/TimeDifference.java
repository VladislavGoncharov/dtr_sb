package com.vladgoncharov.dtr_sb.working_with_a_date;

import java.time.LocalTime;
import java.util.Map;

// Класс прибавляет/отнимает время
public class TimeDifference {

    private LocalTime initialTime;

    private byte hours = 12;
    private byte minutes = 30;
    private byte seconds;

    private byte plusMinus;
    private byte HMS;
    private int amountOfTime;

    private String textHours;
    private String textMinutes;
    private String textSeconds;

    private final Map<Integer, String> mapHMS = Map.of(
            0, "час",
            1, "минута",
            2, "секунда"
    );

    public TimeDifference() {

    }
    // Метод преобразует время в LocalTime и прибавляет/отнимает время
    public void theResultOfWorkingWithTime() {
        initialTime = LocalTime.of(hours, minutes, seconds);

        if (plusMinus == 0) {
            if (HMS == 0) {
                initialTime = initialTime.plusHours(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS == 1) {
                initialTime = initialTime.plusMinutes(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS == 2) {
                initialTime = initialTime.plusSeconds(amountOfTime);
                addResultInAVariables(initialTime);
            }
        } else if (plusMinus == 1) {
            if (HMS == 0) {
                initialTime = initialTime.minusHours(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS == 1) {
                initialTime = initialTime.minusMinutes(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS == 2) {
                initialTime = initialTime.minusSeconds(amountOfTime);
                addResultInAVariables(initialTime);
            }
        }

    }
    // Метод преобразует LocalDate в часы, минуты, секунды
    public void addResultInAVariables(LocalTime time) {
        this.hours = (byte) time.getHour();
        this.minutes = (byte) time.getMinute();
        this.seconds = (byte) time.getSecond();
        methodCorrectSpellingOfTheTimeText();
    }

    // Метод который правильно выдает текст единицы времени (час,часов и тд.)
    public void methodCorrectSpellingOfTheTimeText() {
        int lastDigitMinutes = Integer.parseInt(String.valueOf(minutes).substring(String.valueOf(minutes).length() - 1));
        int lastDigitSeconds = Integer.parseInt(String.valueOf(seconds).substring(String.valueOf(seconds).length() - 1));

        if (hours == 1 || hours == 21) setTextHours("час");
        else if (hours == 2 || hours == 3 || hours == 4 || hours == 22 || hours == 23) setTextHours("часа");
        else setTextHours("часов");

        if (lastDigitMinutes == 1 && minutes!=11) setTextMinutes("минута");
        else if (lastDigitMinutes > 1 && lastDigitMinutes < 5 && minutes!=12 && minutes!=13 && minutes!=14) setTextMinutes("минуты");
        else setTextMinutes("минут");

        if (lastDigitSeconds == 1 && seconds!=11) setTextSeconds("секунда");
        else if (lastDigitSeconds > 1 && lastDigitSeconds < 5 && seconds!=12 && seconds!=13 && seconds!=14) setTextSeconds("секунды");
        else setTextSeconds("секунд");

    }

    public byte getPlusMinus() {
        return plusMinus;
    }

    public byte getHMS() {
        return HMS;
    }

    public int getAmountOfTime() {
        return amountOfTime;
    }

    public byte getHours() {
        return hours;
    }

    public byte getMinutes() {
        return minutes;
    }

    public byte getSeconds() {
        return seconds;
    }
    
    public Map<Integer, String> getMapHMS() {
        return mapHMS;
    }

    public String getTextHours() {
        return textHours;
    }

    public void setTextHours(String textHours) {
        this.textHours = textHours;
    }

    public String getTextMinutes() {
        return textMinutes;
    }

    public void setTextMinutes(String textMinutes) {
        this.textMinutes = textMinutes;
    }

    public String getTextSeconds() {
        return textSeconds;
    }

    public void setTextSeconds(String textSeconds) {
        this.textSeconds = textSeconds;
    }

    public LocalTime getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(LocalTime initialTime) {
        this.initialTime = initialTime;
    }

    public void setHours(byte hours) {
        this.hours = hours;
    }

    public void setMinutes(byte minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(byte seconds) {
        this.seconds = seconds;
    }

    public void setPlusMinus(byte plusMinus) {
        this.plusMinus = plusMinus;
    }

    public void setHMS(byte HMS) {
        this.HMS = HMS;
    }

    public void setAmountOfTime(int amountOfTime) {
        this.amountOfTime = amountOfTime;
    }
}

