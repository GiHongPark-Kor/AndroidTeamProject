package com.example.a1010test2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private doubleBackPress doubleBackPress;
    private BottomNavigationView bottomNavigationView;
    private Menu menu;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1Activity frag1;
    private Fragment2Activity frag2;
    private Fragment3Activity frag3;
    private Fragment4Activity frag4;
    private Fragment5Activity frag5;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.search:
                        setFrag(1);
                        break;
                    case R.id.board:
                        setFrag(2);
                        break;
                    case R.id.dib:
                        setFrag(3);
                        break;
                    case R.id.mypage:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        frag1 = new Fragment1Activity();
        frag2 = new Fragment2Activity();
        frag3 = new Fragment3Activity();
        frag4 = new Fragment4Activity(userID);
        frag5 = new Fragment5Activity(userID);
        setFrag(0); // 시작 시 fragment 화면 설정
        doubleBackPress=new doubleBackPress(this);
        MyGlobals myGlobals = (MyGlobals) getApplication();
        myGlobals.setuserID(userID);
    }

    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
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
            case 4:
                ft.replace(R.id.main_frame,frag5);
                ft.commit();
                break;
        }
    }
}
