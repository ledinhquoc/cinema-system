package codegym.module4.repositories;

import codegym.module4.entities.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepo extends JpaRepository<Row,Integer>
{
}
