package com.example.andri.absensismkaa_jurusan_akuntansi.splashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andri.absensismkaa_jurusan_akuntansi.MainActivity;
import com.example.andri.absensismkaa_jurusan_akuntansi.R;
import com.example.andri.absensismkaa_jurusan_akuntansi.homeview.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },3000);

    }
}
