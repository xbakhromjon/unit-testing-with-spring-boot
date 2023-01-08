package uz.bakhromjon.unittestingwithspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.unittestingwithspringboot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "select * from users as u where u.name = :name",
            nativeQuery = true)
    User findByName(String name);
}
