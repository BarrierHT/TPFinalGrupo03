package ar.edu.unju.edm.tpfinalgrupo03.repositories;

import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserMovieRepository extends CrudRepository<UserMovie, Integer> {
}
