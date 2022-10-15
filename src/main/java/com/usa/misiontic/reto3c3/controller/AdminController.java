package com.usa.misiontic.reto3c3.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Map;

@RestController
public class AdminController {}/*
   @GetMapping("/user")
   public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
       return Collections.singletonMap("name", principal.getAttribute("name"));
   }
}
/*@RequestMapping("/api/Admin")
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



}*/
