package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.util.*;

import static java.util.Calendar.*;

@Data
public class PharmacyCalculation {

    private int amountOfRevenue;
    private int amountOfSTM;

    private String month;


    private List<ObjectPharmacyCalculation> objectPharmacyCalculation;

    private Queue<Integer> daysOfMonth;
    private Queue<Integer> dailyRevenueCalculation;
    private Queue<Integer> dailySTMCalculation;

    public PharmacyCalculation() {
    }

    public void getResult() {
        month = getFromLocalDateMonth();
        fillListWithObjectsPharmacyCalculation();
    }

    private String getFromLocalDateMonth() {
        int month = Calendar.getInstance().getTime().getMonth();

        switch (month) {
            case JANUARY:
                return "Январь";
            case FEBRUARY:
                return "Февраль";
            case MARCH:
                return "Март";
            case APRIL:
                return "Апрель";
            case MAY:
                return "Май";
            case JUNE:
                return "Июнь";
            case JULY:
                return "Июль";
            case AUGUST:
                return "Август";
            case SEPTEMBER:
                return "Сентябрь";
            case OCTOBER:
                return "Октябрь";
            case NOVEMBER:
                return "Ноябрь";
            case DECEMBER:
                return "Декабрь";
            default:
                return "текущий месяц";
        }
    }

    private void fillListWithObjectsPharmacyCalculation() {
        objectPharmacyCalculation = new ArrayList<>();

        int lastDayOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        int amountOfRevenueForDay = (int) Math.ceil((double) amountOfRevenue / lastDayOfMonth);
        int amountOfSTMForDay = (int) Math.ceil((double) amountOfSTM / lastDayOfMonth);

        for (int i = 1; i <= lastDayOfMonth; i++) {
            if (i % 2 == 0) objectPharmacyCalculation.add(new ObjectPharmacyCalculation(
                                       0,
                                               i,
                            amountOfRevenueForDay * i,
                               amountOfSTMForDay * i
                    ));
            else objectPharmacyCalculation.add(new ObjectPharmacyCalculation(
                                       1,
                                               i,
                            amountOfRevenueForDay * i,
                               amountOfSTMForDay * i
            ));
        }
    }

}
