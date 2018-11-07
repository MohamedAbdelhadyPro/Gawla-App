package it_geeks.info.gawla_app.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import it_geeks.info.gawla_app.Models.Round;
import it_geeks.info.gawla_app.R;

public class RecentHalesAdapter extends RecyclerView.Adapter<RecentHalesAdapter.ViewHolder> {

    private Context context;
    private List<Round> roundsList = new ArrayList<>();

    public RecentHalesAdapter(Context context, List<Round> roundsList) {
        this.context = context;
        this.roundsList = roundsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_round, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Round round = roundsList.get(position);

        Picasso.with(context)
                .load(round.getProductImage())
                .placeholder(context.getResources().getDrawable(R.drawable.gawlalogo))
                .into(viewHolder.imgProductImage);

        viewHolder.tvProductName.setText(round.getProductName());
        viewHolder.tvProductCategory.setText(round.getProductCategory());
        viewHolder.tvProductPrice.setText(round.getProductPrice());
        viewHolder.tvStartTime.setText(round.getStartTime());
        viewHolder.tvEndTime.setText(round.getEndTime());
        viewHolder.tvMembersNumber.setText(round.getJoinedMembersNumber());
    }

    @Override
    public int getItemCount() {
        return roundsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductName, tvProductCategory, tvProductPrice, tvStartTime, tvEndTime, tvMembersNumber;
        ImageView imgProductImage;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProductImage = itemView.findViewById(R.id.round_product_image);
            tvProductName = itemView.findViewById(R.id.round_product_name);
            tvProductCategory = itemView.findViewById(R.id.round_product_category);
            tvProductPrice = itemView.findViewById(R.id.round_product_price);
            tvStartTime = itemView.findViewById(R.id.round_start_time);
            tvEndTime = itemView.findViewById(R.id.round_end_time);
            tvMembersNumber = itemView.findViewById(R.id.round_members_number);
        }
    }
}
