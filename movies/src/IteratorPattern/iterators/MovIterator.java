package IteratorPattern.iterators;

public interface MovIterator<Movie>{
        boolean hasNext();
        Movie getNext();
        void reset();
}
