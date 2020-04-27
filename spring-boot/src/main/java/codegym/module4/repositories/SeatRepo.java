package codegym.module4.repositories;

import codegym.module4.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SeatRepo extends JpaRepository<Seat,Integer>
{
}
