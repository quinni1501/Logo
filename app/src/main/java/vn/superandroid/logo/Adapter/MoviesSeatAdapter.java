package vn.superandroid.logo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.superandroid.logo.Activities.MoviesSeatViewHolder;
import vn.superandroid.logo.R;

public class MoviesSeatAdapter extends RecyclerView.Adapter<MoviesSeatViewHolder> {
    private List<String> seatList;

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
}