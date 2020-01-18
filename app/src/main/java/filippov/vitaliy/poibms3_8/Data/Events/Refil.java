package filippov.vitaliy.poibms3_8.Data.Events;

public class Refil extends Event {
    String typeFuel;
    int volume;

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
}
