package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.Reports.CountClients;
import com.usa.misiontic.reto3c3.Reports.StatusReservations;
import com.usa.misiontic.reto3c3.entities.Message;
import com.usa.misiontic.reto3c3.entities.Reservation;
import com.usa.misiontic.reto3c3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired

    private ReservationService reservationService;

    @RequestMapping("/all")
    public List<Reservation> getAll() {return reservationService.getAll();}

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int Id) {
        return reservationService.getReservation(Id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){return reservationService.save(r);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r){
        return reservationService.update(r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    @GetMapping("/report-status")
    public StatusReservations getReservations(){
        return reservationService.getReportStatusReservations();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return reservationService.getReportsTimeReservations(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClients> getClientes(){
        return reservationService.serviceTopClients();

    }


}
