package com.usa.misiontic.reto3c3.repository;

import com.usa.misiontic.reto3c3.entities.User;
import com.usa.misiontic.reto3c3.repository.crudRepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {return (List<User>) userCrudRepository.findAll();}

    public Optional<User> getUser(int id) {return userCrudRepository.findById(id);}

    public User save(User user) {return userCrudRepository.save(user);}

    public void delete(User user){userCrudRepository.delete(user);}
}
