package filippov.vitaliy.poibms3_8.ui;

import android.text.format.DateUtils;
import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateViewModel extends ViewModel {
    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private MutableLiveData<String> mText;

    public DateViewModel() {
        mText = new MutableLiveData<>();
        Date date = new Date();
        setText(date.getTime());
    }

    public LiveData<String> getText() {
        return mText;
    }

    private String ConvertDateToString(long dateAndTime){
        return dateFormat.format(dateAndTime);
    }

    public void setText(long dateAndTime){
        mText.setValue(ConvertDateToString(dateAndTime));
    }
}
