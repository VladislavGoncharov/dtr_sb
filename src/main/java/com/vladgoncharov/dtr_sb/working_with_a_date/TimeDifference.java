package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.time.LocalTime;

// Класс прибавляет/отнимает время
@Data
public class TimeDifference {

    private LocalTime initialTime;

    private byte hours = 12;
    private byte minutes = 30;
    private byte seconds;

    private byte plusMinus;
    private String HMS;
    private int amountOfTime;

    private String textHours;
    private String textMinutes;
    private String textSeconds;

    private final String[] arrayHMS = {"час","минута","секунда"};

    public TimeDifference() {

    }
    // Метод преобразует время в LocalTime и прибавляет/отнимает время
    public void getResult() {
        initialTime = LocalTime.of(hours, minutes, seconds);

        if (plusMinus == 0) {
            if (HMS.equals("час")) {
                initialTime = initialTime.plusHours(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS.equals("минута")) {
                initialTime = initialTime.plusMinutes(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS.equals("секунда")) {
                initialTime = initialTime.plusSeconds(amountOfTime);
                addResultInAVariables(initialTime);
            }
        } else if (plusMinus == 1) {
            if (HMS.equals("час")) {
                initialTime = initialTime.minusHours(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS.equals("минута")) {
                initialTime = initialTime.minusMinutes(amountOfTime);
                addResultInAVariables(initialTime);
            } else if (HMS.equals("секунда")) {
                initialTime = initialTime.minusSeconds(amountOfTime);
                addResultInAVariables(initialTime);
            }
        }

    }

    // Метод преобразует LocalDate в часы, минуты, секунды
    private void addResultInAVariables(LocalTime time) {
        this.hours = (byte) time.getHour();
        this.minutes = (byte) time.getMinute();
        this.seconds = (byte) time.getSecond();
        methodCorrectSpellingOfTheTimeText();
    }

    // Метод который правильно выдает текст единицы времени (час,часов и тд.)
    private void methodCorrectSpellingOfTheTimeText() {
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
}

