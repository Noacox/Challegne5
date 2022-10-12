package com.usa.misiontic.reto3c3.service;

import com.usa.misiontic.reto3c3.Reports.CountClients;
import com.usa.misiontic.reto3c3.Reports.StatusReservations;
import com.usa.misiontic.reto3c3.entities.Reservation;
import com.usa.misiontic.reto3c3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){return reservationRepository.getAll();}
    public Optional<Reservation> getReservation(int id) {return reservationRepository.getReservation(id);}

    public Reservation save(Reservation c){
        if (c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else {
            Optional<Reservation> e = reservationRepository.getReservation(c.getIdReservation());
            if(e.isPresent()){
                return c;
            }else{
                return reservationRepository.save(c);
            }
        }
    }

    public Reservation update(Reservation c){

        if (c.getIdReservation()!=null){
            Optional<Reservation> q= reservationRepository.getReservation(c.getIdReservation());
            if (q.isPresent()){
                if (c.getStartDate()!=null){
                    q.get().setStartDate(c.getStartDate());
                }
                if (c.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(c.getDevolutionDate());
                }
                reservationRepository.save(q.get());
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
        Optional<Reservation> p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

    public StatusReservations getReportStatusReservations(){
        List<Reservation>completed= reservationRepository.ReservationStatus("completed");
        List<Reservation>cancelled= reservationRepository.ReservationStatus("cancelled");
        return new StatusReservations(completed.size(), cancelled.size());
    }

    public List<Reservation> getReportsTimeReservations(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservationTime(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }

    public List<CountClients> serviceTopClients(){
        return reservationRepository.getTopClients();
    }

}
