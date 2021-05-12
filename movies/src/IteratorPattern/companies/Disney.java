package IteratorPattern.companies;

public class Disney implements Movie{

    private String title;
    private String year;
    private String country;
    private String rotten;


    public Disney(String title, String year, String country, String rotten) {
        this.title = title;
        this.year = year;
        this.country = country;
        this.rotten = rotten;
    }
    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getYear(){
        return year;
    }
}
