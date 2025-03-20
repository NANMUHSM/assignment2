package com.example.moviesearch.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesearch.R;
import com.example.moviesearch.model.Movie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Movie> movies;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Movie movie);
    }

    public MyAdapter( List<Movie> movies,OnItemClickListener listener) {
        this.movies = movies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieTitle.setText(movie.getTitle());
        holder.movieDescription.setText(movie.getDescription());

        Glide.with(holder.itemView.getContext()).load(movie.getPoster()).into(holder.movieImage);
        holder.itemView.setOnClickListener(v -> {
            if(listener != null && movie != null){
                listener.onItemClick(movie);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }
}
