package vn.superandroid.logo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.superandroid.logo.Model.User;

public interface UserService {
    @GET("users")
    Call<List<User>> getListUsers();
    @GET("users/username/{username}")
    Call<User> getUserByUsername(@Path("username") String username);
}
