package filippov.vitaliy.poibms3_8.ui.fuel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import filippov.vitaliy.poibms3_8.Data.Events.CalendarEvents;
import filippov.vitaliy.poibms3_8.Data.Events.Event;

public class FuelViewModel extends ViewModel {
    private MutableLiveData<Event[]> mText;

    public static int currentEventPos = 0;

    public FuelViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<Event[]> getText() {
        Event[] e = CalendarEvents.getEventByCategory("Fuel").toArray(new Event[]{});
        mText.setValue(e);
        return mText;
    }

    public void AddEvent(Event event){
        CalendarEvents.addEvent(event,true);
    }
}
