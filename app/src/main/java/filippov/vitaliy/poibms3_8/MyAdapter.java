package filippov.vitaliy.poibms3_8;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ConcurrentModificationException;
import java.util.zip.Inflater;

import filippov.vitaliy.poibms3_8.Data.Events.Event;
import filippov.vitaliy.poibms3_8.ui.fuel.FuelFragment;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Event[] itemsData;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Event[] itemsData,Context context) {
        this.itemsData = itemsData;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        viewHolder.date.setText(itemsData[position].getDateEvent());
        viewHolder.meliage.setText(itemsData[position].getMileage());
        viewHolder.text.setText(itemsData[position].getNameEvent());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getTypeEvent());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                View view = inflater.inflate(R.layout.fragment_fuel, null);
//                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setIcon(R.drawable.ic_add_circle_outline_black_24dp)
//                        .setTitle("VVV")
//                        .setView(view).setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                    }
//                });
//                builder.create().show();
                Intent intent = new Intent(context, Page.class);
                context.startActivity(intent);

            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

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