package vn.superandroid.logo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import vn.superandroid.logo.R;

public class ShowtimesActivity extends AppCompatActivity {

    Button gioBtn;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtimes);

        //ánh xạ
        gioBtn = findViewById(R.id.btn920);
        backButton = findViewById(R.id.backButton);
        gioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowtimesActivity.this, SeatsActivity.class); // Thay thế ShowtimesActivity bằng SeatsActivity
                startActivity(intent);
            }
        });
       backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
