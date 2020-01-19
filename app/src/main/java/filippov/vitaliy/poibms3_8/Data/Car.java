package filippov.vitaliy.poibms3_8.Data;

import java.util.UUID;


public class Car {
    String mark;
    String model;
    int yearOfIssue;
    long mileage;

    public Car(String mark, String model, int yearOfIssue, long mileage) {
        this.mark = mark;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.mileage = mileage;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }
}