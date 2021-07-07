package Datecouse;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.a1010test2.R;

import me.relex.circleindicator.CircleIndicator;

public class DateCourseActivity2 extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datecourse);

        Intent intent=getIntent();
        String str=intent.getStringExtra("IB2");
        ViewPager vpPager =(ViewPager) findViewById(R.id.vpPager);
        adapterViewPager1 =new DateCourseActivity2.MyPagerAdapter1(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager1);
        //update
        CircleIndicator indicator=(CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);
    }
    public static class MyPagerAdapter1 extends FragmentPagerAdapter{
        private static int NUM_ITEM=5;

        public MyPagerAdapter1(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return FirstFragment2.newInstance(0, "쪽문");
                case 1:
                    return SecondFragment2.newInstance(1, "먹거리");
                case 2:
                    return ThirdFragment2.newInstance(2, "카페");
                case 3:
                    return FourthFragment2.newInstance(3,"놀거리");
                case  4:
                    return FifthFragment2.newInstance(4,"결산");
                default:
                    return null;
            }

        }


        @Override
        public int getCount() {
            return NUM_ITEM;//개수 리턴
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }
    }

}

