package com.example.instagrampost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        share = findViewById(R.id.share_post);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));
            }
        });

        checkMode();
    }

    private void checkMode() {
        int nightModeFlags = getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                Toast.makeText(MainActivity.this,"Dark mode is On",Toast.LENGTH_LONG).show();
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                Toast.makeText(MainActivity.this,"Light mode is On",Toast.LENGTH_LONG).show();
                doStuff();
                break;


        }
    }

    private void doStuff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        getWindow().setStatusBarColor(Color.WHITE);
    }
}