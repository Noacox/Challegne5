package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Score;
import com.usa.misiontic.reto3c3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int Id) {
        return scoreService.getScore(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score c){
        return scoreService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score c){
        return scoreService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return scoreService.delete(id);
    }
}
