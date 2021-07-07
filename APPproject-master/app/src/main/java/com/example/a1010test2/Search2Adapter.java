package com.example.a1010test2;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
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

public class Search2Adapter extends RecyclerView.Adapter<Search2Adapter.CustomViewHolder>
{
    RatingBar ratingbar;
    private ArrayList<Search> arrayList;
    private Context context;
    private String input;
    public Search2Adapter(ArrayList<Search> arrayList, Context context, String input) {
        this.arrayList = arrayList;
        this.context = context;
        this.input = input;
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
        System.out.println("********* " + arrayList.get(position).getS_name() + " ****************** vs " + input + " position : " + position);
        if(arrayList.get(position).getS_name().equals(input) )
                {
                    System.out.println("########### " + arrayList.get(position).getS_name() + " ########### vs " + input + " position : " + position);
                    Glide.with(holder.itemView.getContext())
                            .load(arrayList.get(position).getS_profile())
                            .into(holder.iv_profile);
                    holder.tv_name.setText(arrayList.get(position).getS_name());
                    holder.tv_score.setText(String.valueOf(arrayList.get(position).getS_score()));
                    ratingbar.setRating(Float.valueOf(arrayList.get(position).getS_score()));
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ShowCafeActivity.class);
                    intent.putExtra("name",arrayList.get(position).getS_name()) ;
                    intent.putExtra("score",String.valueOf(arrayList.get(position).getS_score())) ;
                    intent.putExtra("profile",arrayList.get(position).getS_profile()) ;
                    intent.putExtra("address",arrayList.get(position).getS_address()) ;
                    intent.putExtra("number",arrayList.get(position).getS_number()) ;
                    intent.putExtra("latitude",arrayList.get(position).getS_latitude()) ;
                    intent.putExtra("longitude",arrayList.get(position).getS_longitude()) ;
                    v.getContext().startActivity(intent);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return true;
                }
            });

        }else
        {
            remove(position);
        }
    }
    public void remove(final int position)
    {
        System.out.println("@@@@@@@@@@@@@@@ " + arrayList.get(position).getS_name() + " @@@@@@@@@@@@@@@ vs " + input + " position : " + position);
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                try
                {
                    arrayList.remove(position);
                    notifyItemRemoved(position);
                    notifyDataSetChanged();
                }catch (IndexOutOfBoundsException ex)
                {
                    ex.printStackTrace();;
                }}
        };
        handler.post(r);
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
