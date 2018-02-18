package com.example.rathana.sharedpreferencesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rathana.sharedpreferencesdemo.data.preferences.UserPreferences;
import com.example.rathana.sharedpreferencesdemo.entity.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if(UserPreferences.checkLogin(this)){
           startActivity(new Intent(this,MainActivity.class));
           finish();
        }
    }

    @OnClick(R.id.btn_login)
    public void onLogin(){
        //login
        //user form
        User user =new User();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        //authenticate
        //get User from sharedPreferences
        User u =UserPreferences.getUser(this);
        if(user.getUsername().equals(u.getUsername())
                && user.getPassword().equals(u.getPassword())){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else {
            Toast.makeText(this, "worng user name and password!", Toast.LENGTH_SHORT).show();
        }

    }
    @OnClick(R.id.btn_sign_up)
    public void onSignupScreen(){
        startActivity(new Intent(this,SignupActivity.class));

    }
}
