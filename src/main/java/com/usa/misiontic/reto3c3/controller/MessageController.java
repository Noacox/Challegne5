package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Message;
import com.usa.misiontic.reto3c3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/all")
    public List<Message> getAll() {return messageService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message m) {return messageService.save(m);}

}
