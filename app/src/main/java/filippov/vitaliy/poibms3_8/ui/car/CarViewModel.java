package filippov.vitaliy.poibms3_8.ui.car;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import filippov.vitaliy.poibms3_8.Base.DataBase.DBHelper;
import filippov.vitaliy.poibms3_8.Data.Car;

public class CarViewModel extends ViewModel {
    private MutableLiveData<Car[]> mText;

    private Car currentCar;

    public void setCurPos(int curPos) {
        CurPos = curPos;
    }

    public static int CurPos = 0;
    public CarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(new Car[]{});
    }

    public LiveData<Car[]> getText(Context context) {
        LoadCars(context);
        return mText;
    }

    public void LoadCars(Context context){
        Car[] cars;
        SQLiteDatabase db = DBHelper.getInstance(context).getReadableDatabase();
        Cursor userCursor = db.rawQuery("SELECT * FROM view_cars ", null);
        if (userCursor.getCount() > 0) {
            cars = new Car[userCursor.getCount()];
            userCursor.moveToFirst();
            int i = 0;
            while (!userCursor.isClosed()) {
                cars[i] = new Car(userCursor.getString(0), userCursor.getString(1),userCursor.getInt(2),userCursor.getLong(3));
                if (!userCursor.isLast()) {
                    userCursor.moveToNext();
                } else {
                    userCursor.close();
                }
                i++;
            }
            mText.setValue(cars);
            currentCar = cars[CurPos];
            Toast.makeText(context, currentCar.getMark()+" " +currentCar.getModel(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Добавьте машину", Toast.LENGTH_SHORT).show();
        }
    }
}
