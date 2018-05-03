package com.animesh.quizzard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {

    private Button startBtn;
    private boolean restore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Check if activity was recreated
        if (savedInstanceState != null) {
            restore = savedInstanceState.getBoolean("RESTORE", false);
        }
        setContentView(R.layout.activity_splash);
        startBtn = findViewById(R.id.start_button);
        if(!restore){
            startBtn.setVisibility(View.GONE);
            //invoke function to reveal button
            showStartBtn();
        }

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle out){
        out.putBoolean("RESTORE",true);
        super.onSaveInstanceState(out);
    }

    void showStartBtn(){
        startBtn.setAlpha(0f);
        startBtn.setVisibility(View.VISIBLE);

        //Run animation
        startBtn.animate().alpha(1f)
                .setDuration(1000)
                .setStartDelay(1500)
                .setListener(null);
    }
}
