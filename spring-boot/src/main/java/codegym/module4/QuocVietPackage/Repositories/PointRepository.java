package codegym.module4.QuocVietPackage.Repositories;

import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PointRepository extends JpaRepository<point, Long> {

    List<point> findByIdUser(user idUser);


    List<point> findByDateCreatBetweenAndIdUserAndAndPointStatus( Date from,Date to, user idUser, String status);


}
