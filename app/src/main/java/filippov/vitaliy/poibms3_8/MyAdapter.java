package filippov.vitaliy.poibms3_8;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import filippov.vitaliy.poibms3_8.Data.Car;
import filippov.vitaliy.poibms3_8.Data.Events.Event;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Event[] itemsData;
    private Car[]   itemsCar;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(LiveData<Event[]> itemsData, LiveData<Car[]> itemsCar, Context context) {
        this.itemsData = itemsData == null ? null:itemsData.getValue() ;
        this.context = context;
        this.itemsCar = itemsCar == null ? null:itemsCar.getValue();
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
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        if(itemsCar != null){
            String concat = itemsCar[position].getMark()+" "+itemsCar[position].getModel();
            viewHolder.date.setText(concat);
            viewHolder.meliage.setText(String.valueOf(itemsCar[position].getYearOfIssue()+"г."));
            viewHolder.text.setText(String.valueOf("Пробег: "+itemsCar[position].getMileage()+"км."));
            viewHolder.imgViewIcon.setImageResource(R.drawable.ic_directions_car_black_24dp);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = itemsCar[position].getId();
                    Intent intent = new Intent(context, Page.class);
                    intent.putExtra("Type","Car");
                    intent.putExtra("Pos",id);
                    context.startActivity(intent);
                }
            });
            return;
        }
        if(itemsData!=null){
            viewHolder.date.setText(itemsData[position].getDateEvent());
            viewHolder.meliage.setText(itemsData[position].getMileage());
            viewHolder.text.setText(itemsData[position].getNameEvent());
            viewHolder.imgViewIcon.setImageResource(itemsData[position].getTypeEvent());
            if(itemsData[position].getTypeEvent() == R.drawable.ic_local_gas_station_black_24dp){
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Page.class);
                        intent.putExtra("Type","Fuel");
                        context.startActivity(intent);
                    }
                });
            }
            else{
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Page.class);
                        intent.putExtra("Type","Service");
                        context.startActivity(intent);
                    }
                });
            }
        }
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

    @Override
    public int getItemCount() {
        return itemsData == null ? itemsCar.length:itemsData.length;
    }
}