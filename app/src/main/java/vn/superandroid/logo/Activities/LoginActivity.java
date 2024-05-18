package vn.superandroid.logo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.superandroid.logo.Model.User;
import vn.superandroid.logo.R;
import vn.superandroid.logo.SharedPrefManager;
import vn.superandroid.logo.api.RetrofitClient;
import vn.superandroid.logo.api.UserService;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout layoutSignUp;
    private Button continueBtn;
    private EditText edtUsername, edtPassword;
    private List<User> mListUsers;
    UserService userService;
    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mListUsers = new ArrayList<>();
        initUI();
        initListener();
        getListUsers();
    }
    private void getListUsers() {
        //Gọi Interface trong UserService
        userService = RetrofitClient.getRetrofit().create(UserService.class);
        userService.getListUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    mListUsers = response.body(); //nhận mảng Users
                } else {
                    int statusCode = response.code();
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("logg", t.getMessage());
            }
        });
    }
    //Ánh xạ
    private void initUI() {
        layoutSignUp = findViewById(R.id.layout_sign_up);
        continueBtn = findViewById(R.id.continueButton);
        edtUsername = findViewById(R.id.editTextUsername);
        edtPassword = findViewById(R.id.editTextPassword);
    }

    private void initListener() {
        //Nhấn SignUp
        layoutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                finish();
                startActivity(intent);
            }
        });
        //Nhấn Login
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListUsers == null || mListUsers.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "List rỗng", Toast.LENGTH_SHORT).show();
                }
                String strUsername = edtUsername.getText().toString().trim();
                String strPassword = edtPassword.getText().toString().trim();
                //User chưa nhập Username
                if (strUsername.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập Username", Toast.LENGTH_SHORT).show();
                }
                //User chưa nhập Password
                else if (strPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập Password", Toast.LENGTH_SHORT).show();
                }
                //everthing is fine
                else if (edtUsername.getText() != null && edtPassword.getText() != null) {
                    //check username và password trong mảng
                    boolean isHasUser = false;
                    for (User user : mListUsers) {
                        if (strUsername.equals(user.getUsername()) && strPassword.equals(user.getPassword())) {
                            isHasUser = true;
                            mUser = user;
                            break;
                        }
                    }
                    if (isHasUser) {
                        SharedPrefManager sharedPrefManager = new SharedPrefManager(LoginActivity.this);
                        sharedPrefManager.setData(mUser);
                        //Chuyển vào MainActivity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        finish();
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
