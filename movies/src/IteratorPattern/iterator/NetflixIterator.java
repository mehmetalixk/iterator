package IteratorPattern.iterator;
import IteratorPattern.Util;
import IteratorPattern.movie.Movie;
import IteratorPattern.movie.MovieIterator;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class NetflixIterator  implements MovieIterator<Movie> {

    private ArrayList<Movie> netflixMovies;

    public NetflixIterator() throws Exception {
        this.netflixMovies = Util.csvToArrayList("./movies/data/netflix_final.csv");
    }

    public Iterator<Movie> createIterator() {
        return netflixMovies.iterator();
    }
}
