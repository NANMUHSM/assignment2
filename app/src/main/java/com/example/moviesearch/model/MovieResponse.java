package com.example.moviesearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("Search")
    private List<Movie> movies;

    @SerializedName("Response")
    private  String response;

    @SerializedName("totalResults")
    private String totalResults;

    public List<Movie> getMovies() {
        return movies;
    }

    public String getResponse() {
        return response;
    }

    public String getTotalResults() {
        return totalResults;
    }
}
