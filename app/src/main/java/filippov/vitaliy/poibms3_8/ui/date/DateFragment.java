package filippov.vitaliy.poibms3_8.ui.date;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import java.util.Calendar;
import filippov.vitaliy.poibms3_8.R;


public class DateFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Calendar dateAndTime = Calendar.getInstance();
    private Context context;
    private DateViewModel dateViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dateViewModel =
                ViewModelProviders.of(this).get(DateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_date, container, false);
        final TextView textView = root.findViewById(R.id.date_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(v);
            }
        });
        dateViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void setDate(View v) {
        new DatePickerDialog(context, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void setInitialDateTime() {
        long dateTime =  dateAndTime.getTimeInMillis();
        dateViewModel.setText(dateTime);
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
}
