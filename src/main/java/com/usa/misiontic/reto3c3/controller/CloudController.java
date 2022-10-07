package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Cloud;
import com.usa.misiontic.reto3c3.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Cloud")
public class CloudController {
    @Autowired
    private CloudService cloudService;

    @RequestMapping("/all")
    public List<Cloud> getAll(){
        return cloudService.getAll();
    }

    @PostMapping("/save")
    public Cloud save(@RequestBody Cloud c){
        return cloudService.save(c);
    }

}
