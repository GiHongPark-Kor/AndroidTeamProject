package Datecouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a1010test2.R;

public class FirstFragment2 extends Fragment
{
    private String title;
    private int page;

    public static FirstFragment2 newInstance(int page, String title)
    {
        FirstFragment2 fragment =new FirstFragment2();
        Bundle args=new Bundle();
        args.putInt("someInt",page);
        args.putString("someTitle",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.dcfragement_first,container, false);
            //EditText tvLabel=(EditText) view.findViewById(R.id.editText1);
            //tvLabel.setText(title);
            ImageView image=(ImageView)view.findViewById(R.id.dcImage1);
            image.setBackgroundResource(R.drawable.date_side_gate001);

        return view;

    }
}