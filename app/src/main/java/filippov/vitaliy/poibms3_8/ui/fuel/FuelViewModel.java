package filippov.vitaliy.poibms3_8.ui.fuel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import filippov.vitaliy.poibms3_8.Data.Events.Event;

public class FuelViewModel extends ViewModel {
    private MutableLiveData<Event[]> mText;

    public FuelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(new Event[]{new Event("Fuel",1300000,"23.02.2000")});
    }

    public LiveData<Event[]> getText(Context context) {
        return mText;
    }
}
