package com.example.a1010test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Stew_Random_Activity extends AppCompatActivity
{

    int images[] = new int[]{R.drawable.sundoboo_stew, R.drawable.kimchi_stew, R.drawable.danjang_stew, R.drawable.boodae_stew};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stew_random_layout);

        Button end = (Button) findViewById(R.id.stew_c);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        Button start =(Button)findViewById(R.id.stew_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randimages=(ImageView)findViewById(R.id.stewImage);
                TextView text=(TextView)findViewById(R.id.stew_text);
                int imageid=(int)(Math.random()*images.length);
                randimages.setBackgroundResource(images[imageid]);

                if(imageid==0)
                {
                    text.setText("순두부찌개 입니다.");
                }else if(imageid==1)
                {
                    text.setText("김치찌개 입니다.");
                }else if(imageid==2) {
                    text.setText("된장찌개 입니다.");
                }else if(imageid==3)
                {
                    text.setText("부대찌개 입니다.");
                }
            }
        });

    }
}
