package vn.superandroid.logo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.superandroid.logo.Model.Category;

public interface CategoryService {
    @GET("moviecategory")
    Call<List<Category>> getListCategory();
}
