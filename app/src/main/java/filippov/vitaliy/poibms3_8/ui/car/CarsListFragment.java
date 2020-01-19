package filippov.vitaliy.poibms3_8.ui.car;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import filippov.vitaliy.poibms3_8.Data.Car;
import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;

public class CarsListFragment extends Fragment {
    private CarViewModel carViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        carViewModel =
                ViewModelProviders.of(this).get(CarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        return root;
    }

    public LiveData<Car[]> getData(Context context) {
        return carViewModel.getText(context);
    }
}
