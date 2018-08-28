package com.teamproject.plastikproject.plastik.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.plastik.helper.SessionManager;
import com.teamproject.plastikproject.plastik.notif.AreWeThereIntentService;


public class SplashScreenActivity extends SessionManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startService(new Intent(SplashScreenActivity.this, AreWeThereIntentService.class));

                sessionManager.checkLogin();
                finish();
            }
        },4000);

    }
}
