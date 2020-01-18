package filippov.vitaliy.poibms3_8.ui.memento;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MementoViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public MementoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Fuel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
