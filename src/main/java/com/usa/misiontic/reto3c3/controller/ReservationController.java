package com.usa.misiontic.reto3c3.controller;

import com.usa.misiontic.reto3c3.entities.Reservation;
import com.usa.misiontic.reto3c3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired

    private ReservationService reservationService;

    @RequestMapping("all")
    public List<Reservation> getAll() {return reservationService.getAll();}

    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation r){return reservationService.save(r);}



}
