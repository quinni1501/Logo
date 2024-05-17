package vn.superandroid.logo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    //đường dẫn
                    .baseUrl("http://192.168.97.222:8188/api/")
                    //.baseUrl("https://6644eae1b8925626f8907194.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
