package com.example.instagrampost;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class PostActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView share;
    TextView tagPeople, addLocation, advancedSettings;
    SwitchCompat facebookSwitch, twitterSwitch, tumblrSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //setting Toolbar---------------->
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //Light Status Bar----------->


        //Share Post Button in Toolbar------------>
        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "Post Shared", Toast.LENGTH_SHORT).show();
            }
        });


        //Tag People---------------------->
        tagPeople = findViewById(R.id.tag_people);
        tagPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "Tagged", Toast.LENGTH_SHORT).show();
            }
        });


        //Add Location------------------------->
        addLocation = findViewById(R.id.add_location);
        addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "Location is Added", Toast.LENGTH_SHORT).show();
            }
        });


        //AdvancedSettings------------------------------->
        advancedSettings = findViewById(R.id.advanced_settings);
        advancedSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "Advanced Settings", Toast.LENGTH_SHORT).show();
            }
        });

        //Handling Switches--------------------------------->
        facebookSwitch = findViewById(R.id.facebook_switch);
        twitterSwitch = findViewById(R.id.twitter_switch);
        tumblrSwitch = findViewById(R.id.tumblr_switch);


        facebookSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(PostActivity.this, "Shared to Facebook", Toast.LENGTH_SHORT).show();
                }
            }
        });
        twitterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(PostActivity.this, "Shared to Twitter", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tumblrSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(PostActivity.this, "Shared to Tumblr", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkMode();
    }

    private void checkMode() {
        int nightModeFlags = getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                Toast.makeText(PostActivity.this,"Dark mode is On",Toast.LENGTH_LONG).show();
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                Toast.makeText(PostActivity.this,"Light mode is On",Toast.LENGTH_LONG).show();
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