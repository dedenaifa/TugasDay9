package com.example.tugasday9;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.tugasday9.data.model.LoginData;

import java.util.HashMap;

public class SessionManager {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER_ID = "user_id";
    public static final String USERNAME = "username";
    public static final String NAME = "name";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USER_ID, user.getId());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NAME, user.getName());
        editor.apply();
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(USER_ID, sharedPreferences.getString(USER_ID, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
        return user;
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    public boolean checkLogin() {
        return isLoggedIn();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void logoutSession() {
        logout();
    }
}
