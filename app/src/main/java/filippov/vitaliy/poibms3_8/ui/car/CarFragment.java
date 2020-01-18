package filippov.vitaliy.poibms3_8.ui.car;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import filippov.vitaliy.poibms3_8.R;

public class CarFragment extends Fragment {

    private CarViewModel carViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        carViewModel =
                ViewModelProviders.of(this).get(CarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_car, container, false);
        return root;
    }
}
