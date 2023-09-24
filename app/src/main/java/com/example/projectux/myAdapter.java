package com.example.projectux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter {
    ArrayList<Integer> items;

    public myAdapter(ArrayList<Integer> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_item,parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myViewHolder myViewHolder = (myViewHolder)holder;
        myViewHolder.getCarouselImg().setBackgroundResource(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class myViewHolder extends RecyclerView.ViewHolder {
    private ImageView carouselImg;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        carouselImg = itemView.findViewById(R.id.carouselimg);
    }

    public ImageView getCarouselImg() {
        return carouselImg;
    }

    public void setCarouselImg(ImageView carouselImg) {
        this.carouselImg = carouselImg;
    }
}