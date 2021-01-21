package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder> {
    private String[] data;
    public MenuListAdapter(String[] data){
        this.data= data;
    }
    @NonNull
    @Override
    public MenuListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        View view= inflater.inflate(R.layout.menu_list, parent, false);
        return new MenuListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListViewHolder holder, int position) {
            String menu_title= data[position];
            holder.title.setText(menu_title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MenuListViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public MenuListViewHolder(View itemView){
            super(itemView);
            img= itemView.findViewById(R.id.menu_image);
            title= itemView.findViewById(R.id.menu_object_title);
        }
    }
}
