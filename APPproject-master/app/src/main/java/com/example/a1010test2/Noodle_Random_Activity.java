package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Noodle_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.cal_noodle, R.drawable.cool_noodle, R.drawable.janci_noodle, R.drawable.ssal_noodle};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noodle_random_layout);

        Button end = (Button) findViewById(R.id.noodle_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.noodle_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.noodleImage);
                TextView text=(TextView)findViewById(R.id.noodle_text);
                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text.setText("칼국수 입니다.");
                }else if(imageid==1)
                {
                    text.setText("냉면 입니다.");
                }else if(imageid==2) {
                    text.setText("잔치국수 입니다.");
                }else if(imageid==3)
                {
                    text.setText("쌀국수 입니다.");
                }
            }
        });

    }
}

