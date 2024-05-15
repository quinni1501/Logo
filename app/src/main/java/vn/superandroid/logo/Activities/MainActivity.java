package vn.superandroid.logo.Activities;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import vn.superandroid.logo.DepthPageTransformer;
import vn.superandroid.logo.ImagesViewPager2Adapter;
import vn.superandroid.logo.Model.Images;
import vn.superandroid.logo.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList1;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == imagesList1.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // anh xa viewpager2
        viewPager2 = findViewById(R.id.viewpage2);
        circleIndicator3 = findViewById(R.id.circle_indicator3);
        imagesList1 = getListImages();
        ImagesViewPager2Adapter adapter1 = new ImagesViewPager2Adapter(imagesList1);
        viewPager2.setAdapter(adapter1);
        //Liên kết viewpager2 và indicator3
        circleIndicator3.setViewPager(viewPager2);
        //lắng nghe viewpager chuyển trang
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);
            }
        });
        //viewpager2 transformers
        //viewPager2.setPageTransformer(new ZoomOutPageTransformer());
        viewPager2.setPageTransformer(new DepthPageTransformer());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                }
                return false;
            }
        });
    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.banner1));
        list.add(new Images(R.drawable.banner2));
        list.add(new Images(R.drawable.banner3));
        return list;
    }
}