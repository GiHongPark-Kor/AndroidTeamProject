package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pasta_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.boongola_pasta, R.drawable.carbo_pasta, R.drawable.rose_pasta, R.drawable.tomato_pasta};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasta_random_layout);

        Button end = (Button) findViewById(R.id.pasta_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.pasta_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.pastaImage);
                TextView text=(TextView)findViewById(R.id.pasta_text);
                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text.setText("봉골레 파스타입니다.");
                }else if(imageid==1)
                {
                    text.setText("까르보나라 입니다.");
                }else if(imageid==2) {
                    text.setText("로제 파스타 입니다.");
                }else if(imageid==3)
                {
                    text.setText("토마토파스타 입니다.");
                }
            }
        });

    }
}
