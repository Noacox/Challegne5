package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Reservation;
import com.usa.misiontic.reto3c3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired

    private ReservationService reservationService;

    @RequestMapping("all")
    public List<Reservation> getAll() {return reservationService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){return reservationService.save(r);}



}
