package com.example.christianpranata.dota2loreandbuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);

        String about_photo = "https://www.dicoding.com/images/small/avatar/201909021413368f10b05911a3742843e585c08a85ca4a.jpg";
        ImageView profile_photo = findViewById(R.id.profile_photo);
        Glide.with(getApplicationContext()).load(about_photo).into(profile_photo);
    }
}
