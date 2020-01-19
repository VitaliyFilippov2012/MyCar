package filippov.vitaliy.poibms3_8.ui.fuel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import filippov.vitaliy.poibms3_8.R;


public class FuelFragment extends Fragment {

    String[] typeFuel = {"Бензин АИ-98", "Бензин АИ-95", "Бензин АИ-92", "Бензин АИ-98", "Бензин АИ-Super", "Бензин АИ-100", "Дизель", "Пропан", "Метан", "СПГ", "Электричество"};//xml or json
    private FuelViewModel fuelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fuelViewModel =
                ViewModelProviders.of(this).get(FuelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fuel, container, false);
        AutoCompleteTextView autoCompleteTextView = root.findViewById(R.id.type_fuel);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(root.getContext(), R.layout.support_simple_spinner_dropdown_item, typeFuel);
        autoCompleteTextView.setAdapter(adapter);
        return root;
    }
}
