package com.example.validation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewholder> {
    private List<Vegetable> Vegetables;

    public RecyclerAdapter(List<Vegetable> vegetables) {
        Vegetables = vegetables;

    }


    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Vegetable vegetable = Vegetables.get(position);
        holder.Name.setText(vegetable.getName());
        holder.Category.setText(("CATAGORY:")+(vegetable.getCategory()));
       holder.price.setText(("RS:")+(String.valueOf(vegetable.getPrice())));
    }

    @Override
    public int getItemCount() {
        return Vegetables.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name, Category, price;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }
    }


}
