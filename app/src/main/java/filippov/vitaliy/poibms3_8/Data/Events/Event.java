package filippov.vitaliy.poibms3_8.Data.Events;

import java.util.Date;

public class Event {
    String nameEvent;
    float cost;
    long mileage;
    String comment;
    String dateEvent;
    String typeFuel;
    int volume;
    String typeDetail;
    float costDetail;
    int typeEvent;

    public Event(String nameEvent, long mileage, String dateEvent, int typeEvent) {
        this.nameEvent = nameEvent;
        this.mileage = mileage;
        this.dateEvent = dateEvent;
        this.typeEvent = typeEvent;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    public float getCostDetail() {
        return costDetail;
    }

    public void setCostDetail(float costDetail) {
        this.costDetail = costDetail;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getMileage() {
        return String.valueOf(mileage);
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }
}
