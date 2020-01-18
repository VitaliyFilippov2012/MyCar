package filippov.vitaliy.poibms3_8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import filippov.vitaliy.poibms3_8.Data.Events.Event;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

private Event[] itemsData;

public MyAdapter(Event[] itemsData) {
        this.itemsData = itemsData;
        }

// Create new views (invoked by the layout manager)
@Override
public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item, null);
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
        }

// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.date.setText(itemsData[position].getDateEvent());
    viewHolder.meliage.setText(itemsData[position].getMileage());
    viewHolder.text.setText(itemsData[position].getNameEvent());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getTypeEvent());
        }

// inner class to hold a reference to each item of RecyclerView
public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView meliage;
    public TextView text;
    public TextView date;
    public ImageView imgViewIcon;

    public ViewHolder(View itemLayoutView) {
        super(itemLayoutView);
        text = (TextView) itemLayoutView.findViewById(R.id.data);
        date = (TextView) itemLayoutView.findViewById(R.id.date_);
        meliage = (TextView) itemLayoutView.findViewById(R.id.meliage);
        imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.image);
    }
}
    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}