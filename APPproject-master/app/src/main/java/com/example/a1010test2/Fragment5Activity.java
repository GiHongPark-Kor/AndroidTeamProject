package com.example.a1010test2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment5Activity extends Fragment
{
    int REQUEST_EXTERNAL_STORAGE_PERMIISION=1002;
    int REQUET_IMAGE_CODE =1001;//
    private TextView TV_userID;
    private View view;
    private String userID;
    CircleImageView userImage;

    Fragment5Activity(String InputuserID)
    {
        userID = InputuserID;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment5,container,false);
        TV_userID = (TextView) view.findViewById(R.id.TV_userID);
        TV_userID.setText(userID);

        userImage=(CircleImageView)view.findViewById(R.id.mainpeople2);
//        userImage.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
//                startActivityForResult(intent,REQUET_IMAGE_CODE);
//
//            }
//        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUET_IMAGE_CODE)
        {

            Uri image =data.getData();
            try {
                Bitmap bitmap =MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),image);
                userImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
