package dev.elma.reservationservice.repositories;

import dev.elma.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
