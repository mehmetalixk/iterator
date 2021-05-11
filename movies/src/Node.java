
public class Node<Movie> {
    Movie movie;
    Node<Movie> next;
    public Node(Movie movie, Node<Movie> next)
    {
        this.movie = movie;
        this.next = next;
    }

    // Setter getter methods for movie and Next Pointer
    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public void setNext(Node<Movie> next)
    {
        this.next = next;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public Node<Movie> getNext()
    {
        return next;
    }
}