package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Cloud;
import com.usa.misiontic.reto3c3.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cloud")
public class CloudController {
    @Autowired
    private CloudService cloudService;

    @RequestMapping("/all")
    public List<Cloud> getAll(){
        return cloudService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id") int Id) {
        return cloudService.getCloud(Id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud c){
        return cloudService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud c){
        return cloudService.update(c);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cloudService.delete(id);
    }
}
