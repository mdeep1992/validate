package com.example.validation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class RecyclerActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Vegetable>Vegetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        recyclerView=findViewById(R.id.recycler_view);
        myvegetables();
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(myvegetables());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(callBackMethod);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    ItemTouchHelper.SimpleCallback callBackMethod=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.RIGHT:
                    myvegetables().remove(position);
                    recyclerView.getAdapter().notifyItemRemoved(position);
                    break;

            }

        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {







//           new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
//                   .addSwipeRightLabel("Delete")
//                           .addSwipeRightBackgroundColor(getResources().getColor(R.color.teal_700))
//                                   .addSwipeRightActionIcon(R.drawable.ic_baseline_delete_24)
//                                           .create().decorate();


            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };





    private ArrayList<com.example.validation.Vegetable> myvegetables() {
        ArrayList<Vegetable> vegetables=new ArrayList<>();

   vegetables.add(new Vegetable("carrot","vegetable",100));
        vegetables.add(new Vegetable("carrot","vegetable",100));
        vegetables.add(new Vegetable("carrot","vegetable",100));
        vegetables.add(new Vegetable("radish","vegetable",100));
        vegetables.add(new Vegetable("drumstick","vegetable",100));
        vegetables.add(new Vegetable("carrot","vegetable",100));
        vegetables.add(new Vegetable("brinjal","vegetable",100));
        vegetables.add(new Vegetable("potato","vegetable",100));
        vegetables.add(new Vegetable("tomato","vegetable",100));
        vegetables.add(new Vegetable("beans","vegetable",100));
return vegetables;
    }

}