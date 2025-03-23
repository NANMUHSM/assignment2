package com.example.moviesearch.view;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesearch.R;
import com.example.moviesearch.databinding.ItemLayoutBinding;
import com.example.moviesearch.model.Movie;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ItemLayoutBinding binding;


    public MyViewHolder(ItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(Movie movie, MyAdapter.OnItemClickListener listener) {
        binding.titleTxt.setText(movie.getTitle());
        binding.descriptionText.setText(movie.getDescription());

        Glide.with(binding.getRoot().getContext())
                .load(movie.getPoster())
                .into(binding.imageview);

        binding.getRoot().setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(movie);
            }
        });
    }
}
