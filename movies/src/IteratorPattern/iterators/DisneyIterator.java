package IteratorPattern.iterators;

import IteratorPattern.companies.Disney;
import IteratorPattern.companies.Movie;

public class DisneyIterator implements MovIterator<Movie>{
    private Disney movie;
    private int currentPos = 0;

    public DisneyIterator(Disney movie)
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
