import java.util.Iterator;


public class MovIterator<Movie> implements Iterator<Movie> {
    Node<Movie> current;

    // initialize pointer to head of the list for iteration
    public MovIterator(MovieList<Movie> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current movie and update pointer
    public Movie next()
    {
        Movie movie = current.getMovie();
        current = current.getNext();
        return movie;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
