package com.example.moviesearch.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Description")
    private String description;

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String poster;

    //for movie details page

    @SerializedName("Plot")
    private  String plot;

    @SerializedName("Rated")
    private  String rated;

    @SerializedName("Response")
    private String response;

    //getters and setters

    public String getImdbID() {
        return imdbID;
    }


    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    @NonNull
    public String getTitle() {
        return title != null? title:"N/A";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public String getYear() {
        return year != null? "unknown Year": year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getResponse() {
        return response;
    }

}
