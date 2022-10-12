package com.usa.misiontic.reto3c3.repository;

import com.usa.misiontic.reto3c3.Reports.CountClients;
import com.usa.misiontic.reto3c3.entities.Client;
import com.usa.misiontic.reto3c3.entities.Reservation;
import com.usa.misiontic.reto3c3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){return (List<Reservation>) reservationCrudRepository.findAll();}

    public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);}

    public Reservation save(Reservation r){return reservationCrudRepository.save(r);}

    public void delete(Reservation r){reservationCrudRepository.delete(r);}

    public List<Reservation> ReservationStatus (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> ReservationTime (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<CountClients> getTopClients(){
        List<CountClients> res=new ArrayList<>();
        List<Object[]>report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            res.add(new CountClients((Long)report.get(i)[1],(Client) report.get(i)[0]));

        }
        return res;
    }


}

