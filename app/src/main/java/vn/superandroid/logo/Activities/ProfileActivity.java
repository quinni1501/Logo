package vn.superandroid.logo.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import vn.superandroid.logo.BottomSheetDialog;
import vn.superandroid.logo.Model.User;
import vn.superandroid.logo.R;
import vn.superandroid.logo.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity {
    public static final String TAG = ProfileActivity.class.getName();
    private static final int MY_REQUEST_CODE = 10;
    Button btnLogout;
    TextView tvFullname, tvGender, tvEmail, tvPhone;
    ImageView imgAvatar, btnBack;
    User user;
    SharedPrefManager sharedPrefManager;
    private final ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.e(TAG, "onActivityResult");
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //There are no request codes
                        Intent data = result.getData();
                        if (data == null) {
                            return;
                        }
                        Uri uri = data.getData();
                        //mUri = uri;
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            imgAvatar.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initUI();
        showUserInfo();
        initListener();
    }
    private void initUI() {
        tvFullname = findViewById(R.id.tvFullname);
        tvGender = findViewById(R.id.tvGender);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone =findViewById(R.id.tvPhone);
        btnLogout = findViewById(R.id.logoutBtn);
        imgAvatar = findViewById(R.id.imageView);
        btnBack = findViewById(R.id.backButton);
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

        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showUserInfo() {
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        user = sharedPrefManager.getData();
        tvFullname.setText(user.getUserFullname());
        if(user.getUserGender().trim().equals("1"))
        {
            tvGender.setText("Nữ");
        } else tvGender.setText("Nam");
        tvEmail.setText(user.getUserEmail());
        tvPhone.setText(user.getUserPhone());
    }
    private void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_bottom_sheet);

        Button chooseImgBtn = dialog.findViewById(R.id.choose_img_button);
        Button uploadImgBtn = dialog.findViewById(R.id.upload_img_button);

        chooseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRequestPermission();
            }
        });

        uploadImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(ProfileActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
    public void onClickRequestPermission() {
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openGallery();
        } else {
            String [] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, MY_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            }
        }
    }
    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
    }
}