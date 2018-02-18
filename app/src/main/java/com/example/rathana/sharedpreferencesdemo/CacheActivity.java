package com.example.rathana.sharedpreferencesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CacheActivity extends AppCompatActivity {
    private static final String TAG = "CacheActivity";
    @BindView(R.id.desc)
    EditText desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_save_cache)
    public void onSaveCache(){
        saveCache();
        Toast.makeText(this, "save success", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_read_cache)
    public void onReadCache(){
        readCache();
    }

    public void saveCache(){
        File dir=getCacheDir();
        File file=new File(dir.getAbsolutePath(),"desc.cache");
        Log.e(TAG, "saveCache: "+dir.getAbsolutePath());
        OutputStream ous=null;
        try{
            ous= new FileOutputStream(file);
            ous.write(desc.getText().toString().getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ous.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readCache(){

        File dir=getCacheDir();
        File file=new File(dir.getAbsolutePath(),"desc.cache");
        InputStream ins=null;
        try{
            ins=new FileInputStream(file);
            int i=0;
            String data="";
            while ((i=ins.read())!=-1){
                data=data+ (char)i;
            }
            Log.e(TAG, "readCache: "+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}