package ar.edu.unju.edm.tpfinalgrupo03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;

@Service
public interface IMovieService{

    public void saveMovie(Movie incomingMovie); 

    public List<Movie> getMovies(); 

    public void editMovie(Movie incomingMovie);

    public void deleteMovie(Integer id) throws Exception;

    public Movie getMovie(Integer id) throws Exception;
}
