package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Класс подсчитывает количество нестандартных (2 через 2)
// рабочий и выходных дней и показывает таблицу из 8 недель
@Data
public class WorkingDaysAndWeekends extends DateDifference {

    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}", message = "Обрати внимание на формат ===> дд.мм.гггг")
    private String dateString;
    private static LocalDate localDate;
    private static LocalDate mondayDate;

    private int numberOfWorkingDays;
    private int numberOfWeekends;

    List<Integer> listWorkingDaysAndWeekends = new ArrayList<Integer>();

    Integer[] numbersFromOneToFifteen_1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    Integer[] numbersFromOneToFifteen_2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public WorkingDaysAndWeekends() {
    }

    // Метод конвертирует дату и запускает цикл подсчета дней
    public void theResultOfWorkingWithTime() {
        localDate = dateConversionInLocalDate(dateString);
        mondayDate = getDayOfWeekMonday(localDate);
        starTheCycleOfCountingDays();
    }

    // Метод получает первый прошедший понедельник из исходной даты, так как в таблице ровные 8 недель
    public LocalDate getDayOfWeekMonday(LocalDate date) {
        while (!(date.getDayOfWeek() == DayOfWeek.MONDAY)) {
            date = date.minusDays(1);
        }
        return date;
    }

    // Метод заполняет массив числами с понедельника до исходной даты,
    // а потом начинает подсчет рабочи и выходных дней в течение 8 недель.
    // В массиве цифрой "0" обозначаются не рабочие дни
    // В массиве цифрой "1" обозначаются выходные дни
    public void starTheCycleOfCountingDays() {
        LocalDate stopTheCycle = localDate.plusWeeks(8);
        countingDaysBeforeLocalDate();
        while (localDate.isBefore(stopTheCycle)) {
            countingWorkingDays();
            countingWeekends();
        }
    }

    // Метод вносит даты с понедельника до исходного числа
    // (Таблица начинается с понедельника, а исходная дата не обязана быть понедельником)
    public void countingDaysBeforeLocalDate() {
        while (!(mondayDate.getDayOfYear() == localDate.getDayOfYear())) {
            listWorkingDaysAndWeekends.add(0);
            listWorkingDaysAndWeekends.add(mondayDate.getDayOfMonth());
            mondayDate = mondayDate.plusDays(1);
        }
    }
    // Метод считает рабочие дни и заносит их в массив
    public void countingWorkingDays() {
        for (int i = 0; i < numberOfWorkingDays; i++) {
            listWorkingDaysAndWeekends.add( 1);
            listWorkingDaysAndWeekends.add(localDate.getDayOfMonth());
            localDate = localDate.plusDays(1);
        }
    }
    // Метод считает выходные дни и заносит их в массив
    public void countingWeekends() {
        for (int i = 0; i < numberOfWeekends; i++) {
            listWorkingDaysAndWeekends.add( 0);
            listWorkingDaysAndWeekends.add(localDate.getDayOfMonth());
            localDate = localDate.plusDays(1);
        }

    }
    // Метод преобразования таблицы в массив
    public int getDayFromList() {
        Integer day = listWorkingDaysAndWeekends.get(0);
        listWorkingDaysAndWeekends.remove(0);
        return day;
    }
}
