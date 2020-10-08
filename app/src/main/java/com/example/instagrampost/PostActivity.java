package com.example.instagrampost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView share;
    TextView tagPeople, addLocation, advancedSettings;
    Switch facebookSwitch, twitterSwitch, tumblrSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //setting Toolbar---------------->
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Light Status Bar----------->
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


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
    }
}