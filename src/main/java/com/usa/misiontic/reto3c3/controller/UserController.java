package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Client;
import com.usa.misiontic.reto3c3.entities.User;
import com.usa.misiontic.reto3c3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public List<User> getAll(){return userService.getAll();}

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int Id) {return userService.getUser(Id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User u){
        return userService.save(u);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User u){
        return userService.update(u);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id)
    {return userService.delete(id);}



}
