package codegym.module4.repositories;

import codegym.module4.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepo extends JpaRepository<Point,Integer>
{
}
