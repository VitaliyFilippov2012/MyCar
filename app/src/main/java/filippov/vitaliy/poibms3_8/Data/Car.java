package filippov.vitaliy.poibms3_8.Data;

import java.util.UUID;


public class Car {
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    int id;
    String mark;
    String model;
    int yearOfIssue;
    String typeEngine;
    String typeTransmission;
    String VIN;
    String comment;
    long mileage;

    public Car(String model,String mark,  int yearOfIssue, long mileage, String typeEngine, String typeTransmission, String VIN, String comment) {
        this.mark = mark;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.typeEngine = typeEngine;
        this.typeTransmission = typeTransmission;
        this.VIN = VIN;
        this.comment = comment;
        this.mileage = mileage;
    }

    public Car(String model,String mark,  int yearOfIssue, long mileage) {
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

    public String getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(String typeTransmission) {
        this.typeTransmission = typeTransmission;
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }
}