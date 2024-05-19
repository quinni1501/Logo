package vn.superandroid.logo.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.superandroid.logo.Adapter.MoviesSeatAdapter;
import vn.superandroid.logo.R;

public class SeatsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MoviesSeatAdapter adapter;
    private List<String> seatList;
    ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //ánh xạ
        backBtn = findViewById(R.id.backButton);
        recyclerView = findViewById(R.id.rvSeatsMoviesSeat);
        // Grid Layout là để hiển thị theo dạng cột, 1 hàng sẽ có 8 cột
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 8);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Giả lập danh sách các ghế
        seatList = new ArrayList<>();
        seatList.add("A1");
        seatList.add("A2");
        seatList.add("A3");
        seatList.add("A4");
        seatList.add("A5");
        seatList.add("A6");
        seatList.add("A7");
        seatList.add("A8");
        seatList.add("B1");
        seatList.add("B2");
        seatList.add("B3");
        seatList.add("B4");
        seatList.add("B5");
        seatList.add("B6");
        seatList.add("B7");
        seatList.add("B8");

        adapter = new MoviesSeatAdapter(seatList);
        recyclerView.setAdapter(adapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}