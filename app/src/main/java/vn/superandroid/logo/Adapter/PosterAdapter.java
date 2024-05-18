package vn.superandroid.logo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.superandroid.logo.Model.Poster;
import vn.superandroid.logo.R;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder> {

    private List<Poster> posters;

    public PosterAdapter(List<Poster> posters) {
        this.posters = posters;
    }

    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poster, parent, false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        Poster poster = posters.get(position);
        holder.posterImage.setImageResource(poster.getImageResId());
        holder.filmName.setText(poster.getFilmName());
    }

    @Override
    public int getItemCount() {
        return posters.size();
    }

    static class PosterViewHolder extends RecyclerView.ViewHolder {
        ImageView posterImage;
        TextView filmName;

        PosterViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImage = itemView.findViewById(R.id.posterImage);
            filmName = itemView.findViewById(R.id.filmName);
        }
    }
}
