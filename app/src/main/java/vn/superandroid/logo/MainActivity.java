package vn.superandroid.logo;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout indicatorLayout;
    private Handler handler;
    private Runnable runnable;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        indicatorLayout = findViewById(R.id.indicatorLayout);

        // Start auto-flipping
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentPage = (currentPage + 1) % 3;
                viewPager.setCurrentItem(currentPage);
                updateIndicators();
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        // Initial indicator update
        updateIndicators();

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

    private void updateIndicators() {
        for (int i = 0; i < 3; i++) {
            ImageView indicator = (ImageView) indicatorLayout.getChildAt(i);
            if (indicator != null) {
                indicator.setBackgroundResource(currentPage == i ? R.drawable.indicator_active : R.drawable.indicator_inactive);
            }
        }
    }
}