package filippov.vitaliy.poibms3_8.ui.car;


import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import filippov.vitaliy.poibms3_8.Data.Car;
import filippov.vitaliy.poibms3_8.R;


public class CarFragment extends Fragment {

    EditText model;
    EditText mark;
    EditText yearIssue;
    EditText typeEngine;
    EditText transmission;
    EditText mileage;
    EditText vin;
    EditText comments;
    Button save;
    Button delete;
    private CarViewModel carViewModel;
    public static int curPos = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        carViewModel =
                ViewModelProviders.of(this).get(CarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_car, container, false);
        carViewModel.LoadCars(this.getContext());
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setConrol(view);
        setInfoToControl(carViewModel.GetCar(curPos));
    }


    private void setConrol(View v){
        model = v.findViewById(R.id.model);
        mark = v.findViewById(R.id.mark);
        yearIssue = v.findViewById(R.id.year_issue);
        typeEngine = v.findViewById(R.id.type_engine);
        transmission = v.findViewById(R.id.type_transmission);
        mileage = v.findViewById(R.id.mileage);
        vin = v.findViewById(R.id.vin);
        comments = v.findViewById(R.id.comment);
        save = v.findViewById(R.id.save);
        delete = v.findViewById(R.id.delete);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInfoToControl(carViewModel.UpdateCar(getInfoInControl()));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carViewModel.DeleteCar(getInfoInControl());
                clearControl();
            }
        });
    }

    private void setInfoToControl(Car car){
        if (car != null) {
            model.setText(car.getModel());
            mark.setText(car.getMark());
            yearIssue.setText(String.valueOf(car.getYearOfIssue()));
            typeEngine.setText(car.getTypeEngine());
            transmission.setText(car.getTypeTransmission());
            mileage.setText(String.valueOf(car.getMileage()));
            vin.setText(car.getVIN());
            comments.setText(car.getComment());
        }
    }

    private Car getInfoInControl(){
        Car car = new Car(
            model.getText().toString(),
            mark.getText().toString(),
                Integer.valueOf(yearIssue.getText().toString()),
                Long.valueOf(mileage.getText().toString()),
            typeEngine.getText().toString(),
            transmission.getText().toString(),
            vin.getText().toString(),
            comments.getText().toString()
        );
        car.setId(curPos);
        return car;
    }

    private void clearControl(){
            model.setText("");
            mark.setText("");
            yearIssue.setText("");
            typeEngine.setText("");
            transmission.setText("");
            mileage.setText("");
            vin.setText("");
            comments.setText("");
    }
}
