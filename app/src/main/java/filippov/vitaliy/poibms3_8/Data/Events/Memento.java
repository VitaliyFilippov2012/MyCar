package filippov.vitaliy.poibms3_8.Data.Events;

public class Memento extends Event {

    public Service GetService(String _typeDetail,float _costDetail){
        Service service = new Service();
        service.comment = this.comment;
        service.cost = this.cost;
        service.dateEvent = this.dateEvent;
        service.mileage = this.mileage;
        service.nameEvent = this.nameEvent;
        service.comment = this.comment;
        service.costDetail = _costDetail;
        service.typeDetail = _typeDetail;
        return service;
    }

    public Refil GetService(String _typeFuel, int _volume, float _cost){
        Refil refil = new Refil();
        refil.comment = this.comment;
        refil.cost = _cost;
        refil.dateEvent = this.dateEvent;
        refil.mileage = this.mileage;
        refil.nameEvent = this.nameEvent;
        refil.comment = this.comment;
        refil.typeFuel = _typeFuel;
        refil.volume = _volume;
        return refil;
    }
}
