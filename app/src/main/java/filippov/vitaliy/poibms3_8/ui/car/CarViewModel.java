package filippov.vitaliy.poibms3_8.ui.car;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;
import java.util.UUID;

import filippov.vitaliy.poibms3_8.Base.DataBase.DBHelper;
import filippov.vitaliy.poibms3_8.Data.Car;

public class CarViewModel extends ViewModel {
    private MutableLiveData<Car[]> mText;

    private Car currentCar;
    SQLiteDatabase db;
    Context mContext;
    public static int maxId = 0;
    public static void setCurPos(int curPos) {
        CurPos = curPos;
    }

    public static int getCurPos() {
        return CurPos;
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
        mContext = context;
        db = DBHelper.getInstance(context).getReadableDatabase();
        Cursor userCursor = db.rawQuery("SELECT * FROM view_cars ", null);
        if (userCursor.getCount() > 0) {
            cars = new Car[userCursor.getCount()];
            userCursor.moveToFirst();
            int i = 0;
            while (!userCursor.isClosed()) {
                cars[i] = new Car(userCursor.getString(0), userCursor.getString(1),userCursor.getInt(2),userCursor.getLong(3));
                if(maxId < userCursor.getInt(8))
                    maxId = userCursor.getInt(8);
                cars[i].setId(userCursor.getInt(8));
                if (!userCursor.isLast()) {
                    userCursor.moveToNext();
                } else {
                    userCursor.close();
                }
                i++;
            }
            mText.setValue(cars);
        } else {
            Toast.makeText(context, "Добавьте машину", Toast.LENGTH_SHORT).show();
        }
    }

    public Car GetCar(int id){
        Cursor cursor = db.rawQuery("SELECT * FROM view_cars Where idCar = "+id+" ",null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            Car c = new Car(cursor.getString(0), cursor.getString(1),cursor.getInt(2),
                cursor.getLong(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7)
                    );
            currentCar = c;
            setCurPos(c.getId());
            c.setId(cursor.getInt(8));

            cursor.close();
            return c;
        }
        return null;
    }

    public Car UpdateCar(Car car){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Model",car.getModel());
        contentValues.put("Mark",car.getMark());
        contentValues.put("YearIssue",car.getYearOfIssue());
        int g = db.update("Cars", contentValues, "IdCar = ?",new String[] { String.valueOf(car.getId())});
        ContentValues contentValue = new ContentValues();
        contentValue.put("TypeEngine",car.getTypeEngine());
        contentValue.put("TypeTrans",car.getTypeTransmission());
        contentValue.put("VIN",car.getVIN());
        contentValue.put("Comment",car.getComment());
        contentValue.put("Mileage",car.getMileage());
        int d = db.update("CarsInfo", contentValue, "_idCar = ?",new String[] { String.valueOf(car.getId())});
        return GetCar(car.getId());
    }

    public void InsertCar(Car car){
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdCar",maxId+1);
        contentValues.put("Model",car.getModel());
        contentValues.put("Mark",car.getMark());
        contentValues.put("YearIssue",car.getYearOfIssue());
        db.insert("Cars",null, contentValues);
        ContentValues contentValue = new ContentValues();
        contentValue.put("_idCar",maxId+1);
        contentValue.put("TypeEngine",car.getTypeEngine());
        contentValue.put("TypeTrans",car.getTypeTransmission());
        contentValue.put("VIN",car.getVIN());
        contentValue.put("Comment",car.getComment());
        contentValue.put("Mileage",car.getMileage());
        db.insert("CarsInfo",null, contentValue);
        LoadCars(mContext);
    }

    public void DeleteCar(Car car){
        db.delete("CarsInfo", "_idCar = ?",new String[] { String.valueOf(car.getId())});
        db.delete("Cars",  "IdCar = ?",new String[] { String.valueOf(car.getId())});
        LoadCars(mContext);
    }
}
