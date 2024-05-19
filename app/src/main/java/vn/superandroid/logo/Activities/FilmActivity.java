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

        for (ImageView poster : posters) {
            poster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FilmActivity.this, FilmDetailActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


}