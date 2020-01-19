package filippov.vitaliy.poibms3_8.Base.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="MyCar.db";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    static public synchronized DBHelper getInstance(Context context) {

        if (instance == null) {
            instance = new DBHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Cars");
        db.execSQL("drop table if exists CarsInfo");
        db.execSQL("drop table if exists HistoryMileage");
        db.execSQL("drop table if exists Events");
        db.execSQL("drop trigger if exists checkNewMileage");
        db.execSQL("drop trigger if exists addNewMileage");
        onCreate(db);
    }
}
