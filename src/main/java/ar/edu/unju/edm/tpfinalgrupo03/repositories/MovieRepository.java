package ar.edu.unju.edm.tpfinalgrupo03.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
