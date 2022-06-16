package ar.edu.unju.edm.tpfinalgrupo03.repository;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;

public interface MovieRepository extends CrudRepository <Movie, Integer> {
    
}
