package IteratorPattern.Movies;

import IteratorPattern.companies.*;
import IteratorPattern.iterators.MovIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Movies {

    public static void main(String ... args) throws Exception {

        MovieList<Movie> movies = new MovieList<>();

        ArrayList<Movie> netflixes = new ArrayList<>();
        ArrayList<Movie> disneys = new ArrayList<>();
        ArrayList<Movie> amazons = new ArrayList<>();
        ArrayList<Movie> hulus = new ArrayList<>();

        ArrayList<List<String>> netflix = csvToArrayList("./movies/data/netflix_final.csv");
        ArrayList<List<String>> hulu = csvToArrayList("./movies/data/hulu_final.csv");
        ArrayList<List<String>> disney = csvToArrayList("./movies/data/disney_final.csv");
        ArrayList<List<String>> amazon = csvToArrayList("./movies/data/amazon_final.csv");

        itemizer(netflix, netflixes, "netflix");
        itemizer(hulu, hulus, "hulu");
        itemizer(disney, disneys, "disney");
        itemizer(amazon, amazons, "amazon");

        for(Movie net: netflixes)
            movies.add(net);
        for(Movie net: hulus)
            movies.add(net);
        for(Movie net: disneys)
            movies.add(net);
        for(Movie net: amazons)
            movies.add(net);
        MovIterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()){
            Movie mov = iterator.getNext();
            System.out.println(mov.getTitle() + mov.getYear());
        }

    }

    public static void itemizer(ArrayList<List<String>> data, ArrayList<Movie> dataset, String company){
        switch (company) {
            case "netflix":
                for (List<String> item : data)
                    dataset.add(new Netflix(item.get(1), item.get(2), item.get(3), item.get(4)));
                break;
            case "hulu":
                for (List<String> item : data)
                    dataset.add(new Hulu(item.get(1), item.get(2), item.get(3), item.get(4)));
                break;
            case "disney":
                for (List<String> item : data)
                    dataset.add(new Disney(item.get(1), item.get(2), item.get(3), item.get(4)));
                break;
            case "amazon":
                for (List<String> item : data)
                    dataset.add(new Amazon(item.get(1), item.get(2), item.get(3), item.get(4)));
                break;
        }
    }

    public static void fixDataSet(ArrayList<List<String>> data) throws Exception {
        List<String[]> netflix = new ArrayList<>();
        List<String[]> hulu = new ArrayList<>();
        List<String[]> amazon = new ArrayList<>();
        List<String[]> disney = new ArrayList<>();

        String[] firstRow = data.get(0).toArray(String[]::new);

        String[] array = new String[5];
        System.arraycopy(firstRow, 1, array, 0, 3);
        array[3] = firstRow[4];
        array[4] = firstRow[15];
        netflix.add(array);

        array = new String[5];
        System.arraycopy(firstRow, 1, array, 0, 3);
        array[3] = firstRow[5];
        array[4] = firstRow[15];
        hulu.add(array);

        array = new String[5];
        System.arraycopy(firstRow, 1, array, 0, 3);
        array[3] = firstRow[13];
        array[4] = firstRow[16];
        amazon.add(array);

        array = new String[5];
        System.arraycopy(firstRow, 1, array, 0, 3);
        array[3] = firstRow[14];
        array[4] = firstRow[6];
        disney.add(array);

        for (List<String> row: data){
            String[] arr = row.toArray(String[]::new);
            String[] net = new String[5];
            if(row.get(7).equals("1")){
                System.arraycopy(arr, 1, net, 0, 3);
                net[3] = arr[4];
                net[4] = arr[15];
                netflix.add(net);
            }
            else if(row.get(8).equals("1")){
                System.arraycopy(arr, 1, net, 0, 3);
                net[3] = arr[5];
                net[4] = arr[15];
                hulu.add(net);
            }
            else if(row.get(9).equals("1")){
                System.arraycopy(arr, 1, net, 0, 3);
                net[3] = arr[13];
                net[4] = arr[16];
                amazon.add(net);
            }
            else if(row.get(10).equals("1")){
                System.arraycopy(arr, 1, net, 0, 3);
                net[3] = arr[14];
                net[4] = arr[6];
                disney.add(net);
            }
        }

        csvWriter(netflix, "netflix");
        csvWriter(hulu, "hulu");
        csvWriter(amazon, "amazon");
        csvWriter(disney, "disney");
    }

    public static void csvWriter(List<String[]> data, String filename) throws Exception
    {
        try (var fos = new FileOutputStream("./movies/data/"+ filename +"_final.csv");
             var osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             var writer = new CSVWriter(osw)) {
            writer.writeAll(data);
        }
    }

    public static HashMap<String, HashMap<String, String>> csvToHashMap(String path) throws Exception {
        HashMap<String, HashMap<String, String>> dataset = new HashMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row, firstRow;
        firstRow = csvReader.readNext();
        while ((row = csvReader.readNext()) != null){
            HashMap<String, String> subData = new HashMap<>();
            for (int i=1; i<firstRow.length;i++)
                subData.put(firstRow[i], row[i]);
            dataset.put(row[0], subData);
        }
        return dataset;
    }

    public static ArrayList<List<String>> csvToArrayList(String path) throws Exception {
        ArrayList<List<String>> dataset = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row;
        while ((row = csvReader.readNext()) != null){
            dataset.add(Arrays.asList(row));
        }
        return dataset;
    }

    public static TreeMap<String, TreeMap<String, String>> csvToTree(String path) throws Exception {
        TreeMap<String, TreeMap<String, String>> dataset = new TreeMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row, firstRow;
        firstRow = csvReader.readNext();
        while ((row = csvReader.readNext()) != null){
            System.out.println(Arrays.toString(row));
            TreeMap<String, String> subData = new TreeMap<>();
            for (int i=1; i<firstRow.length;i++)
                subData.put(firstRow[i], row[i]);
            dataset.put(row[0], subData);
        }
        return dataset;
    }

    public static Stack<String[]> csvToStack(String path) throws Exception {
        Stack<String []> dataset = new Stack<>();
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] row;
        while ((row = csvReader.readNext()) != null){
            dataset.push(row);
        }
        return dataset;
    }
}