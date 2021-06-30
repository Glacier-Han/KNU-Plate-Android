package com.example.knuplate;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private ArrayList<MenuData> arrayList;

    public MenuAdapter(ArrayList<MenuData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        MenuViewHolder holder = new  MenuViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.menu_item_tv.setText(arrayList.get(position).getMenu_item_name());
        holder.menu_item_pb.setProgress(arrayList.get(position).getMenu_item_pg());

    }


    @Override
    public int getItemCount(){
    // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView menu_item_tv;
        ProgressBar menu_item_pb;

        public MenuViewHolder(@NonNull final View itemView) {
            super(itemView);

            this.menu_item_tv = itemView.findViewById(R.id.menu_item_tv);
            this.menu_item_pb = itemView.findViewById(R.id.menu_item_pb);
        }
    }

}
