package filippov.vitaliy.poibms3_8.ui.date;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateViewModel extends ViewModel {
    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static MutableLiveData<String> mText;

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        DateViewModel.date = date;
    }

    private static String date = "20.01.2020";

    public DateViewModel() {
        mText = new MutableLiveData<>();
        Date date = new Date();
        this.setText(date.getTime());
    }

    public LiveData<String> getText() {
        setDate(mText.getValue());
        return mText;
    }

    public static String ConvertDateToString(long dateAndTime){
        return dateFormat.format(dateAndTime);
    }

    public static void SetText(long dateAndTime){
        mText.setValue(dateFormat.format(dateAndTime));

        setDate(mText.getValue());
    }

    public void setText(long dateAndTime){
        mText.setValue(ConvertDateToString(dateAndTime));
        setDate(mText.getValue());
    }
}
