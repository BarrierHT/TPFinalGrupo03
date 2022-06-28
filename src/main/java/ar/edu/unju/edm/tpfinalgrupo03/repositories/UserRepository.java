package ar.edu.unju.edm.tpfinalgrupo03.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /*
    Optional<User> findById(long parseLong);

    public List<User> findById(){    
    }
     */

}
