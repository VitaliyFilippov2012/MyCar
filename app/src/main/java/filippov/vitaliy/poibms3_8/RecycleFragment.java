package filippov.vitaliy.poibms3_8;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import filippov.vitaliy.poibms3_8.Data.Events.Event;


public class RecycleFragment extends Fragment {

    Event[] itemsData;

    public RecycleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recycle, container, false);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data fro recycler view
        Event itemsData[] = {new Event("Fuel",200000,"23.02.2000",R.drawable.ic_local_gas_station_black_24dp),
                new Event("Fuel",200050,"23.02.2000",R.drawable.ic_local_gas_station_black_24dp),
                new Event("Service",200100,"23.02.2000",R.drawable.ic_settings_black_24dp),
                new Event("Fuel",200200,"23.02.2000",R.drawable.ic_local_gas_station_black_24dp),
                new Event("Service",200300,"23.02.2000",R.drawable.ic_settings_black_24dp),
                new Event("Fuel",200040,"23.02.2000",R.drawable.ic_local_gas_station_black_24dp)
        };


        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}
