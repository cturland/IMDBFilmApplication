package com.cturland;

import java.io.FileReader;
import java.util.ArrayList;
import com.opencsv.CSVReader;

public class MovieDB {
    private String data = "src/com/cturland/data/moviedata.csv";
    private ArrayList<Movie> movies;

    public MovieDB() throws Exception{
        CSVReader reader = new CSVReader(new FileReader(data));
        movies = new ArrayList<>();

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null)  //returns a boolean value
        {
            Movie m = new Movie();
            m.setRank(Integer.parseInt(nextLine[0]));
            m.setName(nextLine[1]);
            m.setYear(Integer.parseInt(nextLine[2]));
            m.setRating(Double.parseDouble(nextLine[3]));
            m.setGenre(nextLine[4]);
            m.setCertificate(nextLine[5]);
            m.setRuntime(nextLine[6]);
            m.setTagline(nextLine[7]);
            m.setBudget(nextLine[8]);
            m.setBoxoffice(nextLine[9]);
            m.setCast(nextLine[10].split(","));
            m.setDirectors(nextLine[11].split(","));
            m.setWriters(nextLine[12].split(","));
            movies.add(m);
        }
        reader.close();
    }

    public void top10Movies(){
        for(int i = 0; i < 10; i++){
            System.out.println(movies.get(i).getRank() + ". " + movies.get(i).getName() + " " + movies.get(i).getRating());
        }
    }

    public void movieAtRank(int rank){
        System.out.println(movies.get(rank).getRank() + ". " + movies.get(rank).getName() + " " + movies.get(rank).getRating());
    }

}
