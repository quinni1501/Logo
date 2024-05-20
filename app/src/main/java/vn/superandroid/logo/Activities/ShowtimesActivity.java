package vn.superandroid.logo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import vn.superandroid.logo.R;

public class ShowtimesActivity extends AppCompatActivity {

    Button gioBtn1, gioBtn2, gioBtn3;
    ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtimes);

        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //ánh xạ
        gioBtn1 = findViewById(R.id.btn920);
        gioBtn2 = findViewById(R.id.btn9202);
        gioBtn3 = findViewById(R.id.btn9203);
        backBtn = findViewById(R.id.backButton);
        gioBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowtimesActivity.this, SeatsActivity.class); // Thay thế ShowtimesActivity bằng SeatsActivity
                startActivity(intent);
            }
        });

        gioBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowtimesActivity.this, SeatsActivity.class); // Thay thế ShowtimesActivity bằng SeatsActivity
                startActivity(intent);
            }
        });

        gioBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowtimesActivity.this, SeatsActivity.class); // Thay thế ShowtimesActivity bằng SeatsActivity
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
