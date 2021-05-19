package IteratorPattern.company;

import IteratorPattern.movie.Movie;

public class Netflix implements Movie {

    private String title;
    private String year;
    private String age;
    private String language;

    public Netflix(String title, String year, String age, String language) {
        this.title = title;
        this.year = year;
        this.age = age;
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

    @Override
    public String toString() {
        return title + "<" + year + "<" + age + "<" + language;
    }
}
