package ar.edu.unju.edm.tpfinalgrupo03.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
