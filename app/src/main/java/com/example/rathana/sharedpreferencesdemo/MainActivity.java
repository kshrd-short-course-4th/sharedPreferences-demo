package com.example.rathana.sharedpreferencesdemo;

import android.content.Intent;
import android.support.constraint.solver.Cache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rathana.sharedpreferencesdemo.data.preferences.UserPreferences;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out:
                UserPreferences.remove(this);
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return  true;
        }
        return false;
    }

    @OnClick(R.id.btn_cache)
    public void onCacheScreen(){
        startActivity(new Intent(this, CacheActivity.class));
    }
}
