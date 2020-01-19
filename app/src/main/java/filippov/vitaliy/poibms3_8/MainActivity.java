package filippov.vitaliy.poibms3_8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import filippov.vitaliy.poibms3_8.Base.Constants;
import filippov.vitaliy.poibms3_8.Base.DataBase.DBHelper;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cars, R.id.nav_fuels,
                R.id.nav_services,R.id.nav_events)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        LoadToSharedPreferences();
        LoadStringSets();

    }

    private void LoadToSharedPreferences(){
        SharedPreferences mSettings = getSharedPreferences("param", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        Set<String> set = new HashSet<String>();
        set.add("Бензин АИ-98");
        set.add("Бензин АИ-95");
        set.add("Бензин АИ-92");
        set.add("Бензин АИ-Super");
        set.add("Бензин АИ-100");
        set.add("Дизель");
        set.add("Пропан");
        set.add("Метан");
        set.add("СПГ");
        set.add("Электричество");
        editor.putStringSet("typeFuel", set);
        editor.apply();
        editor.commit();
    }

    private void LoadStringSets(){
        SharedPreferences mSettings = getSharedPreferences("param", Context.MODE_PRIVATE);
        Constants.typeFuel = mSettings.getStringSet("typeFuel",null).toArray(new String[]{});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
