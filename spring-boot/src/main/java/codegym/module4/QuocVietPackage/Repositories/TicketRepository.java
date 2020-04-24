package codegym.module4.QuocVietPackage.Repositories;

import codegym.module4.QuocVietPackage.Entities.ticket;
import codegym.module4.QuocVietPackage.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<ticket, Integer> {
    List<ticket> findByIdUserAndAndStatus(user idUser,String status);

}
