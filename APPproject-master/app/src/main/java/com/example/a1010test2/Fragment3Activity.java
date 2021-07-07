package com.example.a1010test2;

import android.content.Context;
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

public class Fragment3Activity extends Fragment implements View.OnClickListener
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Board> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private View view;
    private Context context;
    String temp;
    private EditText et_message;
    private Button btn_write;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment3,container,false);
        recyclerView = view.findViewById(R.id.f_recyclerview3);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        btn_write = view.findViewById(R.id.btn_write);
        et_message = view.findViewById(R.id.et_message);
        btn_write.setOnClickListener(this);
        context = container.getContext();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Board");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Board board = snapshot.getValue(Board.class);
                    arrayList.add(board);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Log.e("MainActivity",String.valueOf(databaseError.toException()));
            }
        });
        adapter = new BoardAdapter(arrayList,view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        HashMap<String,String> test = new HashMap<>();
        temp = et_message.getText().toString();
        test.put("B_content",temp);
        databaseReference.push().setValue(test);
        Toast.makeText(context,"게시글이 작성되었습니다.",Toast.LENGTH_SHORT).show();
        et_message.setText("");
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Board");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Board board = snapshot.getValue(Board.class);
                    arrayList.add(board);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Log.e("MainActivity",String.valueOf(databaseError.toException()));
            }
        });
        adapter = new BoardAdapter(arrayList,view.getContext());
        recyclerView.setAdapter(adapter);
    }
}
