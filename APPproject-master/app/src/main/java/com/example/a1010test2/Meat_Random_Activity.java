package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Meat_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.steak, R.drawable.samgyapsal, R.drawable.galbe, R.drawable.yuokhai};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat_random_layout);

        Button end = (Button) findViewById(R.id.meat_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.meat_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.meatImage);
                TextView text=(TextView)findViewById(R.id.meat_text);

                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text.setText("스테이크 입니다.");
                }else if(imageid==1)
                {
                    text.setText("삼겹살 입니다.");
                }else if(imageid==2) {
                    text.setText("갈비 입니다.");
                }else if(imageid==3)
                {
                    text.setText("육회 입니다.");
                }
            }
        });

    }
}
