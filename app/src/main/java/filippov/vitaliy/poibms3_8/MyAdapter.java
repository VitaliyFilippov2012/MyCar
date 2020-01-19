package filippov.vitaliy.poibms3_8;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import filippov.vitaliy.poibms3_8.Data.Events.Event;

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

    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}