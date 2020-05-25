package stud.kea.lbh.goatsite.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stud.kea.lbh.goatsite.model.Like;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> { }
