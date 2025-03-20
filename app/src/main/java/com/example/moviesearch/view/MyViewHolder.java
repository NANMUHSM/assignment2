package com.example.moviesearch.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesearch.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView movieImage;
    public TextView movieTitle,movieDescription;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImage = itemView.findViewById(R.id.imageview);
        movieTitle = itemView.findViewById(R.id.title_txt);
        movieDescription = itemView.findViewById(R.id.description_text);
    }
}
