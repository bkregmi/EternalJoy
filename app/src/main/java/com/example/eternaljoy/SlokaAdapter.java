package com.example.eternaljoy;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SlokaAdapter extends RecyclerView.Adapter<SlokaAdapter.MyViewHolder>  {
    private List<SlokaList> dataSet;
    private Context myContest;
    private LayoutInflater myInflater;
   // private ItemClickListener myClickListener;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.activity_card_veiw_sloka,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String title=dataSet.get(position).getTitle();
        String sanskrit="";
        String english ="";
        List<Sloka> slokas = dataSet.get(position).getSlokas();
        for(Sloka sloka: slokas){
            sanskrit = sanskrit + "\n" + TextUtils.join("\n",sloka.getSanskrit());
            english = english + "\n" + TextUtils.join("\n",sloka.getEnglish());
        }
        TextView textViewTitle = holder.textViewTitle;
        TextView textViewSanskrit = holder.textViewSanskrit;
        TextView textViewEnglish = holder.textViewEnglish;
        textViewTitle.setText(title);
        textViewSanskrit.setText(sanskrit);
        textViewEnglish.setText(english);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewSanskrit;
        TextView textViewEnglish;
        TextView textViewTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewSanskrit = itemView.findViewById(R.id.textViewSanskrit);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
        }

        @Override
        public void onClick(View v) {

        }
    }
    public SlokaAdapter(Context c, List<SlokaList> data){
        myInflater = LayoutInflater.from(c);
        dataSet = data;
    }
    public String getSloka(){
        return dataSet.toString();
    }
}
