package com.example.a1010test2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.CustomViewHolder>
{
    RatingBar ratingbar;
    private ArrayList<Member> arrayList;
    private Context context;
    public MemberAdapter(ArrayList<Member> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cafe,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        ratingbar = (RatingBar) view.findViewById(R.id.ratingbar);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, final int position)
    {
        Glide.with(holder.itemView.getContext())
                .load(arrayList.get(position).getM_profile())
                .into(holder.iv_profile);
        holder.tv_name.setText(arrayList.get(position).getM_name());
        holder.tv_score.setText(arrayList.get(position).getM_score());
        ratingbar.setRating(Float.valueOf(arrayList.get(position).getM_score()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ShowCafeActivity.class);
                intent.putExtra("name",arrayList.get(position).getM_name()) ;
                intent.putExtra("score",arrayList.get(position).getM_score()) ;
                intent.putExtra("profile",arrayList.get(position).getM_profile()) ;
                intent.putExtra("address",arrayList.get(position).getM_address()) ;
                intent.putExtra("number",arrayList.get(position).getM_number()) ;
                intent.putExtra("latitude",arrayList.get(position).getM_latitude()) ;
                intent.putExtra("longitude",arrayList.get(position).getM_longitude()) ;
                v.getContext().startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child("Member").orderByChild("M_name").equalTo(arrayList.get(position).getM_name());

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().child("M_temp").setValue("T");
                            notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_name;
        TextView tv_score;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_score = itemView.findViewById(R.id.tv_score);
        }
    }
}
