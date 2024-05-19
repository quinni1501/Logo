package vn.superandroid.logo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.superandroid.logo.Adapter.CategoryAdapter;
import vn.superandroid.logo.DepthPageTransformer;
import vn.superandroid.logo.Adapter.ImagesViewPager2Adapter;
import vn.superandroid.logo.Model.Category;
import vn.superandroid.logo.Model.Images;
import vn.superandroid.logo.Model.User;
import vn.superandroid.logo.R;
import vn.superandroid.logo.api.CategoryService;
import vn.superandroid.logo.api.RetrofitClient;

public class MainActivity extends AppCompatActivity {
    private User mUser;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList1;
    private LinearLayout hoSoBtn, phimBtn, lichchieuBtn;
    private Handler handler = new Handler();
    CategoryService categoryService;
    private List<Category> mListCategory;
    private RecyclerView recyclerViewCategoryList;
    private RecyclerView.Adapter adapter;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == imagesList1.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        }
    };
    private View imgView_Phim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListCategory = new ArrayList<>();
        // anh xa viewpager2
        viewPager2 = findViewById(R.id.viewpage2);
        circleIndicator3 = findViewById(R.id.circle_indicator3);
        imagesList1 = getListImages();
        ImagesViewPager2Adapter adapter1 = new ImagesViewPager2Adapter(imagesList1);
        viewPager2.setAdapter(adapter1);
        //Liên kết viewpager2 và indicator3
        circleIndicator3.setViewPager(viewPager2);
        //lắng nghe viewpager chuyển trang
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);
            }
        });
        //viewpager2 transformers
        //viewPager2.setPageTransformer(new ZoomOutPageTransformer());
        viewPager2.setPageTransformer(new DepthPageTransformer());

        //ánh xạ
        hoSoBtn = findViewById(R.id.hoSoBtn);
        hoSoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        imgView_Phim = findViewById(R.id.imgView_Phim);
        imgView_Phim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilmActivity.class);
                startActivity(intent);
            }
        });

        phimBtn = findViewById(R.id.phimBtn);
        phimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilmActivity.class);
                startActivity(intent);
            }
        });
        getListCategory();
        recyclerViewCategory();

        lichchieuBtn = findViewById(R.id.lichChieuBtn);
        lichchieuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowtimesActivity.class);
                startActivity(intent);
            }
        });
    }


    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.banner1));
        list.add(new Images(R.drawable.banner2));
        list.add(new Images(R.drawable.banner3));
        list.add(new Images(R.drawable.banner4));
        list.add(new Images(R.drawable.banner5));
        list.add(new Images(R.drawable.banner6));
        list.add(new Images(R.drawable.banner7));
        list.add(new Images(R.drawable.banner8));
        return list;
    }
    private void getListCategory() {
        //Gọi Interface trong CategoryService
        categoryService = RetrofitClient.getRetrofit().create(CategoryService.class);
        categoryService.getListCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    mListCategory = response.body(); //nhận mảng Users
                } else {
                    int statusCode = response.code();
                }
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("logg", t.getMessage());
            }
        });
    }
    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.rc_Category);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        /*ArrayList<CategoryModel> categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel("1", "Mystery"));
        categoryList.add(new CategoryModel("2", "Thriller"));
        categoryList.add(new CategoryModel("3", "Fantasy"));
        categoryList.add(new CategoryModel("4", "Adventure"));
        categoryList.add(new CategoryModel("5", "Comedy"));
        categoryList.add(new CategoryModel("6", "Romance"));
        categoryList.add(new CategoryModel("7", "Horror"));
        categoryList.add(new CategoryModel("8", "Animation"));*/
        adapter = new CategoryAdapter(mListCategory);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}