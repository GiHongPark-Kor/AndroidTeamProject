package com.example.a1010test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import Datecouse.DateCourseActivity;
import Datecouse.DateCourseActivity2;
import Datecouse.DateCourseActivity3;
import Datecouse.DateCourseActivity4;

public class Fragment1Activity extends Fragment implements View.OnClickListener
{
    private ImageButton IB1,IB2,IB3,IB4, IB_randomFood,ib_datecourse1,ib_datecourse2,ib_datecourse3,ib_datecourse4;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1,container,false);
        IB1 = view.findViewById(R.id.IB1);
        IB2 = view.findViewById(R.id.IB2);
        IB3 = view.findViewById(R.id.IB3);
        IB4 = view.findViewById(R.id.IB4);
        IB_randomFood = view.findViewById(R.id.IB_randomFood);
        IB1.setOnClickListener(this);
        IB2.setOnClickListener(this);
        IB3.setOnClickListener(this);
        IB4.setOnClickListener(this);
        IB_randomFood.setOnClickListener(this);

        ib_datecourse1 = view.findViewById(R.id.ib_datecourse1);
        ib_datecourse2 = view.findViewById(R.id.ib_datecourse2);
        ib_datecourse3 = view.findViewById(R.id.ib_datecourse3);
        ib_datecourse4 =view.findViewById(R.id.ib_datecourse4);

        ib_datecourse1.setOnClickListener(this);
        ib_datecourse2.setOnClickListener(this);
        ib_datecourse3.setOnClickListener(this);
        ib_datecourse4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.IB_randomFood)
        {
            Intent intent = new Intent(getActivity(), randomActivity.class);
            getActivity().startActivity(intent);
        }else if(v.getId() == R.id.ib_datecourse1)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity.class);
            intent1.putExtra("DCIBid","IB1");
            getActivity().startActivity(intent1);
        }else if(v.getId() == R.id.ib_datecourse2)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity2.class);
            intent1.putExtra("DCIBid","IB2");
            getActivity().startActivity(intent1);
        }else if(v.getId() == R.id.ib_datecourse3)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity3.class);
            intent1.putExtra("DCIBid","IB3");
            getActivity().startActivity(intent1);
        }
        else if(v.getId() == R.id.ib_datecourse4)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity4.class);
            intent1.putExtra("DCIBid","IB4");
            getActivity().startActivity(intent1);
        }
        else
        {
            Intent intent = new Intent(getActivity(), SubActivity.class);
            switch (v.getId()) {
                case R.id.IB1:
                    intent.putExtra("IBid","IB1");
                    break;
                case R.id.IB2:
                    intent.putExtra("IBid", "IB2");
                    break;
                case R.id.IB3:
                    intent.putExtra("IBid", "IB3");
                    break;
                case R.id.IB4:
                    intent.putExtra("IBid", "IB4");
                    break;
            }
            getActivity().startActivity(intent);
        }
    }


}
