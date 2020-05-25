package stud.kea.lbh.goatsite.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stud.kea.lbh.goatsite.model.Gender;
import stud.kea.lbh.goatsite.model.Goat;

import java.util.Date;


@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {
//    Iterable<Goat> findByName(String name);
    Goat findByName(String name);

    Iterable<Goat> findByGender(Gender gender);

    @Query(value = "SELECT * FROM Goats g WHERE g.id < 4", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();

    Goat findGoatByUsername(String username);



}
