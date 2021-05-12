package IteratorPattern.iterators;

import IteratorPattern.companies.Amazon;
import IteratorPattern.companies.Movie;

public class AmazonIterator implements MovIterator<Movie>{

    private Amazon movie;
    private int currentPos = 0;

    public AmazonIterator(Amazon movie)
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
