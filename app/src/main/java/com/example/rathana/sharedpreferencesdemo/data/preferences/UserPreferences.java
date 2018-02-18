package com.example.rathana.sharedpreferencesdemo.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.rathana.sharedpreferencesdemo.entity.User;

/**
 * Created by RATHANA on 2/18/2018.
 */

public class UserPreferences {
    //create keys
    public static final String USERNAME="USERNAME";
    public static final String PASSWORD="PASSWORD";
    public static final String GENDER="GENDER";
    public static final String ADDRESS="ADDRESS";
    public static final String FILE_NAME="user_session";

    private static SharedPreferences preferences;

    private static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }

    // create method add user
    public static  boolean add(Context context, User user){
        SharedPreferences.Editor editor= getSharedPreferences(context)
                .edit();
        if(user !=null){
            editor.putString(USERNAME,user.getUsername());
            editor.putString(PASSWORD,user.getPassword());
            editor.putString(GENDER,user.getGender());
            editor.putString(ADDRESS,user.getAddress());
            editor.commit();
            return  true;
        }
        return false;
    }
    //create method get user
    public static User getUser(Context context){
        SharedPreferences preferences=getSharedPreferences(context);
        User user=new User();
        user.setUsername(preferences.getString(USERNAME,null));
        user.setPassword(preferences.getString(PASSWORD,null));
        user.setGender(preferences.getString(GENDER,null));
        user.setAddress(preferences.getString(ADDRESS,null));
        return user;
    }
    //create method remove user
    public static boolean remove(Context context){
        SharedPreferences.Editor editor= getSharedPreferences(context)
                .edit();
        editor.putString(USERNAME,null);
        editor.putString(PASSWORD,null);
        editor.putString(GENDER,null);
        editor.putString(ADDRESS,null);
        editor.commit();
        return true;
    }

    //check login
    public static boolean checkLogin(Context context){
        User user = getUser(context);
        if(null!= user.getUsername() && null!=user.getPassword()){
            return true;
        }
        return false;
    }
}
