package filippov.vitaliy.poibms3_8.ui.tools;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import filippov.vitaliy.poibms3_8.Data.Events.CalendarEvents;
import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<Event[]> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<Event[]> getText(Context context) {
        Event[] e = CalendarEvents.getEvents().toArray(new Event[]{});
        mText.setValue(e);
        return mText;
    }
}