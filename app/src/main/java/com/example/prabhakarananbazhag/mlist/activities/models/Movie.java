package com.example.prabhakarananbazhag.mlist.activities.models;

import java.io.Serializable;

public class Movie implements Serializable{
    String  id;
    String  title;
    String  overview;
    float   voteAverage;
    float   voteCount;
    String  posterPath;
    String  backdropPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }


    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }


    public Movie(String id, String title, String overview, float voteAverage, float voteCount, String posterPath, String backdropPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }
}
