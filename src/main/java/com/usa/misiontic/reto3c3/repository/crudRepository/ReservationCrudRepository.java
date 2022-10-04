package com.usa.misiontic.reto3c3.repository.crudRepository;

import com.usa.misiontic.reto3c3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
