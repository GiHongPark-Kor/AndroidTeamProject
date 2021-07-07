package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rice_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.bibimbam, R.drawable.bbokbab, R.drawable.gukbab, R.drawable.juk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rice_random_layout);

        Button end = (Button) findViewById(R.id.rice_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.rice_start);
        start.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
               ImageView randimages=(ImageView)findViewById(R.id.riceImage);
               TextView text=(TextView)findViewById(R.id.rice_text);
                    int imageid=(int)(Math.random()*images.length);
                      randimages.setBackgroundResource(images[imageid]);

               if(imageid==0)
               {
                   text.setText("비빔밥 입니다.");
               }else if(imageid==1)
               {
                   text.setText("볶음밥 입니다.");
               }else if(imageid==2) {
                   text.setText("국밥 입니다.");
               }else if(imageid==3)
               {
                   text.setText("죽 입니다.");
               }
                }
          });

        }
}


