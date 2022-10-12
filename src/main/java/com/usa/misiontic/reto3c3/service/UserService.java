package com.usa.misiontic.reto3c3.service;

import com.usa.misiontic.reto3c3.entities.User;
import com.usa.misiontic.reto3c3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {return userRepository.getAll();}

    public Optional<User> getUser(int id){return userRepository.getUser(id);}

    public User save(User c){
        if (c.getIdUser()==null){
            return userRepository.save(c);
        }else {
            Optional<User> e = userRepository.getUser(c.getIdUser());
            if(e.isPresent()){
                return c;
            }else{
                return userRepository.save(c);
            }
        }
    }

    public User update(User c){

        if (c.getIdUser()!=null){
            Optional<User> q= userRepository.getUser(c.getIdUser());
            if (q.isPresent()){
                if (c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if (c.getEmail()!=null){
                    q.get().setEmail(c.getEmail());
                }
                if (c.getPassword()!=null){
                    q.get().setPassword(c.getPassword());
                }
                userRepository.save(q.get());
                return q.get();
            } else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<User> p= userRepository.getUser(id);
        if(p.isPresent()){
            userRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
