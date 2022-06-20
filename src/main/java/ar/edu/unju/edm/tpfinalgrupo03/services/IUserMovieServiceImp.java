package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.UserMovieRepository;

@Service
public class IUserMovieServiceImp implements IUserMovieService {

    private static final Log LOGGER = LogFactory.getLog(IUserMovieServiceImp.class);

    @Autowired
    UserMovie userMovie;

    @Autowired
    UserMovieRepository userMovieRepository;

    @Override
    public UserMovie newUserMovie() {
        return userMovie;
    }

    @Override
    public void saveUserMovie(UserMovie userMovie) {
        userMovieRepository.save(userMovie);

    }

    @Override
    public List<UserMovie> getUserMovies() {
        return (List<UserMovie>) userMovieRepository.findAll();

    } // get User List

    @Override
    public void editUserMovie(UserMovie userMovie) {

    }

    @Override
    public void deleteUserMovie(Integer id) throws Exception {

    }

    @Override
    public UserMovie getUserMovie(Integer id) throws Exception {
        return userMovieRepository.findById(id).orElseThrow(() -> new Exception("UserMovie not found"));
    }
}
