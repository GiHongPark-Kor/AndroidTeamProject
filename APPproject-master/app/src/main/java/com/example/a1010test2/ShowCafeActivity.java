package com.example.a1010test2;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.maps.android.SphericalUtil;

import com.bumptech.glide.Glide;

import java.util.HashMap;

public class ShowCafeActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    private GPSTracker gpsTracker;
    private androidx.appcompat.widget.Toolbar toolbar;
    private ActionBar actionBar;
    TextView tv_name,title,tv_address,tv_number;
    ImageView iv_profile;
    String name,score,profile,address,number;
    RatingBar ratingbar;
    LatLng currentPosition;
    LatLng previousPosition = null;
    int tracking = 0;
    Marker addedMarker = null;
    Double longitude2, latitude2;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private String userID;
    Button zzim;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcafe);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        MyGlobals myGlobals = (MyGlobals) getApplication();
        userID = myGlobals.getuserID();
        ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        tv_name = findViewById(R.id.tv_name);
        tv_address = findViewById(R.id.tv_address);
        tv_number = findViewById(R.id.tv_number);
        title = findViewById(R.id.title);
        iv_profile = findViewById(R.id.iv_profile);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        score = intent.getStringExtra("score");
        profile = intent.getStringExtra("profile");
        address = intent.getStringExtra("address");
        number = intent.getStringExtra("number");
        latitude2 = Double.parseDouble(intent.getStringExtra("latitude"));
        longitude2 = Double.parseDouble(intent.getStringExtra("longitude"));
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Member");
        database.getReference();
        zzim = findViewById(R.id.zzim);
        zzim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String,String> test = new HashMap<>();
                test.put("M_user",userID);
                test.put("M_name",name);
                test.put("M_score",score);
                test.put("M_profile",profile);
                test.put("M_number",number);
                test.put("M_address",address);
                test.put("M_latitude",Double.toString(latitude2));
                test.put("M_longitude",Double.toString(longitude2));
                test.put("M_temp","F");
                databaseReference.push().setValue(test);
                Toast.makeText(getApplicationContext(),"찜 완료.",Toast.LENGTH_SHORT).show();
            }
        });
        title.setText(name);
        tv_name.setText(name);
        Glide.with(this).load(profile).into(iv_profile);
        tv_name.setText(name);
        tv_address.setText(address);
        tv_number.setText(number);
        ratingbar.setRating(Float.valueOf(score));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gpsTracker = new GPSTracker(ShowCafeActivity.this);
        final double latitude = gpsTracker.getLatitude();
        final double longitude = gpsTracker.getLongitude();

        mMap = googleMap;
        previousPosition = new LatLng(latitude2,longitude2);
        currentPosition = new LatLng(gpsTracker.getLatitude(), gpsTracker.getLongitude());
        LatLng mokro = new LatLng(latitude2, longitude2);
        mMap.addMarker(new MarkerOptions().position(mokro).title("coffee"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mokro, 18));
        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Marker m  = null;

                tracking = 1 - tracking;

                if ( tracking == 1){
                    double distance = SphericalUtil.computeDistanceBetween(currentPosition, previousPosition);
                    button.setText("Stop");
                    Toast.makeText(ShowCafeActivity.this,  "목표까지"+ (int) distance + "m 남음", Toast.LENGTH_LONG).show();


                    if ( (addedMarker != null) && tracking == 1 ) {
                        double radius = 500;



                    }
                    LatLng me = new LatLng(latitude, longitude);
                    mMap.addMarker(new MarkerOptions().position(me).title("me"));
                    m = mMap.addMarker(new MarkerOptions().position(me));
                }
                else
                {


                    button.setText("Start");

                }
            }
        });

    }
}

