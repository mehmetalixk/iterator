package IteratorPattern.iterator;
import IteratorPattern.Util;
import IteratorPattern.movie.Movie;
import IteratorPattern.movie.MovieIterator;

import java.util.Iterator;
import java.util.Stack;

public class DisneyIterator  implements MovieIterator<Movie> {

    private Stack<Movie> disneyMovies;

    public DisneyIterator() throws Exception {
        this.disneyMovies = Util.csvToStack("./movies/data/disney_final.csv");
    }

    public Iterator<Movie> createIterator() {
        return disneyMovies.iterator();
    }
}
