package com.example.a1010test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class randomActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    private ActionBar actionBar;
    private int images[] = new int[]{R.drawable.gobchang, R.drawable.pizza, R.drawable.jokbal, R.drawable.dak};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Intent intent = getIntent();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.rice_button:
                Intent rice_intent = new Intent(randomActivity.this, Rice_Random_Activity.class);
                startActivity(rice_intent);
                break;
            case R.id.delivery_button:
                Intent delivery_intent = new Intent(randomActivity.this, Delivery_Random_Activity.class);
                startActivity(delivery_intent);
                break;
            case R.id.meat_button:
                Intent meat_intent = new Intent(randomActivity.this, Meat_Random_Activity.class);
                startActivity(meat_intent);
                break;
            case R.id.school_food_button:
                Intent school_intent = new Intent(randomActivity.this, Schoolfood_Random_Activity.class);
                startActivity(school_intent);
                break;
            case R.id.seafood_button:
                Intent seafood_intent = new Intent(randomActivity.this, Seafood_Random_Activity.class);
                startActivity(seafood_intent);
                break;
            case R.id.stew_button:
                Intent stew_intent = new Intent(randomActivity.this, Stew_Random_Activity.class);
                startActivity(stew_intent);
                break;
            case R.id.pasta_button:
                Intent pasta_intent = new Intent(randomActivity.this, Pasta_Random_Activity.class);
                startActivity(pasta_intent);
                break;
            case R.id.noodle_button:
                Intent noodle_intent = new Intent(randomActivity.this, Noodle_Random_Activity.class);
                startActivity(noodle_intent);
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
