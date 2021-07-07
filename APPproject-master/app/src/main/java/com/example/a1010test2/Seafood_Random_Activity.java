package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Seafood_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.fish, R.drawable.seusi, R.drawable.shrimp, R.drawable.nakji};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seafood_random_layout);

        Button end = (Button) findViewById(R.id.seafood_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.seafood_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.seafoodImage);
                TextView text=(TextView)findViewById(R.id.seafood_text);
                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text.setText("회 입니다.");
                }else if(imageid==1)
                {
                    text.setText("초밥 입니다.");
                }else if(imageid==2) {
                    text.setText("새우구이 입니다.");
                }else if(imageid==3)
                {
                    text.setText("낚지볶음 입니다.");
                }
            }
        });

    }
}