package IteratorPattern.Movies;

import IteratorPattern.iterators.MovIterator;

public class MoviesIterator<Movie> implements MovIterator<Movie> {

    Node<Movie> current;

    public MoviesIterator(MovieList<Movie> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current movie and update pointer
    public Movie getNext()
    {
        Movie movie = current.getMovie();
        current = current.getNext();
        return movie;
    }

    // implement if needed
    public void reset()
    {
        throw new UnsupportedOperationException();
    }
}
