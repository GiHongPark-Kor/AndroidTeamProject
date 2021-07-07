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

public class FifthFragment4 extends Fragment
{
    private String title;
    private int page;

    public static FifthFragment4 newInstance(int page, String title)
    {
        FifthFragment4 fragment =new FifthFragment4();
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
        View view=inflater.inflate(R.layout.dcfragment_fourth,container, false);


        ImageView image=(ImageView)view.findViewById(R.id.dcImage4);
        image.setBackgroundResource(R.drawable.date_west_gate02);

        return view;

    }
}