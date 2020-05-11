package codegym.module4.controllers;

import codegym.module4.entities.Movie;
import codegym.module4.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> findAllMovie() {
        List<Movie> movies = movieService.findAll();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/movies/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> getMovieById(
            @PathVariable("id") Integer movie_id) {
        Optional<Movie> movie = movieService.findById(movie_id);

        if (!movie.isPresent()) {
            return new ResponseEntity<>(movie.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movie.get(), HttpStatus.OK) ;

    }
}
