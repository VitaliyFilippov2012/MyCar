package filippov.vitaliy.poibms3_8;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.ui.fuel.FuelsListFragment;
import filippov.vitaliy.poibms3_8.ui.memento.MementoFragment;
import filippov.vitaliy.poibms3_8.ui.tools.ToolsFragment;


public class RecycleFragment extends Fragment {

    private ToolsFragment mListenerT;
    private MementoFragment mListenerM;
    private FuelsListFragment mListenerF;

    private LiveData<Event[]> mData;
    public RecycleFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        try {
            if(fragment instanceof ToolsFragment)
            {
                mListenerT = (ToolsFragment)fragment;
                mData = mListenerT.getData();
                return;
            }
            if(fragment instanceof MementoFragment)
            {
                mListenerM = (MementoFragment)fragment;
                mData = mListenerM.getData();
                return;
            }
            if(fragment instanceof FuelsListFragment)
            {
                mListenerF = (FuelsListFragment)fragment;
                mData = mListenerF.getData();
                return;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
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

        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(mData.getValue());
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}
