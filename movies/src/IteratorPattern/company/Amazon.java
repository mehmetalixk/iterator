package IteratorPattern.company;

import IteratorPattern.movie.Movie;

public class Amazon implements Movie {

    private String title;
    private String year;
    private String type;
    private String runtime;


    public Amazon(String title, String year, String type, String runtime) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.runtime = runtime;
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
        return String.format(title + "," + year+ "," +type+ "," +runtime );
    }
}
