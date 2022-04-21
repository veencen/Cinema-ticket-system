package edu.hanu.sqaproject.repository;

import edu.hanu.sqaproject.model.Reservation;
import edu.hanu.sqaproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}