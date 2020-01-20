package filippov.vitaliy.poibms3_8;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import filippov.vitaliy.poibms3_8.Data.Events.CalendarEvents;
import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.ui.car.CarFragment;
import filippov.vitaliy.poibms3_8.ui.fuel.FuelFragment;
import filippov.vitaliy.poibms3_8.ui.fuel.FuelViewModel;
import filippov.vitaliy.poibms3_8.ui.tools.ToolsFragment;
import filippov.vitaliy.poibms3_8.ui.tools.ToolsViewModel;

public class Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle arguments = getIntent().getExtras();
        String type = arguments.getString("Type");
        int pos = arguments.getInt("Pos",0);
        if (savedInstanceState == null) {
            if(type.equals("Car")){
                CarFragment.curPos = pos;
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new CarFragment())
                        .commit();
                return;
            }
            if(type.equals("NewCar")){
                CarFragment.curPos = 0;
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new CarFragment())
                        .commit();
                return;
            }
            if(type.equals("Fuel")){
                FuelViewModel.currentEventPos = pos;
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new FuelFragment())
                        .commit();
                return;
            }
            if(type.equals("Service")){
                ToolsViewModel.currentEventPos = pos;
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new ToolsFragment())
                        .commit();
                return;
            }
        }
    }


}
