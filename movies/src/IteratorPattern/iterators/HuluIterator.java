package IteratorPattern.iterators;

import IteratorPattern.companies.Hulu;
import IteratorPattern.companies.Movie;

public class HuluIterator implements MovIterator<Movie>{

    private Hulu movie;
    private int currentPos = 0;

    public HuluIterator(Hulu movie)
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
