package vn.superandroid.logo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.superandroid.logo.Model.User;
import vn.superandroid.logo.R;
import vn.superandroid.logo.SharedPrefManager;
import vn.superandroid.logo.api.RetrofitClient;
import vn.superandroid.logo.api.UserService;

public class SignUpActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtName, edtEmail, edtPhone, edtGender;
    Button btnSignUp;
    UserService userService;
    private User mUser, nUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initUI();
        initListener();
    }
    private void initUI() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtName = findViewById(R.id.edtName);
        edtGender = findViewById(R.id.edtGender);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
    private void creatUser() {
        String strUsername = edtUsername.getText().toString().trim(),
                strPassword = edtPassword.getText().toString().trim(),
                strName = edtName.getText().toString().trim(),
                strGender = edtGender.getText().toString().trim(),
                strEmail = edtEmail.getText().toString().trim(),
                strPhone = edtPhone.getText().toString().trim();
        if(strUsername.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Vui lòng nhập Username!", Toast.LENGTH_SHORT).show();
        } else if(strPassword.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Vui lòng nhập Password!", Toast.LENGTH_SHORT).show();
        } else if(strName.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Vui lòng nhập Họ và tên", Toast.LENGTH_SHORT).show();
        } else if(strGender.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Vui lòng nhập Giới tính!", Toast.LENGTH_SHORT).show();
        } else if(strEmail.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Vui lòng nhập Email!", Toast.LENGTH_SHORT).show();
        } else if(strPhone.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Vui lòng nhập Số điện thoại!", Toast.LENGTH_SHORT).show();
        }
        nUser = new User(strUsername,strPassword, strName, strGender, strEmail, strPhone);
    }
    private void initListener() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatUser();
                if(nUser != null) {
                    getUser(nUser, new UserCallback() {
                        @Override
                        public void onUserReceived(User user) {
                            if (user != null) {
                                Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                SharedPrefManager sharedPrefManager = new SharedPrefManager(SignUpActivity.this);
                                sharedPrefManager.setData(user);
                                // Chuyển vào MainActivity
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                finish();
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    Toast.makeText(SignUpActivity.this, "Lấy User thành công", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    public interface UserCallback {
        void onUserReceived(User user);
    }
    private void getUser(User newUser, UserCallback callback) {
        userService = RetrofitClient.getRetrofit().create(UserService.class);
        userService.registerUser(newUser).enqueue(new Callback<User>() {
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

}