package vn.superandroid.logo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.superandroid.logo.Model.User;

public interface UserService {
    @GET("users")
    Call<List<User>> getListUsers();
}
