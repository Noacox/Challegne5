package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Message;
import com.usa.misiontic.reto3c3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/all")
    public List<Message> getAll() {return messageService.getAll();}
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int Id) {
        return messageService.getMessage(Id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message m) {return messageService.save(m);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message m){
        return messageService.update(m);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }
}
