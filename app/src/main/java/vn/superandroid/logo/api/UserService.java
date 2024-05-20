package vn.superandroid.logo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import vn.superandroid.logo.Model.User;

public interface UserService {
    @GET("users")
    Call<List<User>> getListUsers();
    @GET("users/username/{username}")
    Call<User> getUserByUsername(@Path("username") String username);

    @POST("users/register")
    Call<User> registerUser(@Body User newUser);
}
