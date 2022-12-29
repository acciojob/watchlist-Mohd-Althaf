package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public String addMovie(Movie movie){
        String res = repository.addmovie(movie);
        return res;
    }

    public String addDirector(Director director){
        String res = repository.addDirector(director);
        return res;
    }

    public String addMovieDirector(String movie,String director){
        String res = repository.addMovieDirectorPair(movie,director);
        return res;
    }

    public Movie getMovieByName(String name){
        Movie res = repository.getMovieByName(name);
        return res;
    }

    public Director getDirectorByName(String name){
        Director res = repository.getDirectorByName(name);
        return res;
    }

    public List<String> getMoviesByDirectorName(String name){
        List<String> res = repository.getMoviesByDirector(name);
        return res;
    }

    public List<String> getAllMovies(){
        List<String> res = repository.getAllMoviesAdded();
        return res;
    }

    public String deleteDirectorByName(String name){
        String res = repository.deleteDirector(name);
        return res;
    }

    public String deleteAllDirectors(){
        String res = repository.deleteAllDirectors();
        return res;
    }

}
