package filippov.vitaliy.poibms3_8.Data.Events;

import filippov.vitaliy.poibms3_8.Data.Events.Event;

public class Service extends Event {
    String typeDetail;
    float costDetail;

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
}
