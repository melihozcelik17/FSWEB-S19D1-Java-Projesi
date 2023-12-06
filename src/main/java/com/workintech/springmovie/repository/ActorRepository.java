package com.workintech.springmovie.repository;

import com.workintech.springmovie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
