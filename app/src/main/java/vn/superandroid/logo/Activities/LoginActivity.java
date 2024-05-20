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
//        getListUsers();
    }
    private void getListUsers() {
        //Gọi Interface trong UserService
        userService = RetrofitClient.getRetrofit().create(UserService.class);
        userService.getListUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    mListUsers = response.body(); //nhận mảng Users
                    Log.d("ab", response.message());
                } else {
                    int statusCode = response.code();
                    Log.d("status", String.valueOf(statusCode));
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("logg", t.getMessage());
            }
        });
    }

    public interface UserCallback {
        void onUserReceived(User user);
    }

    private void getUser(String username, UserCallback callback) {
        userService = RetrofitClient.getRetrofit().create(UserService.class);
        userService.getUserByUsername(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    mUser = response.body(); // nhận thông tin User
                    callback.onUserReceived(mUser); // Gọi lại khi nhận được User
                } else {
                    int statusCode = response.code();
                    callback.onUserReceived(null); // Gọi lại với giá trị null nếu không thành công
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("logg", t.getMessage());
                callback.onUserReceived(null); // Gọi lại với giá trị null nếu xảy ra lỗi
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
        // Nhấn SignUp
        layoutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        // Nhấn Login
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = edtUsername.getText().toString().trim();
                String strPassword = edtPassword.getText().toString().trim();
                // User chưa nhập Username
                if (strUsername.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập Username", Toast.LENGTH_SHORT).show();
                }
                // User chưa nhập Password
                else if (strPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập Password", Toast.LENGTH_SHORT).show();
                }
                // everything is fine
                else {
                    getUser(strUsername, new UserCallback() {
                        @Override
                        public void onUserReceived(User user) {
                            if (user != null) {
                                boolean isHasUser = user.getUsername().equals(strUsername) && user.getPassword().equals(strPassword);
                                if (isHasUser) {
                                    SharedPrefManager sharedPrefManager = new SharedPrefManager(LoginActivity.this);
                                    sharedPrefManager.setData(user);
                                    // Chuyển vào MainActivity
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    finish();
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
