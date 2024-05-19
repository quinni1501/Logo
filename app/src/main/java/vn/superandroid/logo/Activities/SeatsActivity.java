package vn.superandroid.logo.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        recyclerView = findViewById(R.id.rvSeatsMoviesSeat);
        // Grid Layout là để hiển thị theo dạng cột á, 1 hàng sẽ có 8 cột
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

        adapter = new MoviesSeatAdapter(seatList);
        recyclerView.setAdapter(adapter);
    }
}