package vn.superandroid.logo.Activities;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vn.superandroid.logo.R;

public class FilmDetailActivity extends AppCompatActivity {

    private VideoView videoContainer;
    private Button playBtn,stopBtn;
    private TextView tvFilmName, tvGenre, tvYear, tvDuration, tvCountry, tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        FirebaseApp.initializeApp(this);

        // Initialize views
        videoContainer = findViewById(R.id.videoContainer);
        playBtn = (Button) findViewById(R.id.playBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        tvFilmName = findViewById(R.id.tvTitle);
        tvGenre = findViewById(R.id.tvGenres);
        tvYear = findViewById(R.id.tvYear);
        tvDuration = findViewById(R.id.tvTime);
        tvCountry = findViewById(R.id.tvCountry);
        tvRating = findViewById(R.id.tvRating);

        // Setup toolbar
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());

        String filmId = getIntent().getStringExtra("FILM_ID");
        String videoUrl = getIntent().getStringExtra("VIDEO_URL");

        // Fetch data from Firebase
        fetchDataFromFirebase(filmId, videoUrl);
    }

    private void fetchDataFromFirebase(String filmId, String videoUrl) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference filmRef = database.getReference("trailers").child(filmId);

        filmRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String title = snapshot.child("title").getValue(String.class);
                    String genres = snapshot.child("genres").getValue(String.class);
                    String year = snapshot.child("year").getValue(String.class);
                    String time = snapshot.child("time").getValue(String.class);
                    String country = snapshot.child("country").getValue(String.class);
                    String rating = snapshot.child("rating").getValue(String.class);
                    Log.d("Year", year);
                    // Update the views
                    tvFilmName.setText(title);
                    tvGenre.setText(genres);
                    tvYear.setText(year);
                    tvDuration.setText(time);
                    tvCountry.setText(country);
                    tvRating.setText(rating);

                    Uri videoUri = Uri.parse(videoUrl);

                    // Set video URI and start playing
                    videoContainer.setVideoURI(videoUri);
                    videoContainer.requestFocus();

                    playBtn.setOnClickListener(v -> videoContainer.start());
                    stopBtn.setOnClickListener(v -> videoContainer.pause());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle possible errors
            }
        });
    }
}