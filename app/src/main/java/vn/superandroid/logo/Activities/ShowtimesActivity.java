package vn.superandroid.logo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import vn.superandroid.logo.R;

public class ShowtimesActivity extends AppCompatActivity {

    Button gioBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtimes);

        //ánh xạ
        gioBtn = findViewById(R.id.btn920);
        gioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowtimesActivity.this, SeatsActivity.class); // Thay thế ShowtimesActivity bằng SeatsActivity
                startActivity(intent);
            }
        });
    }
}
