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

public class DateCourseActivity3 extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datecourse);


        Intent intent=getIntent();
        String str=intent.getStringExtra("IB3");
        ViewPager vpPager =(ViewPager) findViewById(R.id.vpPager);
        adapterViewPager =new DateCourseActivity3.MyPagerAdapter2(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator=(CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);
    }

    public static class MyPagerAdapter2 extends FragmentPagerAdapter{
        private static int NUM_ITEM=5;

        public MyPagerAdapter2(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return FirstFragment3.newInstance(0, "동문");
                case 1:
                    return SecondFragment3.newInstance(1, "먹거리");
                case 2:
                    return ThirdFragment3.newInstance(2, "카페");
                case 3:
                    return FourthFragment3.newInstance(3,"놀거리");
                case  4:
                    return FifthFragment3.newInstance(4,"결산");
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
