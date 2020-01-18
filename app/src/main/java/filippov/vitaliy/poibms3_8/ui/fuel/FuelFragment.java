package filippov.vitaliy.poibms3_8.ui.fuel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import filippov.vitaliy.poibms3_8.R;


public class FuelFragment extends Fragment {

    private FuelViewModel fuelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fuelViewModel =
                ViewModelProviders.of(this).get(FuelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fuel, container, false);
        return root;
    }
}
