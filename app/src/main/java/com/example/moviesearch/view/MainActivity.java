package com.example.moviesearch.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesearch.R;
import com.example.moviesearch.model.Movie;
import com.example.moviesearch.viewmodel.MovieViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "d40b7945";
    private MovieViewModel movieViewModel;
    private  MyAdapter movieAdapter;
    private EditText searchMoviesBox;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding UI
        searchMoviesBox = findViewById(R.id.et_search);
        searchBtn = findViewById(R.id.button);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //initial viewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        //set recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MyAdapter(new ArrayList<Movie>(), movie -> {
            Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
            intent.putExtra("imdbID", movie.getImdbID());
            startActivity(intent);
        });
        recyclerView.setAdapter(movieAdapter);

        //search event
        searchBtn.setOnClickListener(v -> {
            String query = searchMoviesBox.getText().toString().trim();
            if(!query.isEmpty()){
                movieViewModel.searchMovies(query,API_KEY);
            }else {
                Toast.makeText(this,"Please enter movie's title",Toast.LENGTH_SHORT).show();
            }
        });

        //LiveData and update recycleView
        movieViewModel.getMovies().observe(this,movies -> {
            if(movies != null && !movies.isEmpty()){
                movieAdapter.setMovies(movies);
            }else {
                Toast.makeText(MainActivity.this,"movie not found",Toast.LENGTH_SHORT).show();
            }
        });

    }
}