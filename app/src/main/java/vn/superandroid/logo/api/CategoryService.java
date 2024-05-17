package vn.superandroid.logo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.superandroid.logo.Model.CategoryModel;

public interface CategoryService {
    @GET("moviecategory")
    Call<List<CategoryModel>> getListCategory();
}
