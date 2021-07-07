package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Delivery_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.gobchang, R.drawable.pizza, R.drawable.jokbal, R.drawable.dak, R.drawable.hamburger1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_random_layout);

        Button end = (Button) findViewById(R.id.delivery_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });



        Button start =(Button)findViewById(R.id.delivery_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.delivery_Image);
                TextView text_delivery=(TextView)findViewById(R.id.delivery_text);
                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text_delivery.setText("곱창 입니다.");
                }else if(imageid==1)
                {
                    text_delivery.setText("피자 입니다.");
                }else if(imageid==2) {
                    text_delivery.setText("족발 입니다.");
                }else if(imageid==3)
                {
                    text_delivery.setText("치킨 입니다.");
                }else if(imageid==4)
                {
                    text_delivery.setText("햄버거 입니다.");
                }

            }
        });


    }
}
