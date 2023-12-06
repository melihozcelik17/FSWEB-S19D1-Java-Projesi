package com.workintech.springmovie.controller;

import com.workintech.springmovie.dto.ActorResponse;
import com.workintech.springmovie.dto.MovieActorRequest;
import com.workintech.springmovie.dto.MovieResponse;
import com.workintech.springmovie.entity.Actor;
import com.workintech.springmovie.entity.Movie;
import com.workintech.springmovie.service.ActorService;
import com.workintech.springmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("localhost:8080")
@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;
    private ActorService actorService;

    @Autowired
    public MovieController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @PostMapping("/")
    public MovieResponse save(@RequestBody MovieActorRequest movieActorRequest) {
        Movie movie = movieActorRequest.getMovie();
        List<Actor> actorList = movieActorRequest.getActorList();

        for (Actor actor : actorList) {
            movie.addActor(actor);
        }
        Movie savedMovie = movieService.save(movie);
        return new MovieResponse(savedMovie.getId(), savedMovie.getName(), savedMovie.getDirectorName(),
                savedMovie.getRating(), savedMovie.getReleaseDate());
    }

    @GetMapping("/{movieId}")
    public MovieResponse find(@PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);

        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : movie.getActorList()) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
                    actor.getGender().name(), actor.getBirthDate()));
        }

        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate(), actorResponses);
    }

    @PutMapping("/addActor/{movieId}")
    public MovieResponse addActor(@PathVariable int movieId, @RequestBody Actor actor) {
        Movie movie = movieService.findById(movieId);
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return new MovieResponse(savedMovie.getId(), savedMovie.getName(), savedMovie.getDirectorName(),
                savedMovie.getRating(), savedMovie.getReleaseDate());

//        actor.addMovie(movieService.findById(movieId));
//        actorService.save(actor);
    }
}
