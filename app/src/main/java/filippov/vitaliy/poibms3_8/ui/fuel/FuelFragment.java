package filippov.vitaliy.poibms3_8.ui.fuel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import filippov.vitaliy.poibms3_8.Base.Constants;
import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;


public class FuelFragment extends Fragment {

    EditText costs;
    EditText dateEvents;
    EditText typeFuel;
    EditText quantity;
    EditText mileage;
    EditText comments;
    Button save;
    Button delete;
    private FuelViewModel fuelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fuelViewModel =
                ViewModelProviders.of(this).get(FuelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fuel, container, false);
        AutoCompleteTextView autoCompleteTextView = root.findViewById(R.id.type_fuel);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(root.getContext(), R.layout.support_simple_spinner_dropdown_item, Constants.typeFuel);
        autoCompleteTextView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setConrol(view);
        //setInfoToControl(view);
    }

    private void setConrol(View v){
        typeFuel = v.findViewById(R.id.type_fuel);
        quantity = v.findViewById(R.id.volume_fuel);
        costs = v.findViewById(R.id.cost_fuel);
        mileage = v.findViewById(R.id.mileage);
        comments = v.findViewById(R.id.comment);
        save = v.findViewById(R.id.clear);
        delete = v.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearControl();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearControl();
            }
        });
    }

    private void setInfoToControl(Event e){
        if (e != null) {
            typeFuel.setText(e.getTypeFuel());
            quantity.setText(e.getVolume());
            costs.setText(String.valueOf(e.getCost()));
            mileage.setText(String.valueOf(e.getMileage()));
            comments.setText(e.getComment());
        }
    }

    private Event getInfoInControl(){
        Event e = new Event(
                "Fuel",
                Integer.valueOf(costs.getText().toString()),
                Long.valueOf(mileage.getText().toString()),
                comments.getText().toString(),
                dateEvents.getText().toString(),
                typeFuel.getText().toString(),
                Integer.valueOf(quantity.getText().toString())
        );
        return e;
    }

    private void clearControl(){
        typeFuel.setText("");
        quantity.setText("");
        costs.setText("");
        mileage.setText("");
        comments.setText("");
        getActivity().getSupportFragmentManager().popBackStack();
    }

}
