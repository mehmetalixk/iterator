package IteratorPattern;

import IteratorPattern.iterator.*;
import IteratorPattern.movie.Movie;

import java.util.Iterator;

public class Main {
    public static void main(String ... args) throws Exception {
        NetflixIterator netflixIterator = new NetflixIterator();
        HuluIterator huluIterator = new HuluIterator();
        DisneyIterator disneyIterator = new DisneyIterator();
        AmazonIterator amazonIterator = new AmazonIterator();

        Iterator<Movie> i_netflix = netflixIterator.createIterator();
        Iterator<Movie> i_hulu = huluIterator.createIterator();
        Iterator<Movie> i_disney = disneyIterator.createIterator();
        Iterator<Movie> i_amazon = amazonIterator.createIterator();

        printTheMovies(i_netflix, "Netflix");
        printTheMovies(i_hulu, "Hulu");
        printTheMovies(i_disney, "Disney");
        printTheMovies(i_amazon, "Amazon");

    }

    public static void printTheMovies(Iterator<Movie> iterator, String company) {
        while(iterator.hasNext()) {
            Movie movie = iterator.next();
            System.out.println(company + ": " + movie.getTitle() + " - " + movie.getYear());
        }
    }

}