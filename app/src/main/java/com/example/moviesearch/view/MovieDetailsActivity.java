package com.example.moviesearch.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.moviesearch.R;
import com.example.moviesearch.databinding.ItemDetailLayoutBinding;
import com.example.moviesearch.viewmodel.MovieViewModel;

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String API_KEY = "d40b7945";
    private MovieViewModel movieViewModel;
    private ItemDetailLayoutBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //binding UI
        binding = ItemDetailLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //initial viewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        //get imdbID
        String imdbID = getIntent().getStringExtra("imdbID");
        Log.d("MovieDetailsActivity", "Received imdbID: " + imdbID);
        if(imdbID != null){
            movieViewModel.getMovieDetails(imdbID,API_KEY);
        }

        //liveData and update UI
        movieViewModel.getMovieDetail().observe(this,movie -> {
            if(movie != null){
                binding.titleTxt.setText(movie.getTitle());
                binding.descriptionText.setText(movie.getPlot());
                binding.ratingText.setText("Rated: " +movie.getRated());
                Glide.with(this).load(movie.getPoster()).into(binding.imageview);
            }
        });



    }
}
