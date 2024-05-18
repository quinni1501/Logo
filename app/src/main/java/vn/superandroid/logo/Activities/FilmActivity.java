package vn.superandroid.logo.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import vn.superandroid.logo.Adapter.PosterAdapter;
import vn.superandroid.logo.DepthPageTransformer;
import vn.superandroid.logo.Model.Poster;
import vn.superandroid.logo.R;

public class FilmActivity extends AppCompatActivity {

    private ViewPager2 viewPager1, viewPager2, viewPager3;
    private CircleIndicator3 indicator1, indicator2, indicator3;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        // Initialize ViewPagers and Indicators
        viewPager1 = findViewById(R.id.viewPager1);
        indicator1 = findViewById(R.id.indicator1);

        viewPager2 = findViewById(R.id.viewPager2);
        indicator2 = findViewById(R.id.indicator2);

        viewPager3 = findViewById(R.id.viewPager3);
        indicator3 = findViewById(R.id.indicator3);

        // Setup ViewPagers with Indicators
        setupViewPager(viewPager1, indicator1, getPostersForPhimHayNhat());
        setupViewPager(viewPager2, indicator2, getPostersForTheLoai());
        setupViewPager(viewPager3, indicator3, getPostersForSapRaMat());

        // Create and start auto-scroll runnable for each ViewPager
        runnable = new Runnable() {
            @Override
            public void run() {
                autoScrollViewPager(viewPager1);
                autoScrollViewPager(viewPager2);
                autoScrollViewPager(viewPager3);
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private void setupViewPager(ViewPager2 viewPager, CircleIndicator3 indicator, List<Poster> posters) {
        PosterAdapter posterAdapter = new PosterAdapter(posters);
        viewPager.setAdapter(posterAdapter);
        indicator.setViewPager(viewPager);
        viewPager.setPageTransformer(new DepthPageTransformer());
    }

    private void autoScrollViewPager(ViewPager2 viewPager) {
        if (viewPager.getCurrentItem() < viewPager.getAdapter().getItemCount() - 1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        } else {
            viewPager.setCurrentItem(0);
        }
    }

    private List<Poster> getPostersForPhimHayNhat() {
        List<Poster> posters = new ArrayList<>();
        posters.add(new Poster(R.drawable.banner1, "Exhuma: Quật Mộ Trùng Ma"));
        posters.add(new Poster(R.drawable.banner2, "Godzilla And Kong: The New Empire"));
        posters.add(new Poster(R.drawable.banner3, "The First Omen: Điềm Báo Của Quỷ"));
        return posters;
    }

    private List<Poster> getPostersForTheLoai() {
        List<Poster> posters = new ArrayList<>();
        posters.add(new Poster(R.drawable.banner4, "MAI"));
        posters.add(new Poster(R.drawable.banner5, "Minions: The Rise Of Gru"));
        posters.add(new Poster(R.drawable.banner6, "One Piece Film: Red"));
        return posters;
    }

    private List<Poster> getPostersForSapRaMat() {
        List<Poster> posters = new ArrayList<>();
        posters.add(new Poster(R.drawable.banner7, "Mission: Impossible 7"));
        posters.add(new Poster(R.drawable.banner8, "Lật Mặt 7: Môt Điều Ước"));
        return posters;
    }
}