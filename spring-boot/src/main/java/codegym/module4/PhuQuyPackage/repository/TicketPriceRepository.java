package codegym.module4.PhuQuyPackage.repository;
import codegym.module4.PhuQuyPackage.model.TicketPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TicketPriceRepository extends CrudRepository<TicketPrice,Long> {
}
