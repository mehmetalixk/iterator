package IteratorPattern.company;

import IteratorPattern.movie.Movie;

public class Hulu implements Movie {

    private String title;
    private String year;
    private String imdb;
    private String language;


    public Hulu(String title, String year, String imdb, String language) {
        this.title = title;
        this.year = year;
        this.imdb = imdb;
        this.language = language;
    }
    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getYear(){
        return year;
    }
}
