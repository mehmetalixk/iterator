package IteratorPattern.iterator;
import IteratorPattern.Util;
import IteratorPattern.movie.Movie;
import IteratorPattern.movie.MovieIterator;

import java.util.HashMap;
import java.util.Iterator;

public class HuluIterator  implements MovieIterator<Movie> {

    private HashMap<String, Movie> huluMovies;

    public HuluIterator() throws Exception {
        this.huluMovies = Util.csvToHashMap("./movies/data/hulu_final.csv");
    }

    public Iterator<Movie> createIterator() {
        return huluMovies.values().iterator();
    }
}
