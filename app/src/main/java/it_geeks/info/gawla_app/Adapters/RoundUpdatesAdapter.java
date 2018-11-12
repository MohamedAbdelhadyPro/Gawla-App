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

import java.util.List;

import it_geeks.info.gawla_app.Models.RoundUpdate;
import it_geeks.info.gawla_app.R;

public class RoundUpdatesAdapter extends RecyclerView.Adapter<RoundUpdatesAdapter.ViewHolder> {

    private Context context;
    private List<RoundUpdate> roundUpdateList;

    public RoundUpdatesAdapter(Context context, List<RoundUpdate> roundUpdateList) {
        this.context = context;
        this.roundUpdateList = roundUpdateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_round_update, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RoundUpdate roundUpdate = roundUpdateList.get(i);

        Picasso.with(context)
                .load(roundUpdate.getUpdateImage())
                .placeholder(context.getResources().getDrawable(R.drawable.flag_egypt))
                .into(viewHolder.imRoundUpdateImage);

        viewHolder.tvRoundUpdateSubject.setText(roundUpdate.getUpdateSubject());
        viewHolder.tvRoundUpdateTime.setText(roundUpdate.getUpdateTime());
    }

    @Override
    public int getItemCount() {
        return roundUpdateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRoundUpdateSubject, tvRoundUpdateTime;
        ImageView imRoundUpdateImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRoundUpdateSubject = itemView.findViewById(R.id.round_update_subject);
            tvRoundUpdateTime = itemView.findViewById(R.id.round_update_time);
            imRoundUpdateImage = itemView.findViewById(R.id.round_update_image);
        }
    }
}
