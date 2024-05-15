package vn.superandroid.logo.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.superandroid.logo.Model.User;

public interface UserService {
    @GET("users/{id}")
    public Call<User> getUser(@Path("id") long id);

}
