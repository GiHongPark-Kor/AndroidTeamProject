package com.example.a1010test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ShowRestaurantActivity extends AppCompatActivity
{
    private androidx.appcompat.widget.Toolbar toolbar;
    private ActionBar actionBar;
    TextView tv_name, title,tv_address,tv_number;
    ImageView iv_profile;
    String name,score,profile,address,number;
    RatingBar ratingbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showrestaurant);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);
        tv_name = findViewById(R.id.tv_name);
        iv_profile = findViewById(R.id.iv_profile);
        title = findViewById(R.id.title);
        ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        tv_address = findViewById(R.id.tv_address);
        tv_number = findViewById(R.id.tv_number);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        score = intent.getStringExtra("score");
        profile = intent.getStringExtra("profile");
        address = intent.getStringExtra("address");
        number = intent.getStringExtra("number");


        title.setText(name);
        tv_name.setText(name);
        Glide.with(this).load(profile).into(iv_profile);
        tv_name.setText(name);
        tv_address.setText(address);
        tv_number.setText(number);
        ratingbar.setRating(Float.valueOf(score));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
