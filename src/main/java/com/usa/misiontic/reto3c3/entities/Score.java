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
    @Column(name="score" , length = 1, nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name="reservationid")
    @JsonIgnoreProperties("scores")
    private Reservation reservation;

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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
