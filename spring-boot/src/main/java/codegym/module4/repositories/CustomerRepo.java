package codegym.module4.repositories;

import codegym.module4.entities.Customer;
import codegym.module4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
    @Query("select c from Customer c WHERE c.id =?1")

    Customer findByIdL(Integer id);

//    @Query("delete from Customer c where c.id=?1")
//    void deleteById(Integer id);

    @Query("select c from Customer c where c.id =?1")
    Customer findByIdC(int id);

}
