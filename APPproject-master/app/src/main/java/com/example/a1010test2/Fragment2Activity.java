package com.example.a1010test2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment2Activity extends Fragment implements View.OnClickListener
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Search> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private View view;
    private EditText et_message;
    private Button btn_search;
    String input;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2,container,false);

        recyclerView = view.findViewById(R.id.f_recyclerview2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        btn_search = view.findViewById(R.id.btn_search);
        et_message = view.findViewById(R.id.et_message);
        btn_search.setOnClickListener(this);
        databaseReference = database.getReference("Search");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Search search = snapshot.getValue(Search.class);
                    arrayList.add(search);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Log.e("MainActivity",String.valueOf(databaseError.toException()));
            }
        });
        adapter = new SearchAdapter(arrayList,view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        input = et_message.getText().toString();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Search");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Search search = snapshot.getValue(Search.class);
                   // System.out.println("WWWWW : " + search.getS_name());
                    if (search.getS_name().equals(input))
                    {
                       // System.out.println("Success : " + search.getS_name());
                        arrayList.add(search);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Log.e("MainActivity",String.valueOf(databaseError.toException()));
            }
        });
        adapter = new SearchAdapter(arrayList,view.getContext());
        recyclerView.setAdapter(adapter);
    }
}
