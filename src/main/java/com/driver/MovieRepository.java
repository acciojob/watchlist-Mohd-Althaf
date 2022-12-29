package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> moviesDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    public String addmovie(Movie movie){
        moviesDb.put(movie.getName(),movie);
        return "success";
    }

    public String addDirector(Director director){
        directorDb.put(director.getName(),director);
        return "success";
    }

    public String addMovieDirectorPair(String movie,String director){
        if(movieDirectorDb.containsKey(director))
            movieDirectorDb.get(director).add(movie);
        else {
            movieDirectorDb.put(director, new ArrayList<>());
            movieDirectorDb.get(director).add(movie);
        }
        return "success";

    }

    public Movie getMovieByName(String name){
        if(moviesDb.containsKey(name))
            return moviesDb.get(name);
        return null;
    }

    public Director getDirectorByName(String name){
        if(directorDb.containsKey(name))
            return directorDb.get(name);
        return null;
    }
    public List<String> getMoviesByDirector(String director){
        return movieDirectorDb.getOrDefault(director,null);
    }

    public List<String> getAllMoviesAdded(){
        List<String> list = new ArrayList<>();
        for(String s:moviesDb.keySet()){
            list.add(s);
        }
        return list;
    }

    public String deleteDirector(String director){
       if(directorDb.containsKey(director)){
           if(movieDirectorDb.containsKey(director)){
               List<String> m = movieDirectorDb.get(director);
               for(String s:m){
                    moviesDb.remove(s);
               }
               movieDirectorDb.remove(director);
           }
           directorDb.remove(director);
       }
       return "success";
    }

    public String deleteAllDirectors(){
        for(String director:directorDb.keySet()){
            if(movieDirectorDb.containsKey(director)){
                List<String> list = movieDirectorDb.get(director);
                for(String m :list){
                    moviesDb.remove(m);
                }
                movieDirectorDb.remove(director);
            }
            directorDb.remove(director);
        }
        return "success";
    }

}
