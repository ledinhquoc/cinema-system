package codegym.module4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import codegym.module4.entities.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}