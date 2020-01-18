package filippov.vitaliy.poibms3_8.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<Event[]> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(new Event[]{new Event("Мойка",1300000,"23.02.2000")});
    }

    public LiveData<Event[]> getText() {
        return mText;
    }
}