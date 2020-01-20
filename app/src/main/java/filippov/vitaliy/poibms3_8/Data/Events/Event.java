package filippov.vitaliy.poibms3_8.Data.Events;

import java.util.Date;

import filippov.vitaliy.poibms3_8.R;

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

    public Event(String nameEvent, long mileage, String dateEvent) {
        this.mileage = mileage;
        this.dateEvent = dateEvent;
        setTypeEvent(nameEvent);
    }

    public Event(String nameEvent, float cost, long mileage, String comment, String dateEvent, String typeFuel, int volume, String typeDetail, float costDetail) {
        setTypeEvent(nameEvent);
        this.cost = cost;
        this.mileage = mileage;
        this.comment = comment;
        this.dateEvent = dateEvent;
        this.typeFuel = typeFuel;
        this.volume = volume;
        this.typeDetail = typeDetail;
        this.costDetail = costDetail;
        
    }

    public Event(String nameEvent,  String typeDetail,float cost, long mileage, String comment, String dateEvent, float costDetail) {
        setTypeEvent(nameEvent);
        this.cost = cost;
        this.mileage = mileage;
        this.comment = comment;
        this.dateEvent = dateEvent;
        this.typeDetail = typeDetail;
        this.costDetail = costDetail;
    }

    public Event(String nameEvent, float cost, long mileage, String comment, String dateEvent, String typeFuel, int volume) {
        setTypeEvent(nameEvent);
        this.cost = cost;
        this.mileage = mileage;
        this.comment = comment;
        this.dateEvent = dateEvent;
        this.typeFuel = typeFuel;
        this.volume = volume;
    }

    public void setTypeEvent(String nameEvent) {
        this.nameEvent = nameEvent;
        if(nameEvent.toLowerCase().contains("wash")||nameEvent.toLowerCase().contains("мойка"))
            this.typeEvent = R.drawable.ic_local_car_wash_black_24dp;
        else if(nameEvent.toLowerCase().contains("fuel")||nameEvent.toLowerCase().contains("топливо")||nameEvent.toLowerCase().contains("заправка")||nameEvent.toLowerCase().contains("station") )
            this.typeEvent = R.drawable.ic_local_gas_station_black_24dp;
        else{
            this.typeEvent = R.drawable.ic_settings_black_24dp;
        }

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
        setTypeEvent(nameEvent);
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

    public boolean compareEvent(Event e) {
        return this.getDateEvent().equals(e.getDateEvent()) && this.getNameEvent().equals(e.getNameEvent());
    }
}
