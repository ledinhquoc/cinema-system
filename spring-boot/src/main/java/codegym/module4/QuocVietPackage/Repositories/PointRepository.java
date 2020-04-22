package codegym.module4.QuocVietPackage.Repositories;

import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PointRepository extends JpaRepository<point, Long> {

    List<point> findByIdUser(user idUser);


    List<point> findByDateCreatBetweenAndIdUser( Date from,Date to, user idUser);
}
