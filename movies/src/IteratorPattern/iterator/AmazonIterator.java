package IteratorPattern.iterator;
import IteratorPattern.Util;
import IteratorPattern.movie.Movie;
import IteratorPattern.movie.MovieIterator;

import java.util.Iterator;
import java.util.TreeMap;

public class AmazonIterator  implements MovieIterator<Movie> {

    private TreeMap<String, Movie> amazonMovies;

    public AmazonIterator() throws Exception {
        this.amazonMovies = Util.csvToTree("./movies/data/amazon_final.csv");
    }

    public Iterator<Movie> createIterator() {
        return amazonMovies.values().iterator();
    }
}
