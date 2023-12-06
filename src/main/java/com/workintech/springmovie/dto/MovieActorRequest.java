package com.workintech.springmovie.dto;

import com.workintech.springmovie.entity.Actor;
import com.workintech.springmovie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieActorRequest {
    private Movie movie;
    private List<Actor> actorList;
}
