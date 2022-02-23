package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.time.LocalTime;

// Класс прибавляет/отнимает время
@Data
public class TimeDifference {

    private LocalTime initialTime;

    private int hours = 12;
    private int minutes = 30;
    private int seconds = 0;
    private String initialTimeText;

    private boolean plusMinus = true;
    private String HMS;
    private int amountOfTime;

    private String textHours;
    private String textMinutes;
    private String textSeconds;
    private String textHMS;

    private final String[] arrayHMS = {"час","минута","секунда"};

    public TimeDifference() {

    }
    // Метод преобразует время в LocalTime и прибавляет/отнимает время
    public void getResult() {
        initialTime = LocalTime.of(hours, minutes, seconds);

        if (plusMinus) {
            switch (HMS) {
                case "час":
                    addResultInAVariables(initialTime.plusHours(amountOfTime));
                    break;
                case "минута":
                    addResultInAVariables(initialTime.plusMinutes(amountOfTime));
                    break;
                case "секунда":
                    addResultInAVariables(initialTime.plusSeconds(amountOfTime));
                    break;
            }
        } else {
            switch (HMS) {
                case "час":
                    addResultInAVariables(initialTime.minusHours(amountOfTime));
                    break;
                case "минута":
                    addResultInAVariables(initialTime.minusMinutes(amountOfTime));
                    break;
                case "секунда":
                    addResultInAVariables(initialTime.minusSeconds(amountOfTime));
                    break;
            }
        }
    }

    // Метод преобразует LocalDate в часы, минуты, секунды
    private void addResultInAVariables(LocalTime time) {
        this.hours = time.getHour();
        this.minutes = time.getMinute();
        this.seconds = time.getSecond();
        correctSpellingOfTheTimeTextName();
    }

    // Метод который правильно выдает текст единицы времени (час,часов и тд.)
    private void correctSpellingOfTheTimeTextName() {
        char[] lastDigitHours = String.valueOf(hours).toCharArray();
        char[] lastDigitMinutes = String.valueOf(minutes).toCharArray();
        char[] lastDigitSeconds = String.valueOf(seconds).toCharArray();
        char[] lastDigitHMS = String.valueOf(amountOfTime).toCharArray();

        setTextHours(changeTextTime(lastDigitHours[lastDigitHours.length-1],hours,"час"));
        setTextMinutes(changeTextTime(lastDigitMinutes[lastDigitMinutes.length-1],minutes,"минут"));
        setTextSeconds(changeTextTime(lastDigitSeconds[lastDigitSeconds.length-1],seconds,"секунд"));

        switch (HMS){
            case "час":
                setTextHMS(changeTextTime(lastDigitHMS[lastDigitHMS.length-1],amountOfTime,"час"));
                break;
            case "минута":
                setTextHMS(changeTextTime(lastDigitHMS[lastDigitHMS.length-1],amountOfTime,"минут"));
                break;
            case "секунда":
                setTextHMS(changeTextTime(lastDigitHMS[lastDigitHMS.length-1],amountOfTime,"секунд"));
                break;
        }

    }

    private String changeTextTime(char lastDigitOfTime, int fullTime, String textTime){

        if (textTime.equals("час")){
            if (lastDigitOfTime == '1' && fullTime!=11) return(textTime);
            else if (lastDigitOfTime > '1' && lastDigitOfTime < '5' && fullTime!=12
                    && fullTime!=13 && fullTime!=14) return(textTime + "а");
            else return(textTime+"ов");
        }else {
            if (lastDigitOfTime == '1' && fullTime!=11) return(textTime + "а");
            else if (lastDigitOfTime > '1' && lastDigitOfTime < '5' && fullTime!=12
                    && fullTime!=13 && fullTime!=14) return(textTime + "ы");
            else return(textTime);
        }
    }
}

