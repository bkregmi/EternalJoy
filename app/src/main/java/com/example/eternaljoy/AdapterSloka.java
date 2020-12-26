package com.example.eternaljoy;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class AdapterSloka extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<SlokaData> data= Collections.emptyList();
    SlokaData current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterSloka(Context context, List<SlokaData> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_sloka, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }
    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        SlokaData current=data.get(position);
        myHolder.textFishName.setText(current.getSlokaId());
        myHolder.textSize.setText(TextUtils.join("\n", current.getSanskrit()));
        myHolder.textType.setText(TextUtils.join("\n", current.getEnglish()));
        //myHolder.textPrice.setTex(current.getMeaningOfSloka());
       // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
    }
    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{

        TextView textFishName;
        ImageView ivFish;
        TextView textSize;
        TextView textType;
        TextView textPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            textType = (TextView) itemView.findViewById(R.id.textType);
            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }
    }
}
