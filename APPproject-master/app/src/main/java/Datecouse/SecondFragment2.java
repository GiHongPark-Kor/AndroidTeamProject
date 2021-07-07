package Datecouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.a1010test2.R;

public class SecondFragment2 extends Fragment {

private String title;
private int page;

public static SecondFragment2 newInstance(int page, String title)
        {
        SecondFragment2 fragment2 =new SecondFragment2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment2.setArguments(args);
        return fragment2;
        }
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

        }


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dcfragment_second, container, false);

        ImageView image=(ImageView)view.findViewById(R.id.dcImage2);
        image.setBackgroundResource(R.drawable.date_side_restaurant);

        return view;
        }
}
