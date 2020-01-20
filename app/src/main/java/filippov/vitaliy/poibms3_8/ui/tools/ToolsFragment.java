package filippov.vitaliy.poibms3_8.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import filippov.vitaliy.poibms3_8.Data.Events.CalendarEvents;
import filippov.vitaliy.poibms3_8.Data.Events.Category;
import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.R;
import filippov.vitaliy.poibms3_8.RecycleFragment;

public class ToolsFragment extends Fragment{

    EditText costs;
    EditText dateEvents;
    EditText typeDetail;
    EditText costDetail;
    EditText mileage;
    EditText comments;
    Button save;
    Button delete;
    private Spinner editCategory;
    private ToolsViewModel toolsViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tool, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        editCategory = view.findViewById(R.id.edit_event_category);
        setCategory(view);
        setConrol(view);
        setInfoToControl(CalendarEvents.getEventByPos(toolsViewModel.currentEventPos));
    }

    private void setCategory(View v){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, Category.getCategoryNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editCategory.setAdapter(adapter);
    }

    public LiveData<Event[]> getData(Context context) {
       return toolsViewModel.getText(context);
    }

    private void setConrol(View v){
        editCategory = v.findViewById(R.id.edit_event_category);
        typeDetail = v.findViewById(R.id.type_fuel);
        costDetail = v.findViewById(R.id.volume_fuel);
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
            editCategory.setSelection(Category.getPosItem(e.getNameEvent()));
            typeDetail.setText(e.getTypeFuel());
            costDetail.setText(String.valueOf(e.getVolume()));
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
                typeDetail.getText().toString(),
                Integer.valueOf(costDetail.getText().toString())
        );
        return e;
    }

    private void clearControl(){
        typeDetail.setText("");
        costDetail.setText("");
        costs.setText("");
        mileage.setText("");
        comments.setText("");
        getActivity().getSupportFragmentManager().popBackStack();
    }
}