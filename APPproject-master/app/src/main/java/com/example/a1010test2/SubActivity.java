package com.example.a1010test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SubActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    private ActionBar actionBar;
    private BottomNavigationView bottomNavigationView;
    private Menu menu;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1SubActivity frag1;
    private Fragment2SubActivity frag2;
    private Fragment3SubActivity frag3;
    private Fragment4SubActivity frag4;
    private String preIBid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = findViewById(R.id.topNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.restaurant:
                        setFrag(0);
                        break;
                    case R.id.cafe:
                        setFrag(1);
                        break;
                    case R.id.play:
                        setFrag(2);
                        break;
                    case R.id.datacourse:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        frag1 = new Fragment1SubActivity();
        frag2 = new Fragment2SubActivity();
        frag3 = new Fragment3SubActivity();
        frag4 = new Fragment4SubActivity();
        Intent intent = getIntent();
        preIBid = intent.getStringExtra("IBid");
        switch (preIBid)
        {
            case "IB1":
                bottomNavigationView.setSelectedItemId(R.id.restaurant);
                setFrag(0);
                break;
            case "IB2":
                bottomNavigationView.setSelectedItemId(R.id.cafe);
                setFrag(1);
                break;
            case "IB3":
                bottomNavigationView.setSelectedItemId(R.id.play);
                setFrag(2);
                break;
            case "IB4":
                bottomNavigationView.setSelectedItemId(R.id.datacourse);
                setFrag(3);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // 뒤로 가기
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setFrag(int n) // 프래그먼트 교체가 일어나는 실행문
    {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame,frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag4);
                ft.commit();
                break;
        }
    }
}
