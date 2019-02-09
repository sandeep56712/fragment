package beangate.datta.fragmentexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> item_models;
    private Context context;

    public RecyclerViewAdapter(List<Item> item_models, Context context) {
        this.item_models = item_models;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Item item_model=item_models.get(i);
        ViewHolder.price.setText(item_model.getQid());
        ViewHolder.item.setText(item_model.getQemail());


    }
    @Override
    public int getItemCount() {
        return item_models.size();
    }



    public static class ViewHolder  extends RecyclerView.ViewHolder{
        public  static TextView   item;
        public static TextView price;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            item=itemView.findViewById(R.id.item);
            price=itemView.findViewById(R.id.price);

        }
    }
}