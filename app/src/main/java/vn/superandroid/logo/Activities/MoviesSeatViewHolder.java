package vn.superandroid.logo.Activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import vn.superandroid.logo.R;

public class MoviesSeatViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivSeatCinemaSeat;
    public TextView tvSeatTypeCinemaSeat;

    public MoviesSeatViewHolder(View itemView) {
        super(itemView);
        ivSeatCinemaSeat = itemView.findViewById(R.id.ivSeatCinemaSeat);
        tvSeatTypeCinemaSeat = itemView.findViewById(R.id.tvSeatTypeCinemaSeat);
    }
}