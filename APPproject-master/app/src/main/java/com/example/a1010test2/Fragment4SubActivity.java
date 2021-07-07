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

public class Fragment4SubActivity extends Fragment implements View.OnClickListener
{
    private ImageButton ib_datecourse1_1,ib_datecourse2_2,ib_datecourse3_3,ib_datecourse4_4;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.subfragment4,container,false);

        ib_datecourse1_1 = view.findViewById(R.id.ib_datecourse1_1);
        ib_datecourse2_2 = view.findViewById(R.id.ib_datecourse2_2);
        ib_datecourse3_3 = view.findViewById(R.id.ib_datecourse3_3);
        ib_datecourse4_4 =view.findViewById(R.id.ib_datecourse4_4);

        ib_datecourse1_1.setOnClickListener(this);
        ib_datecourse2_2.setOnClickListener(this);
        ib_datecourse3_3.setOnClickListener(this);
        ib_datecourse4_4.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.ib_datecourse1_1)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity.class);
            intent1.putExtra("DCIBid","IB1");
            getActivity().startActivity(intent1);
        }else if(v.getId() == R.id.ib_datecourse2_2)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity2.class);
            intent1.putExtra("DCIBid","IB2");
            getActivity().startActivity(intent1);
        }else if(v.getId() == R.id.ib_datecourse3_3)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity3.class);
            intent1.putExtra("DCIBid","IB3");
            getActivity().startActivity(intent1);
        }
        else if(v.getId() == R.id.ib_datecourse4_4)
        {
            Intent intent1 = new Intent(getActivity(), DateCourseActivity4.class);
            intent1.putExtra("DCIBid","IB4");
            getActivity().startActivity(intent1);
        }

    }

}
