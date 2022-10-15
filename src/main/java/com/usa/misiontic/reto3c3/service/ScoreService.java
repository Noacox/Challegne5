package com.usa.misiontic.reto3c3.service;

import com.usa.misiontic.reto3c3.entities.Score;
import com.usa.misiontic.reto3c3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {return scoreRepository.getAll();}

    public Optional<Score> getScore(int id) {return  scoreRepository.getScore(id);}

    public Score save(Score s){
        if (s.getId()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> e =scoreRepository.getScore(s.getId());
            if(e.isPresent()){
                return s;
            }else{
                return scoreRepository.save(s);
            }
        }
    }
    public Score update(Score s){

        if (s.getId()!=null){
            Optional<Score> q= scoreRepository.getScore(s.getId());
            if (q.isPresent()) {
                if (s.getScore() != null) {
                    q.get().setScore(s.getScore());
                }
                scoreRepository.save(q.get());
                return q.get();
            }
            else{
                return s;
            }
        }else{
            return s;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Score> p= scoreRepository.getScore(id);
        if(p.isPresent()) {
            scoreRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}

