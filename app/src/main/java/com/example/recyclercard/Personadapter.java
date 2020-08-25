package com.example.recyclercard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class Personadapter extends RecyclerView.Adapter <Personadapter.ViewHolder>{

    private ArrayList<Person> people;
    Itemclicked activity;
    public  interface  Itemclicked
    {
        void onitemclicked(int index);
    }
    public Personadapter(Context context, ArrayList<Person> list)
    {
        activity = (Itemclicked) context;
        people = list;
    }
    //IT defines those components which we want to change
    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onitemclicked(people.indexOf((Person) v.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public Personadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Personadapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvname.setText(people.get(position).getName());

    }

    @Override
    public int getItemCount() {

        return people.size();
    }
}
