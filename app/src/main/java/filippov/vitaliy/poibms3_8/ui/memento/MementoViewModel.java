package filippov.vitaliy.poibms3_8.ui.memento;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;

public class MementoViewModel extends ViewModel {
    private MutableLiveData<Event[]> mText;

    public MementoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(new Event[]{new Event("Сервис",1300000,"23.02.2000")});
    }

    public LiveData<Event[]> getText() {
        return mText;
    }
}
