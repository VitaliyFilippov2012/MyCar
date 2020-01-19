package filippov.vitaliy.poibms3_8;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import filippov.vitaliy.poibms3_8.ui.car.CarFragment;
import filippov.vitaliy.poibms3_8.ui.fuel.FuelFragment;
import filippov.vitaliy.poibms3_8.ui.tools.ToolsFragment;

public class Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String type = intent.getStringExtra("Type");
        int pos = intent.getIntExtra("Pos",0);
        if (savedInstanceState == null) {
            if(type.equals("Car")){
                CarFragment.curPos = pos;
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new CarFragment())
                        .commit();
                return;
            }
            if(type.equals("Fuel")){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new FuelFragment())
                        .commit();
                return;
            }
            if(type.equals("Service")){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new ToolsFragment())
                        .commit();
                return;
            }
        }
    }


}
