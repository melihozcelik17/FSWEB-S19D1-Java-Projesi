package com.workintech.springmovie.service;

import com.workintech.springmovie.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(int id);
    Actor save(Actor actor);
    Actor delete(int id);
}
