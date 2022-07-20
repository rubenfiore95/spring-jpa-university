package jana60.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jana60.model.Degree;
import jana60.model.Insegnanti;

@Repository
public interface InsegnantiRepository extends CrudRepository <Insegnanti, Integer> {

	
}