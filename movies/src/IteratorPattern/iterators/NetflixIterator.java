package IteratorPattern.iterators;
import IteratorPattern.companies.Movie;
import IteratorPattern.companies.Netflix;

public class NetflixIterator  implements MovIterator<Movie>{

    private Netflix movie;
    private int currentPos = 0;

    public NetflixIterator(Netflix movie)
    {
        this.movie = movie;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Movie getNext() {
        return null;
    }

    @Override
    public void reset() { }
}
