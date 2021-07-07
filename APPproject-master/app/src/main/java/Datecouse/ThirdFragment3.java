package Datecouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.a1010test2.R;

public class ThirdFragment3 extends Fragment
{
    private String title;
    private int page;

    public static ThirdFragment3 newInstance(int page, String title)
    {
        ThirdFragment3 fragment3=new ThirdFragment3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment3.setArguments(args);
        return fragment3;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dcfragment_third, container, false);

        ImageView image=(ImageView)view.findViewById(R.id.dcImage3);
        image.setBackgroundResource(R.drawable.date_east_cafe);

        return view;
    }

}
