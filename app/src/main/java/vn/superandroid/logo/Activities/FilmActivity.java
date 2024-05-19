package vn.superandroid.logo.Activities;

import static vn.superandroid.logo.R.id.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;

import vn.superandroid.logo.R;

public class FilmActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to MainActivity
                Intent intent = new Intent(FilmActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Finish FilmActivity to remove it from the back stack
            }
        });

        ImageView[] posters = {
                findViewById(R.id.poster1), findViewById(R.id.poster2), findViewById(R.id.poster3),
                findViewById(R.id.poster4), findViewById(R.id.poster5), findViewById(R.id.poster6),
                findViewById(R.id.poster7), findViewById(R.id.poster8), findViewById(R.id.poster9)
        };

        String[] filmIds = {"f1", "f5", "f3", "f8", "f6", "f2", "f4", "f7", "f7"};
        String[] videoUrls = {
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20EXHUMA%20QU%E1%BA%ACT%20M%E1%BB%98%20TR%C3%99NG%20MA%20%20KC%2015032024_1080p.mp4?alt=media&token=f975106d-4677-4918-aa72-37b167dd311c",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20Godzilla%20X%20Kong%20The%20New%20Empire%20%20In%20Cinemas%20on%20March%2029_1080p.mp4?alt=media&token=daf48438-1ce8-4c2e-bd57-9ebaabcebee3",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20The%20First%20Omen%20%20Official%20Trailer%20%2020th%20Century%20Studios_1080p.mp4?alt=media&token=1f39b43e-9d9a-4525-86be-dc880272cba4",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20Minions%20The%20Rise%20of%20Gru%20%20Official%20Trailer%203%20HD_1080p.mp4?alt=media&token=d338c01c-b591-454d-9459-aca612aef923",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20MAI%20%20First%20Look%20Trailer%20%20PHIM%20T%E1%BA%BET%202024%20C%E1%BB%A6A%20TR%E1%BA%A4N%20TH%C3%80NH_1080p.mp4?alt=media&token=32742322-748e-45a1-bf2b-cdf8fa19dad6",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20Mission%20Impossible%20%20Dead%20Reckoning%20Part%20One%20%20Final%20Trailer%202023%20Movie%20%20Tom%20Cruise_1080p.mp4?alt=media&token=9cec7491-8a1d-44d1-9cab-3620c3f09df7",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/y2mate.com%20-%20L%E1%BA%ACT%20M%E1%BA%B6T%207%20M%E1%BB%98T%20%C4%90I%E1%BB%80U%20%C6%AF%E1%BB%9AC%20%20TEASER%20TRAILER%20%20Kh%E1%BB%9Fi%20Chi%E1%BA%BFu%2026042024_1080p.mp4?alt=media&token=32f5ab48-ac5a-4b0c-8f70-c8fd9144974f",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/One%20Piece%20Film%20Red%20-%20Official%20Trailer%20(2022)%20English%20Subtitles.mp4?alt=media&token=d2c0950a-5dd9-422b-b78b-f5d89eb7f3d2",
                "https://firebasestorage.googleapis.com/v0/b/film-f8b47.appspot.com/o/One%20Piece%20Film%20Red%20-%20Official%20Trailer%20(2022)%20English%20Subtitles.mp4?alt=media&token=d2c0950a-5dd9-422b-b78b-f5d89eb7f3d2"
        };

        for (int i = 0; i < posters.length; i++) {
            final String filmId = filmIds[i];
            final String videoUrl = videoUrls[i];

            posters[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FilmActivity.this, FilmDetailActivity.class);
                    intent.putExtra("FILM_ID", filmId);
                    intent.putExtra("VIDEO_URL", videoUrl);
                    startActivity(intent);
                }
            });
        }
    }


}