package com.usa.misiontic.reto3c3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer score;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cloud")
    @JsonIgnoreProperties({"score","messages"})
    private List<Reservation> reservations;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cloud")
    @JsonIgnoreProperties({"score"})
    private List<Message> messages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
