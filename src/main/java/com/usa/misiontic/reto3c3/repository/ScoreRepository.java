package com.usa.misiontic.reto3c3.repository;

import com.usa.misiontic.reto3c3.entities.Score;
import com.usa.misiontic.reto3c3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {return (List<Score>) scoreCrudRepository.findAll();}

    public Optional<Score> getScore(int id) {return scoreCrudRepository.findById(id);}

    public Score save (Score s){
        return scoreCrudRepository.save(s);
    }
    public void delete (Score s) {scoreCrudRepository.delete(s);}
}
