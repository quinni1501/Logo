package vn.superandroid.logo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.superandroid.logo.Model.User;
import vn.superandroid.logo.R;
import vn.superandroid.logo.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity {
    Button btnLogout;
    TextView tvFullname, tvGender, tvEmail, tvPhone;
    User user;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initUI();
        showUserInfo();
        initListener();
    }

    private void initListener() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager = new SharedPrefManager(getApplicationContext());
                sharedPrefManager.clearUser();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showUserInfo() {
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        user = sharedPrefManager.getData();
        tvFullname.setText(user.getUserFullname());
        tvGender.setText(user.getUserGender());
        tvEmail.setText(user.getUserEmail());
        tvPhone.setText(user.getUserPhone());
    }

    private void initUI() {
        tvFullname = findViewById(R.id.tvFullname);
        tvGender = findViewById(R.id.tvGender);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone =findViewById(R.id.tvPhone);
        btnLogout = findViewById(R.id.logoutBtn);
    }
}