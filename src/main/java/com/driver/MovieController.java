package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {


    @Autowired
    MovieService service;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String res = service.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String res = service.addDirector(director);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,String director){
        String res = service.addMovieDirector(movie,director);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie res = service.getMovieByName(name);
        if(res!=null){
            return new ResponseEntity<>(res,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director){
        Director res = service.getDirectorByName(director);
        if(res!=null)
            return new ResponseEntity<>(res,HttpStatus.FOUND);
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name") String director){
        List<String> res = service.getMoviesByDirectorName(director);
        if(res==null)
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> res = service.getAllMovies();
        if (res==null) return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        String res = service.deleteDirectorByName(name);
        if(res==null) return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String res = service.deleteAllDirectors();
        if(res==null) return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }
}
