import com.opencsv.CSVReader;

import java.io.*;
import java.util.*;

public class Movies {

    public static void main(String ... args) throws Exception {

        MovieList<Movie> movies = new MovieList<>();
        HashMap<String, HashMap<String, String >> netflix = csvToHashMap("./movies/data/netflix.csv");
        ArrayList<List<String>> hbo = csvToArrayList("./movies/data/hbo.csv");
        TreeMap<String, TreeMap<String, String>> hulu = csvToTree("./movies/data/stream.csv");

        String fName = null;
        for (Map.Entry<String, TreeMap<String, String>> e : hulu.entrySet()) {

            if(e.getValue().get("Disney+").equals("1"))
                fName = "Disney+";
            else if(e.getValue().get("Netflix").equals("1"))
                fName = "Netflix";
            else if(e.getValue().get("Hulu").equals("1"))
                fName = "Hulu";
            else if(e.getValue().get("Prime Video").equals("1"))
                fName = "PrimeVideo";

            writeToCSV(e.getValue(), fName);
        }

    }

    public static void writeToCSV(TreeMap<String, String> entry, String fName) throws IOException {
        FileWriter csvWriter = new FileWriter("./movies/data/" + fName + "_fixed.csv", true);
        csvWriter.append(String.join(",", entry.values()));
        csvWriter.append("\n");
        csvWriter.close();
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
            TreeMap<String, String> subData = new TreeMap<>();
            for (int i=1; i<firstRow.length;i++)
                subData.put(firstRow[i], row[i]);
            dataset.put(row[0], subData);
        }
        return dataset;
    }

    public static ArrayList<List<String>> csvToHeap(String path) throws Exception {
        ArrayList<List<String>> dataset = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        while ((row = csvReader.readLine()) != null){
            String[] data = row.split(",");
            dataset.add(Arrays.asList(data));
        }
        return dataset;
    }
}