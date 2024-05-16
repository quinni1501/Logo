package vn.superandroid.logo;

import android.content.Context;
import android.content.SharedPreferences;

import vn.superandroid.logo.Model.User;

public class SharedPrefManager {
    private final String SHARED_PREF_NAME="loginSessionInformation";
    private Context mContext;

    public SharedPrefManager(Context context) {
        mContext=context;
    }
    public void setData(User user){
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("userId", user.getUserId());
        editor.putString("username", user.getUsername());
        editor.putString("password", user.getPassword());
        editor.putString("userAvatar", user.getUserAvatar());
        editor.putString("userFullname", user.getUserFullname());
        editor.putString("userGender", user.getUserGender());
        editor.putString("userEmail", user.getUserEmail());
        editor.putString("userPhone", user.getUserPhone());
        editor.apply();
    }
    public User getData(){
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(sharedPreferences.getString("userId", ""),
                sharedPreferences.getString("username", ""),
                sharedPreferences.getString("password", ""),
                sharedPreferences.getString("userAvatar", ""),
                sharedPreferences.getString("userFullname", ""),
                sharedPreferences.getString("userGender", ""),
                sharedPreferences.getString("userEmail", ""),
                sharedPreferences.getString("userPhone", ""));
    }
    public boolean isLogedOut() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("username", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("password", "").isEmpty();
        return isEmailEmpty || isPasswordEmpty;
        //nếu cả true trong 2 rỗng trả về 1 là đã logout
        //trả về false là chưa logout
    }
    public void clearUser() {
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.clear();
        editor.apply();
    }
}
