package IteratorPattern.Movies;

import IteratorPattern.iterators.MovIterator;

public class MovieList<Movie> {
    Node<Movie> head, tail;

    // add new Element at tail of the linked list in O(1)
    public void add(Movie movie)
    {
        Node<Movie> node = new Node<>(movie, null);
        if (head == null)
            tail = head = node;
        else {
            tail.setNext(node);
            tail = node;
        }
    }

    // return Head
    public Node<Movie> getHead()
    {
        return head;
    }

    // return Tail
    public Node<Movie> getTail()
    {
        return tail;
    }

    public MovIterator<Movie> iterator()
    {
        return new MoviesIterator<>(this);
    }
}
