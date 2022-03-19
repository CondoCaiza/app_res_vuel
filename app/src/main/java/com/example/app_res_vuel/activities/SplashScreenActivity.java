package com.example.app_res_vuel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.app_res_vuel.R;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView imgLogo;
    private ImageView imgBG;
    private LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imgLogo = (ImageView) findViewById(R.id.imgLogo);
        imgBG = (ImageView) findViewById(R.id.imgBG);
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie);
        imgLogo.animate().translationY(-5000).setDuration(1000).setStartDelay(4000);
        imgBG.animate().translationY(5000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1000).setDuration(1000).setStartDelay(1000);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                lottieAnimationView.playAnimation();
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 5000);

    }
}