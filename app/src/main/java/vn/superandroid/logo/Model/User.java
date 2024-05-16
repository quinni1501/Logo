package vn.superandroid.logo.Model;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String username;
    private String password;
    private String userAvatar;
    private String userFullname;
    private String userGender;
    private String userEmail;
    private String userPhone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", userFullname='" + userFullname + '\'' +
                ", userGender=" + userGender +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    public User(String userId, String username, String password, String userAvatar, String userFullname, String userGender, String userEmail, String userPhone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userAvatar = userAvatar;
        this.userFullname = userFullname;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }
}
