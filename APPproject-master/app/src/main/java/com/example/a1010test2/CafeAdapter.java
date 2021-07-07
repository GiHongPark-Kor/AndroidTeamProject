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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.CustomViewHolder>
{
    RatingBar ratingbar;
    private ArrayList<Cafe> arrayList;
    private Context context;
    public CafeAdapter(ArrayList<Cafe> arrayList, Context context) {
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
                .load(arrayList.get(position).getC_profile())
                .into(holder.iv_profile);
        holder.tv_name.setText(arrayList.get(position).getC_name());
        holder.tv_score.setText(String.valueOf(arrayList.get(position).getC_score()));
        ratingbar.setRating(Float.valueOf(arrayList.get(position).getC_score()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ShowCafeActivity.class);
                intent.putExtra("name",arrayList.get(position).getC_name()) ;
                intent.putExtra("score",String.valueOf(arrayList.get(position).getC_score())) ;
                intent.putExtra("profile",arrayList.get(position).getC_profile()) ;
                intent.putExtra("address",arrayList.get(position).getC_address()) ;
                intent.putExtra("number",arrayList.get(position).getC_number()) ;
                intent.putExtra("latitude",arrayList.get(position).getC_latitude()) ;
                intent.putExtra("longitude",arrayList.get(position).getC_longitude()) ;

//                intent.putExtra("num",arrayList.get(v.getId()).getR_profile()) ;
//                String curName = holder.tv_name.getText().toString();
//                Toast.makeText(v.getContext(),curName,Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
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
