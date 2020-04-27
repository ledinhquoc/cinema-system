package codegym.module4.repositories;

import codegym.module4.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role,Integer>
{
}
