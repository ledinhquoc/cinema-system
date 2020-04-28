package codegym.module4.repositories;

import codegym.module4.entities.MovieSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieScheduleRepo extends JpaRepository<MovieSchedule,Integer>
{
}