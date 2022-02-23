package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

@Data
public class ObjectPharmacyCalculation {

    int colorLine;
    int day;
    int amountOfRevenueForDay;
    int amountOfSTMForDay;

    public ObjectPharmacyCalculation(int colorLine, int days, int amountOfRevenueForDay, int amountOfSTMForDay) {
        this.colorLine = colorLine;
        this.day = days;
        this.amountOfRevenueForDay = amountOfRevenueForDay;
        this.amountOfSTMForDay = amountOfSTMForDay;
    }

}
