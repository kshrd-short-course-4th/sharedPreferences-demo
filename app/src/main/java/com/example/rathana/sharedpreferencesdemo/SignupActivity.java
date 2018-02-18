package com.example.rathana.sharedpreferencesdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.rathana.sharedpreferencesdemo.data.preferences.UserPreferences;
import com.example.rathana.sharedpreferencesdemo.entity.User;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.gender)
    EditText gender;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @OnClick(R.id.btn_sign_up)
    public void onSaveUser(){
        progressBar.setVisibility(ProgressBar.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user=new User();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.setGender(gender.getText().toString());
                user.setAddress(address.getText().toString());

                //save user into sharedPreferences
                UserPreferences.add(SignupActivity.this,user);
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                finish();
            }
        }, 2000);


    }
}
