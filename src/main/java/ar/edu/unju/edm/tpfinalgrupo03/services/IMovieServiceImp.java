package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.MovieRepository;

@Service
public class IMovieServiceImp implements IMovieService {

    private static final Log LOGGER = LogFactory.getLog(IMovieServiceImp.class);

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void saveMovie(Movie incomingMovie) {
        movieRepository.save(incomingMovie);
    }

    @Override
    public List<Movie> getMovies() {

        List<Movie> auxList = new ArrayList<>();
        List<Movie> auxList2 = new ArrayList<>();

        auxList = (List<Movie>) movieRepository.findAll();

        for (int i = 0; i < auxList.size(); i++) {
            if (auxList.get(i).getStatus()) {
                auxList2.add(auxList.get(i));
            }
        }

        return auxList2;

    }

    @Override
    public void editMovie(Movie incomingMovie) {


        Movie movieSaved = movieRepository.findById(incomingMovie.getId()).get();
        movieSaved.setTitle(incomingMovie.getTitle());
        movieSaved.setMovieType(incomingMovie.getMovieType());
        movieSaved.setDescription(incomingMovie.getDescription());
        movieSaved.setSaleDuration(incomingMovie.getSaleDuration());
        movieSaved.setCover(incomingMovie.getCover());

        movieRepository.save(movieSaved);
    }

    @Override
    public void deleteMovie(Integer id) throws Exception {

        LOGGER.info("Movie id: " + id);

        Movie movieDeleted = movieRepository.findById(id).orElseThrow(() -> new Exception("Movie not found"));
        movieDeleted.setStatus(false);

        movieRepository.save(movieDeleted);
    }

    @Override
    public Movie getMovie(Integer id) throws Exception {

        Movie movieFound = new Movie();
        movieFound = movieRepository.findById(id).orElseThrow(() -> new Exception("Movie not found"));
        return movieFound;
    }
}
