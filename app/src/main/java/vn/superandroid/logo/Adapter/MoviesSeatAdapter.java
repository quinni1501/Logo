package vn.superandroid.logo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import vn.superandroid.logo.R;

public class MoviesSeatAdapter extends RecyclerView.Adapter<MoviesSeatAdapter.MoviesSeatViewHolder> {
    private List<String> seatList;
    public int selected=0;
    public MoviesSeatAdapter(List<String> seatList) {
        this.seatList = seatList;
    }
    @NonNull
    @Override
    public MoviesSeatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_movies_seat_list, parent, false);
        return new MoviesSeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesSeatViewHolder holder, int position) {
        String seat = seatList.get(position);
        holder.tvSeatTypeCinemaSeat.setText(seat);

        // Bạn có thể thiết lập hình ảnh hoặc các thuộc tính khác cho ghế tại đây
        holder.ivSeatCinemaSeat.setImageResource(R.drawable.chair_available);
    }

    @Override
    public int getItemCount() {
        return seatList.size();
    }
    public class MoviesSeatViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivSeatCinemaSeat;
        public TextView tvSeatTypeCinemaSeat;
        public LinearLayout linearLayout;
        public Boolean status;

        public MoviesSeatViewHolder(View itemView) {
            super(itemView);
            ivSeatCinemaSeat = itemView.findViewById(R.id.ivSeatCinemaSeat);
            tvSeatTypeCinemaSeat = itemView.findViewById(R.id.tvSeatTypeCinemaSeat);
            linearLayout = itemView.findViewById(R.id.seatList);
            status = false;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (status) {
                        linearLayout.setBackgroundResource(R.color.black);
                        selected=selected-1;
                    } else {
                        linearLayout.setBackgroundResource(R.color.green);
                        selected=selected+1;
                    }
                    status = !status;
                }
            });
        }
    }
}