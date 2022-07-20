package jana60.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jana60.model.Degree;

@Repository
public interface DegreeRepository extends CrudRepository <Degree, Integer> {

	
}