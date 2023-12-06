package com.workintech.springmovie.service;

import com.workintech.springmovie.entity.Actor;

import com.workintech.springmovie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if(actorOptional.isPresent()){
            return actorOptional.get();
        }
        throw new RuntimeException("Id is not exist: " + id);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor delete(int id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
        return actor;
    }
}
