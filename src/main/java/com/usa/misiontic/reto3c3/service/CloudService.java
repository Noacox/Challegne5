package com.usa.misiontic.reto3c3.service;

import com.usa.misiontic.reto3c3.entities.Cloud;
import com.usa.misiontic.reto3c3.repository.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll(){
        return cloudRepository.getAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudRepository.getCloud(id);
    }

    public Cloud save(Cloud c){
        if (c.getId()==null){
            return cloudRepository.save(c);
        }else {
            Optional<Cloud> e = cloudRepository.getCloud(c.getId());
            if(e.isPresent()){
                return c;
            }else{
                return cloudRepository.save(c);
            }
        }
    }

    public Cloud update(Cloud c){

        if (c.getId()!=null){
            Optional<Cloud> q= cloudRepository.getCloud(c.getId());
            if (q.isPresent()){
                if (c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if (c.getBrand()!=null){
                    q.get().setBrand(c.getBrand());
                }
                if (c.getCategory()!=null){
                    q.get().setCategory(c.getCategory());
                }
                if (c.getYear()!=null){
                    q.get().setYear(c.getYear());
                }
                if (c.getDescription()!=null){
                    q.get().setDescription(c.getDescription());
                }
                cloudRepository.save(q.get());
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
            Optional<Cloud> p= cloudRepository.getCloud(id);
            if(p.isPresent()){
                cloudRepository.delete(p.get());
                flag=true;
            }
            return flag;
        }


}
