package codegym.module4.repositories;

import codegym.module4.entities.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TicketPriceRepo extends CrudRepository<TicketPrice,Long>
{
}
