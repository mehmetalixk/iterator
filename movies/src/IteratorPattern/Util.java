package IteratorPattern;

import IteratorPattern.company.*;
import IteratorPattern.movie.Movie;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class Util {

    public static HashMap<String, Movie> csvToHashMap(String path) throws Exception {
        HashMap<String, Movie> dataset = new HashMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row;
        csvReader.readNext();
        while ((row = csvReader.readNext()) != null)
            dataset.put(row[0], new Hulu(row[1], row[2], row[3], row[4]));

        return dataset;
    }

    public static ArrayList<Movie> csvToArrayList(String path) throws Exception {
        ArrayList<Movie> dataset = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row;
        while ((row = csvReader.readNext()) != null) {
            Netflix n = new Netflix(row[1], row[2], row[3], row[4]);
            dataset.add(n);
        }

        return dataset;
    }

    public static TreeMap<String, Movie> csvToTree(String path) throws Exception {
        TreeMap<String, Movie> dataset = new TreeMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row;
        csvReader.readNext();
        while ((row = csvReader.readNext()) != null)
            dataset.put(row[0], new Amazon(row[1], row[2], row[3], row[4]));

        return dataset;
    }

    public static Stack<Movie> csvToStack(String path) throws Exception {
        Stack<Movie> dataset = new Stack<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row;
        while ((row = csvReader.readNext()) != null)
            dataset.push(new Disney(row[1], row[2], row[3], row[4]));

        return dataset;
    }
}
