package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Schoolfood_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.kimbab, R.drawable.soondae, R.drawable.dduck, R.drawable.ramen};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_random_layout);

        Button end = (Button) findViewById(R.id.school_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.school_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.schoolImage);
                TextView text=(TextView)findViewById(R.id.school_text);
                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text.setText("김밥 입니다.");
                }else if(imageid==1)
                {
                    text.setText("순대 입니다.");
                }else if(imageid==2) {
                    text.setText("떡볶이 입니다.");
                }else if(imageid==3)
                {
                    text.setText("라면 입니다.");
                }
            }
        });

    }
}
