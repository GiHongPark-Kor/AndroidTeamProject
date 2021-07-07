package com.example.a1010test2;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class doubleBackPress {

        private long backKeyPressedTime=0;
        private Toast toast;
        private Activity activity;
        public doubleBackPress(Activity act)
        {
            this.activity=act;
        }
        public void onBackPressed()
        {
            if(System.currentTimeMillis()>backKeyPressedTime+2000)
            {
                backKeyPressedTime=System.currentTimeMillis();
                toast=Toast.makeText(activity,"뒤로 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if(System.currentTimeMillis()<=backKeyPressedTime+2000)
            {
                activity.finish();
                toast.cancel();


                activity.moveTaskToBack(true);
                activity.finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }
}
