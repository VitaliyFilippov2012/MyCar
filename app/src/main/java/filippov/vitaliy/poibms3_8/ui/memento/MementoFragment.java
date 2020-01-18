package filippov.vitaliy.poibms3_8.ui.memento;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;
import filippov.vitaliy.poibms3_8.RecycleFragment;


public class MementoFragment extends Fragment {

    private MementoViewModel mementoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mementoViewModel =
                ViewModelProviders.of(this).get(MementoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_memento, container, false);
        return root;
    }

    public LiveData<Event[]> getData() {
        return mementoViewModel.getText();
    }
}
