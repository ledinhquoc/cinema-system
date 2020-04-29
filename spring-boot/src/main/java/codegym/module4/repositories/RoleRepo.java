package codegym.module4.repositories;

import codegym.module4.entities.Role;
import codegym.module4.jwt.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer>
{
    //Vu add : Start
    Optional<Role> findByName(ERole name);
    //End
}
